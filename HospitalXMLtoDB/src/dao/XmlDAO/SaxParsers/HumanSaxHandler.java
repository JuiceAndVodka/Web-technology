package dao.XmlDAO.SaxParsers;

import bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class HumanSaxHandler extends DefaultHandler{

    private List<Human> humansList = new ArrayList<Human>();
    private Human human;
    private Disease disease;
    private StringBuilder text;

    public List<Human> getHumansList()
    {
        return humansList;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Human"))
        {
            human = new Human("", "", "", "", "", "", "", "");
        }
        if(qName.equals("MedicalWorker"))
        {
            human = new MedicalWorker("", "", "", "", "", "", "", "","","","","");
        }
        if(qName.equals("Doctor"))
        {
            human = new Doctor("", "", "", "", "", "", "", "","","","","","","",0);
        }
        if(qName.equals("HeadPhysician"))
        {
            human = new HeadPhysician("", "", "", "", "", "", "", "","","","","","","","");
        }
        if(qName.equals("Nurse"))
        {
            human = new Nurse("", "", "", "", "", "", "", "","","","","","","",0,0);
        }
        if(qName.equals("Intern"))
        {
            human = new Intern("", "", "", "", "", "", "", "","","","","","",0,0);
        }
        if(qName.equals("Patient"))
        {
            human = new Patient("", "", "", "", "", "", "", "",0,null);
        }
        if(qName.equals("Disease"))
        {
            disease = new Disease("", "", 0, "", "", false);
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void endElement(String uri,String localName,String qName)
    {
        if (disease != null) {
            DiseaseTagName diseaseTagName = DiseaseTagName.valueOf(qName.toUpperCase().replace("DS:", ""));
            switch (diseaseTagName) {
                case ID:
                    disease.setId(Integer.parseInt(text.toString()));
                    break;
                case NAME:
                    disease.setName((text.toString()));
                    break;
                case WHENSTARTED:
                    disease.setWhenStarted(text.toString());
                    break;
                case DURATION:
                    disease.setDuration(Integer.parseInt(text.toString()));
                    break;
                case PATIENTCOMPLAINTS:
                    disease.setPatientComplaints(text.toString());
                    break;
                case PRESCRIBEDTREATMENT:
                    disease.setPrescribedTreatment(text.toString());
                    break;
                case WASTREATMENTSUCCESS:
                    disease.setWasTreatmentSuccess(Boolean.parseBoolean(text.toString()));
                    break;
            }
        }
        else {
            HumanTagName tagName = HumanTagName.valueOf(qName.toUpperCase().replace("-", "_"));
            switch (tagName) {
                case ID:
                    human.setId(Integer.parseInt(text.toString()));
                    break;
                case NAME:
                    human.setName(text.toString());
                    break;
                case SURNAME:
                    human.setSurname(text.toString());
                    break;
                case PATRONYMIC:
                    human.setPatronymic(text.toString());
                    break;
                case GENDER:
                    human.setGender(text.toString());
                    break;
                case HOMEADRESS:
                    human.setHomeAdress(text.toString());
                    break;
                case BIRTHDAY:
                    human.setBirthDay(text.toString());
                    break;
                case PHONENUMBER:
                    human.setPhoneNumber(text.toString());
                    break;
                case DEPARTMENTNAME:
                    human.setDepartmentName(text.toString());
                    break;
                case DIPLOMAPROFESSION:
                    if (!(human instanceof Patient))
                        ((MedicalWorker)human).setDiplomaProfession(text.toString());
                    break;
                case WORKPHONENUMBER:
                    if (!(human instanceof Patient))
                        ((MedicalWorker)human).setWorkPhoneNumber(text.toString());
                    break;
                case UNIVERSITYNAME:
                    if (!(human instanceof Patient))
                        ((MedicalWorker)human).setUniversityName(text.toString());
                    break;
                case UNIVERSITYENDED:
                    if (!(human instanceof Patient))
                        ((MedicalWorker)human).setUniversityEnded(text.toString());
                    break;
                case CURRENTPOST:
                    if (human instanceof Doctor)
                        ((Doctor)human).setCurrentPost(text.toString());
                    if (human instanceof Nurse)
                        ((Nurse)human).setCurrentPost(text.toString());
                    break;
                case STARTEDWORKING:
                    if (human instanceof Doctor)
                        ((Doctor)human).setStartedWorking(text.toString());
                    if (human instanceof HeadPhysician)
                        ((HeadPhysician)human).setStartedWorking(text.toString());
                    if (human instanceof Nurse)
                        ((Nurse)human).setStartedWorking(text.toString());
                    break;
                case PATIENTSHEALED:
                    ((Doctor)human).setPatientsHealed(Integer.parseInt(text.toString()));
                    break;
                case ENDEDNWORKING:
                    ((HeadPhysician)human).setEndedWorking(text.toString());
                    break;
                case FUTUREPLANSFORHOSPITAL:
                    ((HeadPhysician)human).setFuturePlansForHospital(text.toString());
                    break;
                case INJECTIONSDID:
                    ((Nurse)human).setInjectionsDid(Integer.parseInt(text.toString()));
                    break;
                case PATIENTSSAVED:
                    ((Nurse)human).setPatientsSaved(Integer.parseInt(text.toString()));
                    break;
                case INTERNSHIPSTARTED:
                    ((Intern)human).setInternshipStarted(text.toString());
                    break;
                case INTERNSHIPDAYS:
                    ((Intern)human).setInternshipDays(Integer.parseInt(text.toString()));
                    break;
                case MISTAKESMADE:
                    ((Intern)human).setMistakesMade(Integer.parseInt(text.toString()));
                    break;
                case WARDNUMBER:
                    ((Patient)human).setWardNumber(Integer.parseInt(text.toString()));
                    break;
                case DISEASE:
                    ((Patient)human).setCurrentDisease(disease);
                    disease = null;
                    break;
                case HUMAN:
                case MEDICALWORKER:
                case DOCTOR:
                case HEADPHYSICIAN:
                case NURSE:
                case INTERN:
                case PATIENT:
                    humansList.add(human);
                    human = null;
                    break;
            }
        }
    }

    public void warning(SAXParseException exception)
    {

    }

    public void error(SAXParseException exception){

    }

    public void fatalError(SAXParseException exception){

    }
}

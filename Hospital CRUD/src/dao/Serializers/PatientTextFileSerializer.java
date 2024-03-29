package dao.Serializers;

import bean.Disease;
import bean.Human;
import bean.Patient;

/**
 * Класс текстового сериализатора объекта класса {@link Patient}, реализующий
 * интерфейс {@link HumanTextFileSerializer} и содержащий в себе сериализатор и десериализатор
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class PatientTextFileSerializer implements HumanTextFileSerializer {

    /** Поле символа для разделения полей объекта */
    private String fieldsDelimiter = "#";

    /**
     * Преобразует поля передаваемого объекта в нужное строковое представление для сериализации
     * @param human передаваемый объект для сериализации типа {@link Human}
     * @return строковое представление передаваемого объекта для сериализации
     */
    public String serializeHuman(Human human)
    {
        if(!(human instanceof Patient))
            return null;

        Patient patient = (Patient)human;

        String string = "Patient" + fieldsDelimiter +
                        patient.getId() + fieldsDelimiter +
                        patient.getName() + fieldsDelimiter +
                        patient.getSurname() + fieldsDelimiter +
                        patient.getPatronymic() + fieldsDelimiter +
                        patient.getGender() + fieldsDelimiter +
                        patient.getHomeAdress() + fieldsDelimiter +
                        patient.getBirthDay() + fieldsDelimiter +
                        patient.getPhoneNumber() + fieldsDelimiter +
                        patient.getDepartmentName() + fieldsDelimiter +
                        patient.getWardNumber() + fieldsDelimiter +
                        "Disease" + fieldsDelimiter +
                        patient.getCurrentDisease().getName() + fieldsDelimiter +
                        patient.getCurrentDisease().getWhenStarted() + fieldsDelimiter +
                        patient.getCurrentDisease().getDuration() + fieldsDelimiter +
                        patient.getCurrentDisease().getPatientComplaints() + fieldsDelimiter +
                        patient.getCurrentDisease().getPrescribedTreatment() + fieldsDelimiter +
                        patient.getCurrentDisease().getWasTreatmentSuccess() + fieldsDelimiter;

        return string;
    }

    /**
     * Преобразует передаваемую строку в нужный объект (десериализации)
     * @param stringHuman строковое представление десериализуемого объекта
     * @return объект типа {@link Human}
     */
    public Human deserializeHuman(String stringHuman)
    {
        String[] patientFields = stringHuman.split(fieldsDelimiter);

        if(patientFields.length != 18) {
            return null;
        }

        Disease disease = new Disease(patientFields[12], patientFields[13], Integer.parseInt(patientFields[14]),
                                      patientFields[15], patientFields[16], Boolean.parseBoolean(patientFields[17]));

        Patient patient = new Patient(patientFields[2], patientFields[3], patientFields[4], patientFields[5],
                                      patientFields[6], patientFields[7], patientFields[8], patientFields[9],
                                      Integer.parseInt(patientFields[10]), disease);

        patient.setId(Integer.parseInt(patientFields[1]));

        return patient;
    }
}

package dao.Serializers;

import bean.Nurse;
import bean.Human;

public class NurseTextFileSerializer implements HumanTextFileSerializer{

    private String fieldsDelimiter = "#";

    public String serializeHuman(Human human)
    {
        if(!(human instanceof Nurse))
            return null;

        Nurse nurse = (Nurse) human;

        String string = "Nurse" + fieldsDelimiter +
                        nurse.getId() + fieldsDelimiter +
                        nurse.getName() + fieldsDelimiter +
                        nurse.getSurname() + fieldsDelimiter +
                        nurse.getPatronymic() + fieldsDelimiter +
                        nurse.getGender() + fieldsDelimiter +
                        nurse.getHomeAdress() + fieldsDelimiter +
                        nurse.getBirthDay() + fieldsDelimiter +
                        nurse.getPhoneNumber() + fieldsDelimiter +
                        nurse.getDepartmentName() + fieldsDelimiter +
                        nurse.getDiplomaProfession() + fieldsDelimiter +
                        nurse.getWorkPhoneNumber() + fieldsDelimiter +
                        nurse.getUniversityName() + fieldsDelimiter +
                        nurse.getUniversityEnded() + fieldsDelimiter +
                        nurse.getCurrentPost() + fieldsDelimiter +
                        nurse.getStartedWorking() + fieldsDelimiter +
                        nurse.getInjectionsDid() + fieldsDelimiter +
                        nurse.getPatientsSaved() + fieldsDelimiter;

        return string;
    }

    public Human deserializeHuman(String stringHuman)
    {
        String[] nurseFields = stringHuman.split(fieldsDelimiter);

        if(nurseFields.length != 18) {
            return null;
        }

        Nurse nurse = new Nurse(nurseFields[2], nurseFields[3], nurseFields[4],
                                nurseFields[5], nurseFields[6], nurseFields[7],
                                nurseFields[8], nurseFields[9], nurseFields[10],
                                nurseFields[11], nurseFields[12], nurseFields[13],
                                nurseFields[14], nurseFields[15], Integer.parseInt(nurseFields[16]),
                                Integer.parseInt(nurseFields[17]));

        nurse.setId(Integer.parseInt(nurseFields[1]));

        return nurse;
    }
}

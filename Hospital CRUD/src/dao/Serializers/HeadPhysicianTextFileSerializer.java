package dao.Serializers;

import bean.HeadPhysician;
import bean.Human;

public class HeadPhysicianTextFileSerializer implements HumanTextFileSerializer {

    private String fieldsDelimiter = "#";

    public String serializeHuman(Human human)
    {
        if(!(human instanceof HeadPhysician))
            return null;

        HeadPhysician headPhysician = (HeadPhysician)human;

        String string = "HeadPhysician" + fieldsDelimiter +
                headPhysician.getId() + fieldsDelimiter +
                headPhysician.getName() + fieldsDelimiter +
                headPhysician.getSurname() + fieldsDelimiter +
                headPhysician.getPatronymic() + fieldsDelimiter +
                headPhysician.getGender() + fieldsDelimiter +
                headPhysician.getHomeAdress() + fieldsDelimiter +
                headPhysician.getBirthDay() + fieldsDelimiter +
                headPhysician.getPhoneNumber() + fieldsDelimiter +
                headPhysician.getDepartmentName() + fieldsDelimiter +
                headPhysician.getDiplomaProfession() + fieldsDelimiter +
                headPhysician.getWorkPhoneNumber() + fieldsDelimiter +
                headPhysician.getUniversityName() + fieldsDelimiter +
                headPhysician.getUniversityEnded() + fieldsDelimiter +
                headPhysician.getStartedWorking() + fieldsDelimiter +
                headPhysician.getEndedWorking() + fieldsDelimiter +
                headPhysician.getFuturePlansForHospital() + fieldsDelimiter;

        return string;
    }

    public Human deserializeHuman(String stringHuman)
    {
        String[] headPhysicianFields = stringHuman.split(fieldsDelimiter);

        if(headPhysicianFields.length != 17) {
            return null;
        }

        HeadPhysician headPhysician = new HeadPhysician(headPhysicianFields[2], headPhysicianFields[3], headPhysicianFields[4],
                                                        headPhysicianFields[5], headPhysicianFields[6], headPhysicianFields[7],
                                                        headPhysicianFields[8], headPhysicianFields[9], headPhysicianFields[10],
                                                        headPhysicianFields[11], headPhysicianFields[12], headPhysicianFields[13],
                                                        headPhysicianFields[14], headPhysicianFields[15], headPhysicianFields[16]);

        headPhysician.setId(Integer.parseInt(headPhysicianFields[1]));

        return headPhysician;
    }
}

package dao.Serializers;

import bean.Human;
import bean.Intern;

public class InternTextFileSerializer implements HumanTextFileSerializer{

    private String fieldsDelimiter = "#";

    public String serializeHuman(Human human)
    {
        if(!(human instanceof Intern))
            return null;

        Intern intern = (Intern) human;

        String string = "Intern" + fieldsDelimiter +
                        intern.getId() + fieldsDelimiter +
                        intern.getName() + fieldsDelimiter +
                        intern.getSurname() + fieldsDelimiter +
                        intern.getPatronymic() + fieldsDelimiter +
                        intern.getGender() + fieldsDelimiter +
                        intern.getHomeAdress() + fieldsDelimiter +
                        intern.getBirthDay() + fieldsDelimiter +
                        intern.getPhoneNumber() + fieldsDelimiter +
                        intern.getDepartmentName() + fieldsDelimiter +
                        intern.getDiplomaProfession() + fieldsDelimiter +
                        intern.getWorkPhoneNumber() + fieldsDelimiter +
                        intern.getUniversityName() + fieldsDelimiter +
                        intern.getUniversityEnded() + fieldsDelimiter +
                        intern.getInternshipStarted() + fieldsDelimiter +
                        intern.getInternshipDays() + fieldsDelimiter +
                        intern.getMistakesMade() + fieldsDelimiter;

        return string;
    }

    public Human deserializeHuman(String stringHuman)
    {
        String[] internFields = stringHuman.split(fieldsDelimiter);

        if(internFields.length != 17) {
            return null;
        }

        Intern intern = new Intern(internFields[2], internFields[3], internFields[4],
                                   internFields[5], internFields[6], internFields[7],
                                   internFields[8], internFields[9], internFields[10],
                                   internFields[11], internFields[12], internFields[13],
                                   internFields[14], Integer.parseInt(internFields[15]), Integer.parseInt(internFields[16]));

        intern.setId(Integer.parseInt(internFields[1]));

        return intern;
    }
}

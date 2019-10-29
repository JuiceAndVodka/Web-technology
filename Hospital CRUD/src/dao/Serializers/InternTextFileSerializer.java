package dao.Serializers;

import bean.Human;
import bean.Intern;

/**
 * Класс текстового сериализатора объекта класса {@link Intern}, реализующий
 * интерфейс {@link HumanTextFileSerializer} и содержащий в себе сериализатор и десериализатор
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class InternTextFileSerializer implements HumanTextFileSerializer{

    /** Поле символа для разделения полей объекта */
    private String fieldsDelimiter = "#";

    /**
     * Преобразует поля передаваемого объекта в нужное строковое представление для сериализации
     * @param human передаваемый объект для сериализации типа {@link Human}
     * @return строковое представление передаваемого объекта для сериализации
     */
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

    /**
     * Преобразует передаваемую строку в нужный объект (десериализации)
     * @param stringHuman строковое представление десериализуемого объекта
     * @return объект типа {@link Human}
     */
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

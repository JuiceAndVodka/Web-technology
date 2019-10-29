package dao.Serializers;

import bean.Doctor;
import bean.Human;

/**
 * Класс текстового сериализатора объекта класса {@link Doctor}, реализующий
 * интерфейс {@link HumanTextFileSerializer} и содержащий в себе сериализатор и десериализатор
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class DoctorTextFileSerializer implements HumanTextFileSerializer {

    /** Поле символа для разделения полей объекта */
    private String fieldsDelimiter = "#";

    /**
     * Преобразует поля передаваемого объекта в нужное строковое представление для сериализации
     * @param human передаваемый объект для сериализации типа {@link Human}
     * @return строковое представление передаваемого объекта для сериализации
     */
    public String serializeHuman(Human human)
    {
        if(!(human instanceof Doctor))
            return null;

        Doctor doctor = (Doctor) human;

        String string = "Doctor" + fieldsDelimiter +
                        doctor.getId() + fieldsDelimiter +
                        doctor.getName() + fieldsDelimiter +
                        doctor.getSurname() + fieldsDelimiter +
                        doctor.getPatronymic() + fieldsDelimiter +
                        doctor.getGender() + fieldsDelimiter +
                        doctor.getHomeAdress() + fieldsDelimiter +
                        doctor.getBirthDay() + fieldsDelimiter +
                        doctor.getPhoneNumber() + fieldsDelimiter +
                        doctor.getDepartmentName() + fieldsDelimiter +
                        doctor.getDiplomaProfession() + fieldsDelimiter +
                        doctor.getWorkPhoneNumber() + fieldsDelimiter +
                        doctor.getUniversityName() + fieldsDelimiter +
                        doctor.getUniversityEnded() + fieldsDelimiter +
                        doctor.getCurrentPost() + fieldsDelimiter +
                        doctor.getStartedWorking() + fieldsDelimiter +
                        doctor.getPatientsHealed() + fieldsDelimiter;


        return string;
    }

    /**
     * Преобразует передаваемую строку в нужный объект (десериализации)
     * @param stringHuman строковое представление десериализуемого объекта
     * @return объект типа {@link Human}
     */
    public Human deserializeHuman(String stringHuman)
    {
        String[] doctorFields = stringHuman.split(fieldsDelimiter);

        if(doctorFields.length != 17) {
            return null;
        }

        Doctor doctor = new Doctor(doctorFields[2], doctorFields[3], doctorFields[4],
                                  doctorFields[5], doctorFields[6], doctorFields[7],
                                  doctorFields[8], doctorFields[9], doctorFields[10],
                                  doctorFields[11], doctorFields[12], doctorFields[13],
                                  doctorFields[14], doctorFields[15], Integer.parseInt(doctorFields[16]));

        doctor.setId(Integer.parseInt(doctorFields[1]));

        return doctor;
    }
}

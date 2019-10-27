package dao.Serializers;

import bean.Doctor;
import bean.Human;

public class DoctorTextFileSerializer implements HumanTextFileSerializer {

    private String fieldsDelimiter = "#";

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

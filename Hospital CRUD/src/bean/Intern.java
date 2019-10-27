package bean;

public class Intern extends MedicalWorker
{
    private String InternshipStarted;
    private int InternshipDays;
    private int MistakesMade;

    public  Intern()
    {
        this.InternshipStarted = "11.12.2000";
        this.InternshipDays = 2000;
        this.MistakesMade = 2;
    }

    public  Intern(String name, String surname, String patronymic, String gender, String homeAdress,
                   String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                   String workPhoneNumber, String universityName, String universityEnded, String internshipStarted,
                   int internshipDays, int mistakesMade)
    {
        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber,
                departmentName, diplomaProfession, workPhoneNumber, universityName, universityEnded);

        this.InternshipStarted = internshipStarted;
        this.InternshipDays = internshipDays;
        this.MistakesMade = mistakesMade;
    }

    public String getInternshipStarted() {
        return InternshipStarted;
    }

    public void setInternshipStarted(String internshipStarted) {
        InternshipStarted = internshipStarted;
    }

    public int getInternshipDays() {
        return InternshipDays;
    }

    public void setInternshipDays(int internshipDays) {
        InternshipDays = internshipDays;
    }

    public int getMistakesMade() {
        return MistakesMade;
    }

    public void setMistakesMade(int mistakesMade) {
        MistakesMade = mistakesMade;
    }

    @Override
    public String toString()
    {
        String string = "Name: " + this.getName() + "\n" +
                        "Surname: " + this.getSurname() + "\n" +
                        "Patronymic: " + this.getPatronymic() + "\n" +
                        "Gender: " + this.getGender() + "\n" +
                        "Birthday: " + this.getBirthDay() + "\n" +
                        "HomeAdress: " + this.getHomeAdress() + "\n" +
                        "PhoneNumber: " + this.getPhoneNumber() + "\n" +
                        "DepartmentName: " + this.getDepartmentName() + "\n" +
                        "DiplomaProfession: " + this.getDiplomaProfession() + "\n" +
                        "WorkPhoneNumber: " + this.getWorkPhoneNumber() + "\n" +
                        "UniversityName: " + this.getUniversityName() + "\n" +
                        "UniversityEnded: " + this.getUniversityEnded() + "\n" +
                        "InternshipStarted: " + this.InternshipStarted + "\n" +
                        "InternshipDays: " + this.InternshipDays + "\n" +
                        "MistakesMade: " + this.MistakesMade + "\n\n";

        return string;
    }
}

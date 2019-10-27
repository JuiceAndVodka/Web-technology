package bean;

public class Doctor extends MedicalWorker
{
    private String CurrentPost;
    private String StartedWorking;
    private int PatientsHealed;

    public  Doctor() {

        this.CurrentPost = "Therapist";
        this.StartedWorking = "31.12.1980";
        this.PatientsHealed = 0;
    }

    public  Doctor(String name, String surname, String patronymic, String gender, String homeAdress,
                   String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                   String workPhoneNumber, String universityName, String universityEnded, String currentPost,
                   String startedWorking, int patientsHealed) {

        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber,
                departmentName, diplomaProfession, workPhoneNumber, universityName, universityEnded);

        this.CurrentPost = currentPost;
        this.StartedWorking = startedWorking;
        this.PatientsHealed = patientsHealed;
    }

    public String getCurrentPost() {
        return CurrentPost;
    }

    public void setCurrentPost(String currentPost) {
        CurrentPost = currentPost;
    }

    public String getStartedWorking() {
        return StartedWorking;
    }

    public void setStartedWorking(String startedWorking) {
        StartedWorking = startedWorking;
    }

    public int getPatientsHealed() {
        return PatientsHealed;
    }

    public void setPatientsHealed(int patientsHealed) {
        PatientsHealed = patientsHealed;
    }

    @Override
    public String toString() {

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
                        "CurrentPost: " + this.CurrentPost + "\n" +
                        "StartedWorking: " + this.StartedWorking + "\n" +
                        "PatientsHealed: " + this.PatientsHealed + "\n\n";

        return string;
    }
}

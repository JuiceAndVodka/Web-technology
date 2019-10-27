package bean;

public class Nurse extends MedicalWorker {

    private String CurrentPost;
    private String StartedWorking;
    private int InjectionsDid;
    private int PatientsSaved;

    public Nurse()
    {
        this.CurrentPost = "Procedure nurse";
        this.StartedWorking = "31.12.1992";
        this.InjectionsDid = 100;
        this.PatientsSaved = 4;
    }

    public Nurse(String name, String surname, String patronymic, String gender, String homeAdress,
                         String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                         String workPhoneNumber, String universityName, String universityEnded, String currentPost,
                         String startedWorking, int injectionsDid, int patientsSaved) {

        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber,
                departmentName, diplomaProfession, workPhoneNumber, universityName, universityEnded);

        this.CurrentPost = currentPost;
        this.StartedWorking = startedWorking;
        this.InjectionsDid = injectionsDid;
        this.PatientsSaved = patientsSaved;
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

    public int getInjectionsDid() {
        return InjectionsDid;
    }

    public void setInjectionsDid(int injectionsDid) {
        InjectionsDid = injectionsDid;
    }

    public int getPatientsSaved() {
        return PatientsSaved;
    }

    public void setPatientsSaved(int patientsSaved) {
        PatientsSaved = patientsSaved;
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
                        "CurrentPost: " + this.CurrentPost + "\n" +
                        "StartedWorking: " + this.StartedWorking + "\n" +
                        "InjectionsDid: " + this.InjectionsDid + "\n" +
                        "PatientsSaved" + this.PatientsSaved + "\n\n";

        return string;
    }
}

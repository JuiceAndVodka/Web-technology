package bean;

public class MedicalWorker extends Human {

    private String DiplomaProfession;
    private String WorkPhoneNumber;
    private String UniversityName;
    private String UniversityEnded;

    public MedicalWorker() {

        this.DiplomaProfession = "Therapist";
        this.WorkPhoneNumber = "+375-33-4444444";
        this.UniversityName = "VSMU";
        this.UniversityEnded = "31.12.1990";
    }

    public  MedicalWorker (String name, String surname, String patronymic, String gender, String homeAdress,
                           String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                           String workPhoneNumber, String universityName, String universityEnded) {

        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber, departmentName);

        this.DiplomaProfession = diplomaProfession;
        this.WorkPhoneNumber = workPhoneNumber;
        this.UniversityName = universityName;
        this.UniversityEnded = universityEnded;
    }

    public String getDiplomaProfession() {
        return DiplomaProfession;
    }

    public void setDiplomaProfession(String diplomaProfession) {
        DiplomaProfession = diplomaProfession;
    }

    public String getWorkPhoneNumber() {
        return WorkPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        WorkPhoneNumber = workPhoneNumber;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public String getUniversityEnded() {
        return UniversityEnded;
    }

    public void setUniversityEnded(String universityEnded) {
        UniversityEnded = universityEnded;
    }
}

package bean;

public class HeadPhysician extends MedicalWorker
{
    private String StartedWorking;
    private String EndedWorking;
    private String FuturePlansForHospital;

    public  HeadPhysician()
    {
        this.StartedWorking = "22.11.1933";
        this.EndedWorking = "Still working";
        this.FuturePlansForHospital = "Add new department";
    }

    public  HeadPhysician(String name, String surname, String patronymic, String gender, String homeAdress,
                          String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                          String workPhoneNumber, String universityName, String universityEnded, String startedWork,
                          String endedWorking, String futurePlansForHospital)
    {
        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber,
                departmentName, diplomaProfession, workPhoneNumber, universityName, universityEnded);

        this.StartedWorking = startedWork;
        this.EndedWorking = endedWorking;
        this.FuturePlansForHospital = futurePlansForHospital;
    }

    public String getStartedWorking() {
        return StartedWorking;
    }

    public void setStartedWorking(String startedWork) {
        StartedWorking = startedWork;
    }

    public String getEndedWorking() {
        return EndedWorking;
    }

    public void setEndedWorking(String endedWorking) {
        EndedWorking = endedWorking;
    }

    public String getFuturePlansForHospital() {
        return FuturePlansForHospital;
    }

    public void setFuturePlansForHospital(String futurePlansForHospital) {
        FuturePlansForHospital = futurePlansForHospital;
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
                        "StartedWorking: " + this.StartedWorking + "\n" +
                        "EndedWorking: " + this.EndedWorking + "\n" +
                        "FuturePlansForHospital: " + this.FuturePlansForHospital + "\n\n";

        return string;
    }
}

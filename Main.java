package com.company;

import java.io.Console;
import java.util.Date;
import java.util.List;

public class Main
{

    enum DoctorsPost = {}

    class Human
    {
        private String Name;
        private String Surname;
        private String Patronymic;
        private String HomeAdress;
        private Date BirthDay;
        private String PhoneNumber;
        private String DepartmentName;

        public void setName (String name)
        {
            Name = name;
        }

        public String getName()
        {
            return Name;
        }

        public void setSurname (String surname)
        {
            Surname = surname;
        }

        public String getSurname()
        {
            return Surname;
        }

        public void setPatronymic(String patronymic)
        {
            Patronymic = patronymic;
        }

        public  String getPatronymic()
        {
            return Patronymic;
        }

        public String getHomeAdress() {
            return HomeAdress;
        }

        public void setHomeAdress(String homeAdress) {
            HomeAdress = homeAdress;
        }

        public Date getBirthDay() {
            return BirthDay;
        }

        public void setBirthDay(Date birthDay) {
            BirthDay = birthDay;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public String getDepartmentName() {
            return DepartmentName;
        }

        public void setDepartmentName(String departmentName) {
            DepartmentName = departmentName;
        }

    }

    class Disease
    {
        private String Name;
        private Date WhenStarted;
        private Integer Duration;
        private String PatientComplaints;
        private String PrescribedTreatment;
        private Boolean WasTreatmentSuccess;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public Date getWhenStarted() {
            return WhenStarted;
        }

        public void setWhenStarted(Date whenStarted) {
            WhenStarted = whenStarted;
        }

        public Integer getDuration() {
            return Duration;
        }

        public void setDuration(Integer duration) {
            Duration = duration;
        }

        public String getPatientComplaints() {
            return PatientComplaints;
        }

        public void setPatientComplaints(String patientComplaints) {
            PatientComplaints = patientComplaints;
        }

        public String getPrescribedTreatment() {
            return PrescribedTreatment;
        }

        public void setPrescribedTreatment(String prescribedTreatment) {
            PrescribedTreatment = prescribedTreatment;
        }

        public Boolean getWasTreatmentSuccess() {
            return WasTreatmentSuccess;
        }

        public void setWasTreatmentSuccess(Boolean wasTreatmentSuccess) {
            WasTreatmentSuccess = wasTreatmentSuccess;
        }

    }

    class Patient extends  Human
    {
        private List<Disease> DiseaseHistory;
        private Integer WardNumber;

        public List<Disease> getDiseaseHistory() {
            return DiseaseHistory;
        }

        public void addToDiseaseHistory(Disease disease) {
            DiseaseHistory.add(disease);
        }

        public Integer getWardNumber() {
            return WardNumber;
        }

        public void setWardNumber(Integer wardNumber) {
            WardNumber = wardNumber;
        }

    }

    class Doctor extends  Human
    {
        private DoctorsPost CurrentPost;
        private Date StartedWorking;
        private Boolean DoesDepartmentHead;

        public DoctorsPost getCurrentPost() {
            return CurrentPost;
        }

        public void setCurrentPost(DoctorsPost currentPost) {
            CurrentPost = currentPost;
        }

        public Date getStartedWorking() {
            return StartedWorking;
        }

        public void setStartedWorking(Date startedWorking) {
            StartedWorking = startedWorking;
        }

        public Boolean getDoesDepartmentHead() {
            return DoesDepartmentHead;
        }

        public void setDoesDepartmentHead(Boolean doesDepartmentHead) {
            DoesDepartmentHead = doesDepartmentHead;
        }
    }

    class Intern extends Human
    {
        Date InternshipStarted;
        Integer InternshipDays;
        String UniversityName;

        public Date getInternshipStarted() {
            return InternshipStarted;
        }

        public void setInternshipStarted(Date internshipStarted) {
            InternshipStarted = internshipStarted;
        }

        public Integer getInternshipDays() {
            return InternshipDays;
        }

        public void setInternshipDays(Integer internshipDays) {
            InternshipDays = internshipDays;
        }

        public String getUniversityName() {
            return UniversityName;
        }

        public void setUniversityName(String universityName) {
            UniversityName = universityName;
        }
    }

    class Department
    {
        private String Name;
        private Integer Floor;
        private Integer WardsAmount;
        private Integer DoctorsAmount;
        private Integer CurrentPatientsAmount;
        private Integer MaxPatientsAmount;
        private Doctor DepartmentHead;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public Integer getFloor() {
            return Floor;
        }

        public void setFloor(Integer floor) {
            Floor = floor;
        }

        public Integer getWardsAmount() {
            return WardsAmount;
        }

        public void setWardsAmount(Integer wardsAmount) {
            WardsAmount = wardsAmount;
        }

        public Integer getDoctorsAmount() {
            return DoctorsAmount;
        }

        public void setDoctorsAmount(Integer doctorsAmount) {
            DoctorsAmount = doctorsAmount;
        }

        public Integer getCurrentPatientsAmount() {
            return CurrentPatientsAmount;
        }

        public void setCurrentPatientsAmount(Integer currentPatientsAmount) {
            CurrentPatientsAmount = currentPatientsAmount;
        }

        public Integer getMaxPatientsAmount() {
            return MaxPatientsAmount;
        }

        public void setMaxPatientsAmount(Integer maxPatientsAmount) {
            MaxPatientsAmount = maxPatientsAmount;
        }

        public Doctor getDepartmentHead() {
            return DepartmentHead;
        }

        public void setDepartmentHead(Doctor departmentHead) {
            DepartmentHead = departmentHead;
        }

    }

    class Hospital
    {
        private String Name;
        private String Adress;
        private List<Department> DepartmentsList;
        private List<Doctor> DoctorsList;
        private List<Intern> InternsList;
        private List<Patient> PatientsList;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getAdress() {
            return Adress;
        }

        public void setAdress(String adress) {
            Adress = adress;
        }

        public List<Department> getDepartmentsList() {
            return DepartmentsList;
        }

        public void addToDepartmentsList(Department department) {
            DepartmentsList.add(department);
        }

        public List<Doctor> getDoctorsList() {
            return DoctorsList;
        }

        public void addToDoctorsList(Doctor doctor) {
            DoctorsList.add(doctor);
        }

        public List<Intern> getInternsList() {
            return InternsList;
        }

        public void addToInternsList(Intern intern) {
            InternsList.add(intern);
        }

        public List<Patient> getPatientsList() {
            return PatientsList;
        }

        public void addToPatientsList(Patient patient) {
            PatientsList.add(patient);
        }

    }

    public static void main(String[] args) {
        System.out.println("Some");
    }
}

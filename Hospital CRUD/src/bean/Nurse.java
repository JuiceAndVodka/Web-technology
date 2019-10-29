package bean;

/**
 * Класс Doctor, производный от класс {@link MedicalWorker} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Nurse#toString()}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Nurse extends MedicalWorker {

    /** Поле текущей должности */
    private String CurrentPost;
    /** Поле даты начала работы */
    private String StartedWorking;
    /** Поле количества сделанных уколов */
    private int InjectionsDid;
    /** Поле количества спасённых пациентов */
    private int PatientsSaved;

    /**
     * Конструктор без параметров класса Nurse, в котором поля инициализируются стандартными значениями
     * @see Nurse#Nurse(String, String, String, String, String, String, String, String, String, String, String, String, String, String, int, int)
     */
    public Nurse()
    {
        this.CurrentPost = "Procedure nurse";
        this.StartedWorking = "31.12.1992";
        this.InjectionsDid = 100;
        this.PatientsSaved = 4;
    }

    /**
     * Конструктор с параметрами класс Nurse, в котором поля инициализируются переданными значениями
     * @param name имя медсестры
     * @param surname фамилия медсестры
     * @param patronymic отчество медсестры
     * @param gender пол медсестры
     * @param homeAdress домашний адрес проживания медсестры
     * @param birthDay день рождения медсестры
     * @param phoneNumber мобильный номер телефона медсестры
     * @param departmentName название отделения, в котором работает
     * @param diplomaProfession профессия по диплому
     * @param workPhoneNumber мобильный номер рабочего телефона
     * @param universityName название университета, который окончил
     * @param universityEnded дата окончания университета
     * @param currentPost текущая должность медсестры
     * @param startedWorking дата начала работы медсестры
     * @param injectionsDid количество сделанных уколов
     * @param patientsSaved количество спасённых пациентов
     * @see Nurse#Nurse()
     */
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

    /**
     * Функция получения приватного поля {@link Nurse#CurrentPost}
     * @return поле {@link Nurse#CurrentPost}
     */
    public String getCurrentPost() {
        return CurrentPost;
    }

    /**
     * Функция задания нового значения приватному полю {@link Nurse#CurrentPost}
     * @param currentPost текущая должность
     */
    public void setCurrentPost(String currentPost) {
        CurrentPost = currentPost;
    }

    /**
     * Функция получения приватного поля {@link Nurse#StartedWorking}
     * @return поле {@link Nurse#StartedWorking}
     */
    public String getStartedWorking() {
        return StartedWorking;
    }

    /**
     * Функция задания нового значения приватному полю {@link Nurse#StartedWorking}
     * @param startedWorking дата начала работы
     */
    public void setStartedWorking(String startedWorking) {
        StartedWorking = startedWorking;
    }

    /**
     * Функция получения приватного поля {@link Nurse#InjectionsDid}
     * @return поле {@link Nurse#InjectionsDid}
     */
    public int getInjectionsDid() {
        return InjectionsDid;
    }

    /**
     * Функция задания нового значения приватному полю {@link Nurse#InjectionsDid}
     * @param injectionsDid количество сделанных уколов
     */
    public void setInjectionsDid(int injectionsDid) {
        InjectionsDid = injectionsDid;
    }

    /**
     * Функция получения приватного поля {@link Nurse#PatientsSaved}
     * @return поле {@link Nurse#PatientsSaved}
     */
    public int getPatientsSaved() {
        return PatientsSaved;
    }

    /**
     * Функция задания нового значения приватному полю {@link Nurse#PatientsSaved}
     * @param patientsSaved количество спасённых пациентов
     */
    public void setPatientsSaved(int patientsSaved) {
        PatientsSaved = patientsSaved;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "Nurse" + "\n" +
                        "Name: " + this.getName() + "\n" +
                        "Id: " + this.getId() + "\n" +
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
                        "PatientsSaved: " + this.PatientsSaved + "\n\n";

        return string;
    }
}

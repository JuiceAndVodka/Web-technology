package bean;

/**
 * Класс Doctor, производный от класс {@link MedicalWorker} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Doctor#toString()}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Doctor extends MedicalWorker
{
    /** Поле текущей должности */
    private String CurrentPost;
    /** Поле даты начала работы */
    private String StartedWorking;
    /** Поле количества вылеченных пациентов */
    private int PatientsHealed;

    /**
     * Конструктор без параметров класса Doctor, в котором поля инициализируются стандартными значениями
     * @see Doctor#Doctor(String, String, String, String, String, String, String, String, String, String, String, String, String, String, int)
     */
    public  Doctor() {

        this.CurrentPost = "Therapist";
        this.StartedWorking = "31.12.1980";
        this.PatientsHealed = 0;
    }

    /**
     * Конструктор с параметрами класс Doctor, в котором поля инициализируются переданными значениями
     * @param name имя доктора
     * @param surname фамилия доктора
     * @param patronymic отчество доктора
     * @param gender пол доктора
     * @param homeAdress домашний адрес проживания доктора
     * @param birthDay день рождения доктора
     * @param phoneNumber мобильный номер телефона доктора
     * @param departmentName название отделения, в котором работает
     * @param diplomaProfession профессия по диплому
     * @param workPhoneNumber мобильный номер рабочего телефона
     * @param universityName название университета, который окончил
     * @param universityEnded дата окончания университета
     * @param currentPost текущая должность доктора
     * @param startedWorking дата начала работы
     * @param patientsHealed количество вылеченных пациентов
     * @see Doctor#Doctor()
     */
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

    /**
     * Функция получения приватного поля {@link Doctor#CurrentPost}
     * @return поле {@link Doctor#CurrentPost}
     */
    public String getCurrentPost() {
        return CurrentPost;
    }

    /**
     * Функция задания нового значения приватному полю {@link Doctor#CurrentPost}
     * @param currentPost текущая должность
     */
    public void setCurrentPost(String currentPost) {
        CurrentPost = currentPost;
    }

    /**
     * Функция получения приватного поля {@link Doctor#StartedWorking}
     * @return поле {@link Doctor#StartedWorking}
     */
    public String getStartedWorking() {
        return StartedWorking;
    }

    /**
     * Функция задания нового значения приватному полю {@link Doctor#StartedWorking}
     * @param startedWorking дата начала работы
     */
    public void setStartedWorking(String startedWorking) {
        StartedWorking = startedWorking;
    }

    /**
     * Функция получения приватного поля {@link Doctor#PatientsHealed}
     * @return поле {@link Doctor#PatientsHealed}
     */
    public int getPatientsHealed() {
        return PatientsHealed;
    }

    /**
     * Функция задания нового значения приватному полю {@link Doctor#PatientsHealed}
     * @param patientsHealed количество вылеченных пациентов
     */
    public void setPatientsHealed(int patientsHealed) {
        PatientsHealed = patientsHealed;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString() {

        String string = "Doctor" + "\n" +
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
                        "PatientsHealed: " + this.PatientsHealed + "\n\n";

        return string;
    }
}

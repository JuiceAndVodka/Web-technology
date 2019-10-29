package bean;

/**
 * Класс MedicalWorker, который нужен как родитель для остальных классов, производный от {@link Identifier}
 * и содержащий приватные поля, их геттеры и сеттеры, а также переопределение метода
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class MedicalWorker extends Human {

    /** Поле профессии по диплому */
    private String DiplomaProfession;
    /** Поле номера мобильного телефона */
    private String WorkPhoneNumber;
    /** Поле названия университета, который окончил */
    private String UniversityName;
    /** Поле даты окончания университета */
    private String UniversityEnded;

    /**
     * Конструктор без параметров класса MedicalWorker, в котором поля инициализируются стандартными значениями
     * @see MedicalWorker#MedicalWorker(String, String, String, String, String, String, String, String, String, String, String, String)
     */
    public MedicalWorker() {

        this.DiplomaProfession = "Therapist";
        this.WorkPhoneNumber = "+375-33-4444444";
        this.UniversityName = "VSMU";
        this.UniversityEnded = "31.12.1990";
    }

    /**
     * Конструктор с параметрами класс MedicalWorker, в котором поля инициализируются переданными значениями
     * @param name имя работника
     * @param surname фамилия работника
     * @param patronymic отчество работника
     * @param gender пол работника
     * @param homeAdress домашний адрес проживания работника
     * @param birthDay день рождения работника
     * @param phoneNumber мобильный номер телефона работника
     * @param departmentName название отделения, в котором работает
     * @param diplomaProfession профессия по диплому
     * @param workPhoneNumber мобильный номер рабочего телефона
     * @param universityName название университета, который окончил
     * @param universityEnded дата окончания университета
     * @see MedicalWorker#MedicalWorker()
     */
    public  MedicalWorker (String name, String surname, String patronymic, String gender, String homeAdress,
                           String birthDay, String phoneNumber, String  departmentName, String diplomaProfession,
                           String workPhoneNumber, String universityName, String universityEnded) {

        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber, departmentName);

        this.DiplomaProfession = diplomaProfession;
        this.WorkPhoneNumber = workPhoneNumber;
        this.UniversityName = universityName;
        this.UniversityEnded = universityEnded;
    }

    /**
     * Функция получения приватного поля {@link MedicalWorker#DiplomaProfession}
     * @return поле {@link MedicalWorker#DiplomaProfession}
     */
    public String getDiplomaProfession() {
        return DiplomaProfession;
    }

    /**
     * Функция задания нового значения приватному полю {@link MedicalWorker#DiplomaProfession}
     * @param diplomaProfession профессия по диплому
     */
    public void setDiplomaProfession(String diplomaProfession) {
        DiplomaProfession = diplomaProfession;
    }

    /**
     * Функция получения приватного поля {@link MedicalWorker#WorkPhoneNumber}
     * @return поле {@link MedicalWorker#WorkPhoneNumber}
     */
    public String getWorkPhoneNumber() {
        return WorkPhoneNumber;
    }

    /**
     * Функция задания нового значения приватному полю {@link MedicalWorker#WorkPhoneNumber}
     * @param workPhoneNumber рабочий номер мобильного телефона
     */
    public void setWorkPhoneNumber(String workPhoneNumber) {
        WorkPhoneNumber = workPhoneNumber;
    }

    /**
     * Функция получения приватного поля {@link MedicalWorker#UniversityName}
     * @return поле {@link MedicalWorker#UniversityName}
     */
    public String getUniversityName() {
        return UniversityName;
    }

    /**
     * Функция задания нового значения приватному полю {@link MedicalWorker#UniversityName}
     * @param universityName название университета, который окончил
     */
    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    /**
     * Функция получения приватного поля {@link MedicalWorker#UniversityEnded}
     * @return поле {@link MedicalWorker#UniversityEnded}
     */
    public String getUniversityEnded() {
        return UniversityEnded;
    }

    /**
     * Функция задания нового значения приватному полю {@link MedicalWorker#UniversityEnded}
     * @param universityEnded дата окончания университета
     */
    public void setUniversityEnded(String universityEnded) {
        UniversityEnded = universityEnded;
    }
}

package bean;

/**
 * Класс Doctor, производный от класс {@link MedicalWorker} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Intern#toString()}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Intern extends MedicalWorker
{
    /** Поле даты начала интернатуры */
    private String InternshipStarted;
    /** Поле количества нужный дней для окончания интернатуры */
    private int InternshipDays;
    /** Поле количества сделанных ошибок за время интернатуры */
    private int MistakesMade;

    /**
     * Конструктор без параметров класса Intern, в котором поля инициализируются стандартными значениями
     * @see Intern#Intern(String, String, String, String, String, String, String, String, String, String, String, String, String, int, int)
     */
    public  Intern()
    {
        this.InternshipStarted = "11.12.2000";
        this.InternshipDays = 2000;
        this.MistakesMade = 2;
    }

    /**
     * Конструктор с параметрами класс Intern, в котором поля инициализируются переданными значениями
     * @param name имя интерна
     * @param surname фамилия интерна
     * @param patronymic отчество интерна
     * @param gender пол интерна
     * @param homeAdress домашний адрес проживания интерна
     * @param birthDay день рождения интерна
     * @param phoneNumber мобильный номер телефона интерна
     * @param departmentName название отделения, в котором работает
     * @param diplomaProfession профессия по диплому
     * @param workPhoneNumber мобильный номер рабочего телефона
     * @param universityName название университета, который окончил
     * @param universityEnded дата окончания университета
     * @param internshipStarted дата начала интернатуры
     * @param internshipDays количество нужный дней для окончания интернатуры
     * @param mistakesMade количество совершённых ошибок за время интернатуры
     * @see Intern#Intern()
     */
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

    /**
     * Функция получения приватного поля {@link Intern#InternshipStarted}
     * @return поле {@link Intern#InternshipStarted}
     */
    public String getInternshipStarted() {
        return InternshipStarted;
    }

    /**
     * Функция задания нового значения приватному полю {@link Intern#InternshipStarted}
     * @param internshipStarted дата начала интернатуры
     */
    public void setInternshipStarted(String internshipStarted) {
        InternshipStarted = internshipStarted;
    }

    /**
     * Функция получения приватного поля {@link Intern#InternshipDays}
     * @return поле {@link Intern#InternshipDays}
     */
    public int getInternshipDays() {
        return InternshipDays;
    }

    /**
     * Функция задания нового значения приватному полю {@link Intern#InternshipDays}
     * @param internshipDays количество дней, нужный для окончания интернатуры
     */
    public void setInternshipDays(int internshipDays) {
        InternshipDays = internshipDays;
    }

    /**
     * Функция получения приватного поля {@link Intern#MistakesMade}
     * @return поле {@link Intern#MistakesMade}
     */
    public int getMistakesMade() {
        return MistakesMade;
    }

    /**
     * Функция задания нового значения приватному полю {@link Intern#MistakesMade}
     * @param mistakesMade количество совершённых ошибок за время интернатуры
     */
    public void setMistakesMade(int mistakesMade) {
        MistakesMade = mistakesMade;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "Intern" + "\n" +
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
                        "InternshipStarted: " + this.InternshipStarted + "\n" +
                        "InternshipDays: " + this.InternshipDays + "\n" +
                        "MistakesMade: " + this.MistakesMade + "\n\n";

        return string;
    }
}

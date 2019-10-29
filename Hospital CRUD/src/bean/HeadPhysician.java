package bean;

/**
 * Класс HeadPhysician, производный от класс {@link MedicalWorker} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link HeadPhysician#toString()}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class HeadPhysician extends MedicalWorker
{
    /** Поле даты начала работы */
    private String StartedWorking;
    /** Поле даты окончания работы */
    private String EndedWorking;
    /** Поле планов на будушее больницы */
    private String FuturePlansForHospital;

    /**
     * Конструктор без параметров класса HeadPhysician, в котором поля инициализируются стандартными значениями
     * @see HeadPhysician#HeadPhysician(String, String, String, String, String, String, String, String, String, String, String, String, String, String, String)
     */
    public  HeadPhysician()
    {
        this.StartedWorking = "22.11.1933";
        this.EndedWorking = "Still working";
        this.FuturePlansForHospital = "Add new department";
    }

    /**
     * Конструктор с параметрами класс HeadPhysician, в котором поля инициализируются переданными значениями
     * @param name имя главврача
     * @param surname фамилия главврача
     * @param patronymic отчество главврача
     * @param gender пол главврача
     * @param homeAdress домашний адрес проживания главврача
     * @param birthDay день рождения главврача
     * @param phoneNumber мобильный номер телефона главврача
     * @param departmentName название отделения, в котором работает
     * @param diplomaProfession профессия по диплому
     * @param workPhoneNumber мобильный номер рабочего телефона
     * @param universityName название университета, который окончил
     * @param universityEnded дата окончания университета
     * @param startedWork дата начала работы
     * @param endedWorking дата окончания работы
     * @param futurePlansForHospital планы на будущее больницы
     * @see HeadPhysician#HeadPhysician()
     */
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

    /**
     * Функция получения приватного поля {@link HeadPhysician#StartedWorking}
     * @return поле {@link HeadPhysician#StartedWorking}
     */
    public String getStartedWorking() {
        return StartedWorking;
    }

    /**
     * Функция задания нового значения приватному полю {@link HeadPhysician#StartedWorking}
     * @param startedWork дата начала работы
     */
    public void setStartedWorking(String startedWork) {
        StartedWorking = startedWork;
    }

    /**
     * Функция получения приватного поля {@link HeadPhysician#EndedWorking}
     * @return поле {@link HeadPhysician#EndedWorking}
     */
    public String getEndedWorking() {
        return EndedWorking;
    }

    /**
     * Функция задания нового значения приватному полю {@link HeadPhysician#EndedWorking}
     * @param endedWorking дата окончания работы
     */
    public void setEndedWorking(String endedWorking) {
        EndedWorking = endedWorking;
    }

    /**
     * Функция получения приватного поля {@link HeadPhysician#EndedWorking}
     * @return поле {@link HeadPhysician#EndedWorking}
     */
    public String getFuturePlansForHospital() {
        return FuturePlansForHospital;
    }

    /**
     * Функция задания нового значения приватному полю {@link HeadPhysician#FuturePlansForHospital}
     * @param futurePlansForHospital планы на будущее больницы
     */
    public void setFuturePlansForHospital(String futurePlansForHospital) {
        FuturePlansForHospital = futurePlansForHospital;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "HeadPhysician" + "\n" +
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
                        "StartedWorking: " + this.StartedWorking + "\n" +
                        "EndedWorking: " + this.EndedWorking + "\n" +
                        "FuturePlansForHospital: " + this.FuturePlansForHospital + "\n\n";

        return string;
    }
}

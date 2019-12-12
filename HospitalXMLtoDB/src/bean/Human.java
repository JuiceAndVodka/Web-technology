package bean;

/**
 * Класс Human, который нужен как родитель для остальных классов и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Human#compareTo(Human)}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Human extends Identifier implements  Comparable<Human>
{
    /** Поле имени */
    private String Name;
    /** Поле фамилии */
    private String Surname;
    /** Поле отчества */
    private String Patronymic;
    /** Поле пола человека */
    private String Gender;
    /** Поле домашнего адреса */
    private String HomeAdress;
    /** Поле даты дня рождения */
    private String BirthDay;
    /** Поле мобильного телефона */
    private String PhoneNumber;
    /** Поле отделения, к которому прикреплён */
    private String DepartmentName;

    /**
     * Конструктор без параметров класса Human, в котором поля инициализируются стандартными значениями
     * @see Human#Human(String, String, String, String, String, String, String, String)
     */
    public Human()
    {
        this.Name = "Ivan";
        this.Surname = "Ivanov";
        this.Patronymic = "Ivanovich";
        this.Gender = "Male";
        this.HomeAdress = "Republic of Belarus, Minsk region, Minsk, Gikalo street, house 9a";
        this.BirthDay = "11.11.1911";
        this.PhoneNumber = "+375-33-9999999";
        this.DepartmentName = "No";
    }

    /**
     * Конструктор с параметрами класс Human, в котором поля инициализируются переданными значениями
     * @param name имя доктора
     * @param surname фамилия доктора
     * @param patronymic отчество доктора
     * @param gender пол доктора
     * @param homeAdress домашний адрес проживания доктора
     * @param birthDay день рождения доктора
     * @param phoneNumber мобильный номер телефона доктора
     * @param departmentName название отделения, к которому прикреплён
     * @see Human#Human()
     */
    public  Human(String name, String surname, String patronymic, String gender, String homeAdress, String birthDay, String phoneNumber, String  departmentName)
    {
        this.Name = name;
        this.Surname = surname;
        this.Patronymic = patronymic;
        this.Gender = gender;
        this.HomeAdress = homeAdress;
        this.BirthDay = birthDay;
        this.PhoneNumber = phoneNumber;
        this.DepartmentName = departmentName;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#Name}
     * @param name имя человека
     */
    public void setName (String name)
    {
        Name = name;
    }

    /**
     * Функция получения приватного поля {@link Human#Name}
     * @return поле {@link Human#Name}
     */
    public String getName()
    {
        return Name;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#Surname}
     * @param surname фамилия человека
     */
    public void setSurname (String surname)
    {
        Surname = surname;
    }

    /**
     * Функция получения приватного поля {@link Human#Surname}
     * @return поле {@link Human#Surname}
     */
    public String getSurname()
    {
        return Surname;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#Patronymic}
     * @param patronymic отчество человека
     */
    public void setPatronymic(String patronymic)
    {
        Patronymic = patronymic;
    }

    /**
     * Функция получения приватного поля {@link Human#Patronymic}
     * @return поле {@link Human#Patronymic}
     */
    public  String getPatronymic()
    {
        return Patronymic;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#Gender}
     * @param gender пол человека
     */
    public void setGender(String gender)
    {
        Gender = gender;
    }

    /**
     * Функция получения приватного поля {@link Human#Gender}
     * @return поле {@link Human#Gender}
     */
    public  String getGender()
    {
        return Gender;
    }

    /**
     * Функция получения приватного поля {@link Human#HomeAdress}
     * @return поле {@link Human#HomeAdress}
     */
    public String getHomeAdress() {
        return HomeAdress;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#HomeAdress}
     * @param homeAdress домашний адрес человека
     */
    public void setHomeAdress(String homeAdress)
    {
        HomeAdress = homeAdress;
    }

    /**
     * Функция получения приватного поля {@link Human#BirthDay}
     * @return поле {@link Human#BirthDay}
     */
    public String getBirthDay() {
        return BirthDay;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#BirthDay}
     * @param birthDay дата дня рождения человека
     */
    public void setBirthDay(String birthDay)
    {
        BirthDay = birthDay;
    }

    /**
     * Функция получения приватного поля {@link Human#PhoneNumber}
     * @return поле {@link Human#PhoneNumber}
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#PhoneNumber}
     * @param phoneNumber номер мобильного телефона человека
     */
    public void setPhoneNumber(String phoneNumber)
    {
        PhoneNumber = phoneNumber;
    }

    /**
     * Функция получения приватного поля {@link Human#DepartmentName}
     * @return поле {@link Human#DepartmentName}
     */
    public String getDepartmentName() {
        return DepartmentName;
    }

    /**
     * Функция задания нового значения приватному полю {@link Human#DepartmentName}
     * @param departmentName название отделения, к которому прикреплён человек
     */
    public void setDepartmentName(String departmentName)
    {
        DepartmentName = departmentName;
    }

    /**
     * Сравнивает поле {@link Human#Name} с полем {@link Human#Name} переданного объекта
     * @param human объект класса {@link Human}
     * @return число (-1 / 0 / 1), обозначающее, поле какого объекта меньше при сравнении
     */
    @Override
    public int compareTo(Human human) {
        return Name.compareTo(human.getName());
    }
}

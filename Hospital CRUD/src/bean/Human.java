package bean;

public class Human extends Identifier implements  Comparable<Human>
{
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Gender;
    private String HomeAdress;
    private String BirthDay;
    private String PhoneNumber;
    private String DepartmentName;

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

    public void setGender(String gender)
    {
        Gender = gender;
    }

    public  String getGender()
    {
        return Gender;
    }

    public String getHomeAdress() {
        return HomeAdress;
    }

    public void setHomeAdress(String homeAdress)
    {
        HomeAdress = homeAdress;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay)
    {
        BirthDay = birthDay;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        PhoneNumber = phoneNumber;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        DepartmentName = departmentName;
    }

    @Override
    public int compareTo(Human human) {
        return Name.compareTo(human.getName());
    }
}

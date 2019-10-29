package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Doctor, производный от класс {@link Human} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Patient#toString()}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Patient extends Human
{
    /** Поле палаты, в которой лежит пациент */
    private int WardNumber;
    /** Поле объекта текущей болезни */
    private Disease CurrentDisease;

    /**
     * Конструктор без параметров класса Patient, в котором поля инициализируются стандартными значениями
     * @see Patient#Patient(String, String, String, String, String, String, String, String, int, Disease)
     */
    public  Patient()
    {
        this.CurrentDisease = new Disease();
        this.WardNumber = 1;
    }

    /**
     * Конструктор с параметрами класс Patient, в котором поля инициализируются переданными значениями
     * @param name имя пациента
     * @param surname фамилия пациента
     * @param patronymic отчество пациента
     * @param gender пол пациента
     * @param homeAdress домашний адрес проживания пациента
     * @param birthDay день рождения пациента
     * @param phoneNumber мобильный номер телефона пациента
     * @param departmentName название отделения, в котором работает
     * @param wardNumber номер палаты пациента
     * @param currentDisease объект текущей болезни
     */
    public  Patient(String name, String surname, String patronymic, String gender, String homeAdress, String birthDay,
                    String phoneNumber, String  departmentName, int wardNumber, Disease currentDisease)
    {
        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber, departmentName);

        this.CurrentDisease = currentDisease;
        this.WardNumber = wardNumber;
    }

    /**
     * Функция получения приватного поля {@link Patient#CurrentDisease}
     * @return поле {@link Patient#CurrentDisease}
     */
    public Disease getCurrentDisease()
    {
        return CurrentDisease;
    }

    /**
     * Функция задания нового значения приватному полю {@link Patient#CurrentDisease}
     * @param disease текущая болезнь
     */
    public void setCurrentDisease(Disease disease)
    {
        this.CurrentDisease = disease;
    }

    /**
     * Функция получения приватного поля {@link Patient#WardNumber}
     * @return поле {@link Patient#WardNumber}
     */
    public int getWardNumber()
    {
        return WardNumber;
    }

    /**
     * Функция задания нового значения приватному полю {@link Patient#WardNumber}
     * @param wardNumber номер палаты пациента
     */
    public void setWardNumber(int wardNumber)
    {
        WardNumber = wardNumber;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "Patient" + "\n" +
                        "Name: " + this.getName() + "\n" +
                        "Id: " + this.getId() + "\n" +
                        "Surname: " + this.getSurname() + "\n" +
                        "Patronymic: " + this.getPatronymic() + "\n" +
                        "Gender: " + this.getGender() + "\n" +
                        "Birthday: " + this.getBirthDay() + "\n" +
                        "HomeAdress: " + this.getHomeAdress() + "\n" +
                        "PhoneNumber: " + this.getPhoneNumber() + "\n" +
                        "DepartmentName: " + this.getDepartmentName() + "\n" +
                        "WardNumber: " + this.WardNumber + "\n";

        if (this.CurrentDisease != null)
        {
            string += this.CurrentDisease.toString() + "\n\n";
        }
        else
        {
            string += "\n";
        }

        return string;
    }
}

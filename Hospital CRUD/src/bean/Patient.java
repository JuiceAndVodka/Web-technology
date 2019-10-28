package bean;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Human
{
    private int WardNumber;
    private Disease CurrentDisease;


    public  Patient()
    {
        this.CurrentDisease = new Disease();
        this.WardNumber = 1;
    }

    public  Patient(String name, String surname, String patronymic, String gender, String homeAdress, String birthDay,
                    String phoneNumber, String  departmentName, int wardNumber, Disease currentDisease)
    {
        super(name, surname, patronymic, gender, homeAdress, birthDay, phoneNumber, departmentName);

        this.CurrentDisease = currentDisease;
        this.WardNumber = wardNumber;
    }

    public Disease getCurrentDisease()
    {
        return CurrentDisease;
    }

    public void setCurrentDisease(Disease disease)
    {
        this.CurrentDisease = disease;
    }

    public int getWardNumber()
    {
        return WardNumber;
    }

    public void setWardNumber(int wardNumber)
    {
        WardNumber = wardNumber;
    }

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

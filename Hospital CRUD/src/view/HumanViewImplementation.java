package view;

import bean.Human;

import java.util.Scanner;

public class HumanViewImplementation {

    public static Human StartToCreate()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter surname");
        String surname = scanner.nextLine();

        System.out.println("Enter patronymic");
        String patronymic = scanner.nextLine();

        System.out.println("Enter gender");
        String gender = scanner.nextLine();

        System.out.println("Enter birthday date");
        String birthday = scanner.nextLine();

        System.out.println("Enter home adress");
        String homeAdress = scanner.nextLine();

        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter department name");
        String departmentName = scanner.nextLine();

        return  new Human(name, surname, patronymic, gender, birthday, homeAdress, phoneNumber, departmentName);
    }
}

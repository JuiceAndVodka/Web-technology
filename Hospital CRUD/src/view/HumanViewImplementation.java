package view;

import bean.Human;

import java.util.Scanner;

/**
 * Класс для создания нового объекта класса {@link Human} диалога между пользователем и приложением
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class HumanViewImplementation {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Human}
     */
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

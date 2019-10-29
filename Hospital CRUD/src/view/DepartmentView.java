package view;

import bean.Department;

import java.util.Scanner;

/**
 * Класс для диалога между пользователем и приложением для создания нового объекта класса {@link Department}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class DepartmentView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Department}
     */
    public static Department StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter floor");
        int floor;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            floor = 5;
        }
        else {
            floor = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of wards");
        int wardsAmount;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            wardsAmount = 5;
        }
        else {
            wardsAmount = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of doctors");
        int doctorsAmount;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            doctorsAmount = 5;
        }
        else {
            doctorsAmount = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of current patients");
        int currentPatientsAmount;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            currentPatientsAmount = 5;
        }
        else {
            currentPatientsAmount = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of maximum patients");
        int maxPatientsAmount;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            maxPatientsAmount = 5;
        }
        else {
            maxPatientsAmount = scanner.nextInt();
        }

        scanner.nextLine();

        return new Department(name, floor, wardsAmount, doctorsAmount, currentPatientsAmount, maxPatientsAmount);
    }
}

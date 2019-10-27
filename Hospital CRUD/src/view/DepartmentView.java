package view;

import bean.Department;

import java.util.Scanner;

public class DepartmentView {

    public static Department StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter floor");
        int floor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of wards");
        int wardsAmount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of doctors");
        int doctorsAmount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of current patients");
        int currentPatientsAmount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of maximum patients");
        int maxPatientsAmount = scanner.nextInt();
        scanner.nextLine();

        return new Department(name, floor, wardsAmount, doctorsAmount, currentPatientsAmount, maxPatientsAmount);
    }
}

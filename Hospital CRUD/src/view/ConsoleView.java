package view;

import bean.Department;
import bean.Human;
import service.FactoryService;

import  java.util.Scanner;

public class ConsoleView {

    public void Start() {

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Show departments list");
            System.out.println("2. Show humans list");
            System.out.println("3. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    ShowDepartments();
                    break;
                }
                case "2": {
                    ShowHumans();
                    break;
                }
                case "3": {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }

    }

    public void ShowDepartments() {

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Departments list");

        for (Department department: FactoryService.getInstance().getDepartmentService().getAllDepartments() ) {
            System.out.println(department.toString());
        }

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Create department");
            System.out.println("2. Edit department");
            System.out.println("3. Delete department");
            System.out.println("4. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    Department department = DepartmentView.StartToCreate();
                    FactoryService.getInstance().getDepartmentService().addDepartment(department);
                    break;
                }
                case "2": {
                    System.out.println("Enter department id: ");
                    int departmentId = scanner.nextInt();

                    Department department = DepartmentView.StartToCreate();
                    FactoryService.getInstance().getDepartmentService().updateDepartment(departmentId, department);
                    break;
                }
                case "3": {
                    System.out.println("Enter user id: ");
                    int departmentId = scanner.nextInt();

                    FactoryService.getInstance().getDepartmentService().deleteDepartmentById(departmentId);
                    break;
                }
                case "4":
                {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }

    public void ShowHumans(){

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Humans List");

        for (Human human: FactoryService.getInstance().getHumanService().getAllHumans() ) {
            System.out.println(human.toString());
        }

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Create human");
            System.out.println("2. Update human");
            System.out.println("3. Delete human");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter human type: ");
                    String humanType = scanner.nextLine();

                    HumanView humanView = FactoryHumansView.GetView(humanType);

                    if(humanView == null) {
                        System.out.println("Incorrect human type");
                        continue;
                    }

                    Human human = humanView.StartToCreate();
                    FactoryService.getInstance().getHumanService().addHuman(human);
                    break;
                }
                case "2": {
                    System.out.println("Enter human type: ");
                    String humanType = scanner.nextLine();
                    System.out.println("Enter human id: ");

                    int humanId = scanner.nextInt();
                    HumanView humanView = FactoryHumansView.GetView(humanType);

                    if(humanView == null) {
                        System.out.println("Incorrect human type");
                        continue;
                    }

                    Human human = humanView.StartToCreate();
                    FactoryService.getInstance().getHumanService().updateHuman(humanId, human);
                    break;
                }
                case "3": {
                    System.out.println("Enter human id: ");
                    int humanId = scanner.nextInt();

                    FactoryService.getInstance().getHumanService().deleteHumanById(humanId);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6":
                {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }
}

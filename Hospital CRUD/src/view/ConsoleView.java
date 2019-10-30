package view;

import bean.Department;
import bean.Human;
import service.FactoryService;

import java.util.ArrayList;
import  java.util.Scanner;

/**
 * Класс графической части приложения, благодаря которому происходит диалог между пользователем и приложением
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class ConsoleView {

    /**
     * Начинает диалог между пользователем и приложением
     */
    public void start() {

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Show departments list");
            System.out.println("2. Show humans list");
            System.out.println("3. Exit");

            System.out.println("**************************************************");

            String chosenNumber = scanner.nextLine();

            System.out.println("**************************************************");

            switch (chosenNumber) {
                case "1": {
                    showDepartments();
                    break;
                }
                case "2": {
                    showHumans();
                    break;
                }
                case "3": {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("**************************************************");
                    System.out.println("Incorrect value!");
                }
            }
        }

    }

    /**
     * Показывает список объктов типа {@link Department} и список функций для работы с ними
     */
    public void showDepartments() {

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Departments list:\n");

        showDepartmentsList((ArrayList<Department>) FactoryService.getInstance().getDepartmentService().getAllDepartments());

        System.out.println("**************************************************");

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Create department");
            System.out.println("2. Update department");
            System.out.println("3. Delete department");
            System.out.println("4. Sort by name");
            System.out.println("5. Sort by floor");
            System.out.println("6. Find by floor");
            System.out.println("7. Show departments list again");
            System.out.println("8. Exit");

            System.out.println("**************************************************");

            String chosenNumber = scanner.nextLine();

            System.out.println("**************************************************");

            switch (chosenNumber) {
                case "1": {

                    Department department = DepartmentView.startToCreate();

                    System.out.println("**************************************************");

                    FactoryService.getInstance().getDepartmentService().addDepartment(department);
                    break;
                }
                case "2": {

                    System.out.println("Enter department id: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Incorrect type value!");
                        System.out.println("**************************************************");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("**************************************************");

                    int departmentId = scanner.nextInt();
                    scanner.nextLine();

                    if ((FactoryService.getInstance().getDepartmentService().getDepartment(departmentId)) == null) {

                        System.out.println("Incorrect id! ");
                        System.out.println("**************************************************");
                        break;
                    }

                    Department department = DepartmentView.startToCreate();

                    System.out.println("**************************************************");

                    FactoryService.getInstance().getDepartmentService().updateDepartment(departmentId, department);
                    break;
                }
                case "3": {

                    System.out.println("Enter department id: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Incorrect type value! ");
                        System.out.println("**************************************************");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("**************************************************");

                    int departmentId = scanner.nextInt();
                    scanner.nextLine();

                    if ((FactoryService.getInstance().getDepartmentService().getDepartment(departmentId)) == null) {

                        System.out.println("Incorrect id!");
                        System.out.println("**************************************************");
                        break;
                    }

                    FactoryService.getInstance().getDepartmentService().deleteDepartmentById(departmentId);
                    break;
                }
                case "4": {

                    System.out.println("Do ascending sort? (true / false)");

                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Incorrect type value! ");
                        scanner.nextLine();
                        break;
                    }

                    boolean doesAscending = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    showDepartmentsList((ArrayList<Department>) FactoryService.getInstance().getDepartmentService().sortDepartmentByName(doesAscending));
                    System.out.println("**************************************************");
                    break;
                }
                case "5": {

                    System.out.println("Do ascending sort? (true / false)");

                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Incorrect type value!");
                        scanner.nextLine();
                        break;
                    }

                    boolean doesAscending = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    showDepartmentsList((ArrayList<Department>) FactoryService.getInstance().getDepartmentService().sortDepartmentByFloor(doesAscending));
                    System.out.println("**************************************************");
                    break;
                }
                case "6": {

                    System.out.println("Enter floor: ");
                    int floor = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    ArrayList<Department> departmentsList = (ArrayList<Department>) FactoryService.getInstance().getDepartmentService().findDepartmentByFloor(floor);

                    System.out.println("Found departments:\n");

                    showDepartmentsList(departmentsList);

                    System.out.println("**************************************************");
                    break;
                }
                case "7": {

                    System.out.println("Departments list:\n");

                    showDepartmentsList((ArrayList<Department>) FactoryService.getInstance().getDepartmentService().getAllDepartments());

                    System.out.println("**************************************************");
                    break;
                }
                case "8": {

                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                    System.out.println("**************************************************");
                }
            }
        }
    }

    /**
     * Отображает передаваемый список объектов
     * @param departmentsList список объектов типа {@link Department}
     */
    private void showDepartmentsList(ArrayList<Department> departmentsList) {

        for (Department department: departmentsList) {
            System.out.println(department.toString());
        }
    }

    /**
     * Показывает список объктов типа {@link Human} и список функций для работы с ними
     */
    public void showHumans(){

        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Humans List:\n");

        showHumansList((ArrayList<Human>) FactoryService.getInstance().getHumanService().getAllHumans());

        System.out.println("**************************************************");

        while (!exitFlag) {

            System.out.println("Which function should I do?");
            System.out.println("1. Create human");
            System.out.println("2. Update human");
            System.out.println("3. Delete human");
            System.out.println("4. Sort by department name");
            System.out.println("5. Sort by gender");
            System.out.println("6. Find by department name");
            System.out.println("7. Show humans list again");
            System.out.println("8. Exit");

            System.out.println("**************************************************");

            String chosenNumber = scanner.nextLine();

            System.out.println("**************************************************");

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter human type (HeadPhysician, Doctor, Nurse, Intern, Patient): ");
                    String humanType = scanner.nextLine();

                    System.out.println("**************************************************");

                    HumanView humanView = FactoryHumansView.getView(humanType);

                    if(humanView == null) {
                        System.out.println("Incorrect human type");
                        System.out.println("**************************************************");
                        continue;
                    }

                    Human human = humanView.startToCreate();

                    System.out.println("**************************************************");

                    FactoryService.getInstance().getHumanService().addHuman(human);
                    break;
                }
                case "2": {
                    System.out.println("Enter human type (HeadPhysician, Doctor, Nurse, Intern, Patient): ");
                    String humanType = scanner.nextLine();
                    System.out.println("Enter human id: ");

                    System.out.println("**************************************************");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Incorrect type value!");
                        System.out.println("**************************************************");
                        scanner.nextLine();
                        break;
                    }

                    int humanId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    HumanView humanView = FactoryHumansView.getView(humanType);

                    if(humanView == null) {
                        System.out.println("Incorrect human type");
                        System.out.println("**************************************************");
                        continue;
                    }

                    Human bufHuman = FactoryService.getInstance().getHumanService().getHuman(humanId);

                    if (bufHuman == null) {

                        System.out.println("Incorrect id!");
                        System.out.println("**************************************************");
                        break;
                    }
                    else {

                        if (bufHuman.getClass().getSimpleName() != humanType) {

                            System.out.println("Incorrect human type with id!");
                            System.out.println("**************************************************");
                            break;
                        }
                    }

                    Human human = humanView.startToCreate();

                    System.out.println("**************************************************");

                    FactoryService.getInstance().getHumanService().updateHuman(humanId, human);
                    break;
                }
                case "3": {
                    System.out.println("Enter human id: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Incorrect type value!  ");
                        System.out.println("**************************************************");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("**************************************************");

                    int humanId = scanner.nextInt();
                    scanner.nextLine();

                    if ((FactoryService.getInstance().getHumanService().getHuman(humanId)) == null) {

                        System.out.println("Incorrect id!");
                        System.out.println("**************************************************");
                        break;
                    }

                    FactoryService.getInstance().getHumanService().deleteHumanById(humanId);
                    break;
                }
                case "4": {

                    System.out.println("Do ascending sort? (true / false)");

                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Incorrect type value!  ");
                        scanner.nextLine();
                        break;
                    }

                    boolean doesAscending = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    showHumansList((ArrayList<Human>) FactoryService.getInstance().getHumanService().sortByDepartmentName(doesAscending));
                    System.out.println("**************************************************");
                    break;
                }
                case "5": {

                    System.out.println("Do ascending sort? (true / false)");

                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Incorrect type value!   ");
                        scanner.nextLine();
                        break;
                    }

                    boolean doesAscending = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("**************************************************");

                    showHumansList((ArrayList<Human>) FactoryService.getInstance().getHumanService().sortByGender(doesAscending));
                    System.out.println("**************************************************");
                    break;
                }
                case "6": {

                    System.out.println("Enter human department name: ");
                    String departmentName = scanner.nextLine();

                    System.out.println("**************************************************");

                    ArrayList<Human> humansList = (ArrayList<Human>) FactoryService.getInstance().getHumanService().findByDepartmentName(departmentName);

                    System.out.println("Found humans:\n");

                    for (Human human: humansList) {

                        System.out.println(human.toString());
                    }

                    System.out.println("**************************************************");
                    break;
                }
                case "7": {

                    System.out.println("Humans List:\n");

                    showHumansList((ArrayList<Human>) FactoryService.getInstance().getHumanService().getAllHumans());

                    System.out.println("**************************************************");
                    break;
                }
                case "8":
                {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                    System.out.println("**************************************************");
                }
            }
        }
    }

    /**
     * Отображает передаваемый список объектов
     * @param humansList список объектов типа {@link Human}
     */
    private void showHumansList(ArrayList<Human> humansList) {

        for (Human human: humansList) {
            System.out.println(human.toString());
        }
    }
}

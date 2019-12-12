package view;

import bean.Department;
import bean.Human;
import service.ExceptionService;
import service.MigrationService;
import service.ValidationService;

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
            System.out.println("1. Migrate data from xml to bd;");
            System.out.println("2. Only validate your xml with xsd;");
            System.out.println("3. Exit.");

            System.out.println("**************************************************");

            String chosenNumber = scanner.nextLine();

            System.out.println("**************************************************");

            switch (chosenNumber) {
                case "1": {
                    String result;

                    try {
                        MigrationService.MigrateAll();
                        result = "success";
                    }
                    catch (ExceptionService e) {
                        result = "error";
                    }

                    System.out.println(result);
                    break;
                }
                case "2": {
                    System.out.println("Enter xsd path:");
                    String xsdPath = scanner.nextLine();
                    System.out.println("Enter xml path:");
                    String xmlPath = scanner.nextLine();
                    System.out.println(ValidationService.validateXMLSchema(xsdPath, xmlPath));
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

}

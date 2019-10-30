package view;

import bean.Human;
import bean.MedicalWorker;
import bean.Intern;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс {@link HumanView} для диалога между пользователем и приложением
 * для создания нового объекта класса {@link Intern}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class InternView implements HumanView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Intern}
     */
    public Human startToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.startToCreate();

        System.out.println("Enter internship started date");
        String internshipStarted = scanner.nextLine();

        System.out.println("Enter amount of internship days");
        int injectionsDid;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            injectionsDid = 5;
        }
        else {
            injectionsDid = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of made mistakes");
        int mistakesMade;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            mistakesMade = 5;
        }
        else {
            mistakesMade = scanner.nextInt();
        }

        scanner.nextLine();

        return new Intern(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                          medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                          medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                          medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                          internshipStarted, injectionsDid, mistakesMade);
    }
}

package view;

import bean.Nurse;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс {@link HumanView} для диалога между пользователем и приложением
 * для создания нового объекта класса {@link Nurse}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class NurseView implements HumanView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Nurse}
     */
    public Human startToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.startToCreate();

        System.out.println("Enter current post");
        String currentPost = scanner.nextLine();

        System.out.println("Enter started working date");
        String startedWorking = scanner.nextLine();

        System.out.println("Enter amount of injections did");
        int injectionsDid;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            injectionsDid = 5;
        }
        else {
            injectionsDid = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter amount of patients saved");
        int patientsSaved;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            patientsSaved = 5;
        }
        else {
            patientsSaved = scanner.nextInt();
        }

        scanner.nextLine();

        return new Nurse(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                         medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                         medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                         medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                         currentPost, startedWorking, injectionsDid, patientsSaved);
    }
}

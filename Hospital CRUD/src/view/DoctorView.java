package view;

import bean.Doctor;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс {@link HumanView} для диалога между пользователем и приложением
 * для создания нового объекта класса {@link Doctor}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class DoctorView implements  HumanView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Doctor}
     */
    public Human startToCreate()
    {
        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.startToCreate();

        System.out.println("Enter current post");
        String currentPost = scanner.nextLine();

        System.out.println("Enter started working date");
        String startedWorking = scanner.nextLine();

        System.out.println("Enter amount of patients healed");
        int patientsHealed;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            patientsHealed = 5;
        }
        else {
            patientsHealed = scanner.nextInt();
        }

        scanner.nextLine();

        return new Doctor(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                          medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                          medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                          medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                          currentPost, startedWorking, patientsHealed);
    }
}

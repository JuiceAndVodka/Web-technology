package view;

import bean.HeadPhysician;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс {@link HumanView} для диалога между пользователем и приложением
 * для создания нового объекта класса {@link HeadPhysician}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class HeadPhysicianView implements HumanView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link HeadPhysician}
     */
    public HeadPhysician startToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.startToCreate();

        System.out.println("Enter started working date");
        String startedWorking = scanner.nextLine();

        System.out.println("Enter ended working date");
        String endedWorking = scanner.nextLine();

        System.out.println("Enter future plans for hospital");
        String futurePlansForHospital = scanner.nextLine();

        return new HeadPhysician(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                                 medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                                 medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                                 medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                                 startedWorking, endedWorking, futurePlansForHospital);

    }
}

package view;

import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

/**
 * Класс для создания нового объекта класса {@link MedicalWorker} диалога между пользователем и приложением
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class MedicalWorkerView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link MedicalWorker}
     */
    public static MedicalWorker startToCreate() {

        Scanner scanner = new Scanner(System.in);

        Human human = HumanViewImplementation.startToCreate();

        System.out.println("Enter diploma profession");
        String diplomaProfession = scanner.nextLine();

        System.out.println("Enter work phone number");
        String workPhoneNumber = scanner.nextLine();

        System.out.println("Enter university name");
        String universityName = scanner.nextLine();

        System.out.println("Enter university ended date");
        String universityEnded = scanner.nextLine();

        return new MedicalWorker(human.getName(), human.getSurname(), human.getPatronymic(), human.getGender(),
                                 human.getHomeAdress(), human.getBirthDay(), human.getPhoneNumber(),
                                 human.getDepartmentName(), diplomaProfession, workPhoneNumber, universityName,
                                 universityEnded);
    }
}

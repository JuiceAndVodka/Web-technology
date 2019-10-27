package view;

import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

public class MedicalWorkerView {

    public static MedicalWorker StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        Human human = HumanViewImplementation.StartToCreate();

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

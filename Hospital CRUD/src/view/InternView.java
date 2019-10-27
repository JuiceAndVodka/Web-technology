package view;

import bean.Human;
import bean.MedicalWorker;
import bean.Intern;

import java.util.Scanner;

public class InternView implements HumanView {

    public Human StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.StartToCreate();

        System.out.println("Enter internship started date");
        String internshipStarted = scanner.nextLine();

        System.out.println("Enter amount of internship days");
        int injectionsDid = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of made mistakes");
        int mistakesMade = scanner.nextInt();
        scanner.nextLine();

        return new Intern(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                          medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                          medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                          medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                          internshipStarted, injectionsDid, mistakesMade);
    }
}

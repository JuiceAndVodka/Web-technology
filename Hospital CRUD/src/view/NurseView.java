package view;

import bean.Nurse;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

public class NurseView implements HumanView {

    public Human StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.StartToCreate();

        System.out.println("Enter current post");
        String currentPost = scanner.nextLine();

        System.out.println("Enter started working date");
        String startedWorking = scanner.nextLine();

        System.out.println("Enter amount of injections did");
        int injectionsDid = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount of patients saved");
        int patientsSaved = scanner.nextInt();
        scanner.nextLine();

        return new Nurse(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                         medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                         medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                         medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                         currentPost, startedWorking, injectionsDid, patientsSaved);
    }
}
package view;

import bean.Doctor;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

public class DoctorView implements  HumanView {

    public Human StartToCreate()
    {
        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.StartToCreate();

        System.out.println("Enter current post");
        String currentPost = scanner.nextLine();

        System.out.println("Enter started working date");
        String startedWorking = scanner.nextLine();

        System.out.println("Enter amount of patients healed");
        int patientsHealed = scanner.nextInt();
        scanner.nextLine();

        return new Doctor(medicalWorker.getName(), medicalWorker.getSurname(), medicalWorker.getPatronymic(),
                          medicalWorker.getGender(), medicalWorker.getHomeAdress(), medicalWorker.getBirthDay(),
                          medicalWorker.getPhoneNumber(), medicalWorker.getDepartmentName(), medicalWorker.getDiplomaProfession(),
                          medicalWorker.getWorkPhoneNumber(), medicalWorker.getUniversityName(), medicalWorker.getUniversityEnded(),
                          currentPost, startedWorking, patientsHealed);
    }
}

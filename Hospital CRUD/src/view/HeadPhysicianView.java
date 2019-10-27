package view;

import bean.HeadPhysician;
import bean.Human;
import bean.MedicalWorker;

import java.util.Scanner;

public class HeadPhysicianView implements HumanView {

    public HeadPhysician StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        MedicalWorker medicalWorker = MedicalWorkerView.StartToCreate();

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

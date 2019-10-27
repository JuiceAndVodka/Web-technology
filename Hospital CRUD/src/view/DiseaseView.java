package view;

import bean.Disease;

import java.util.Scanner;

public class DiseaseView {

    public static Disease StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter data, when it started");
        String whenStarted = scanner.nextLine();

        System.out.println("Enter duration");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter patient complaints");
        String patientComplaints = scanner.nextLine();

        System.out.println("Enter prescribed treatments");
        String prescribedTreatments = scanner.nextLine();

        System.out.println("Enter was treatment success");
        boolean wasTreatmentSuccess = scanner.nextBoolean();
        scanner.nextLine();

        return new Disease(name, whenStarted, duration, patientComplaints, prescribedTreatments, wasTreatmentSuccess);
    }
}

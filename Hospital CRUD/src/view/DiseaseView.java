package view;

import bean.Disease;

import java.util.Scanner;

public class DiseaseView {

    public static Disease StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter disease name");
        String name = scanner.nextLine();

        System.out.println("Enter data, when it started");
        String whenStarted = scanner.nextLine();

        System.out.println("Enter disease duration");
        int duration;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            duration = 5;
        }
        else {
            duration = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Enter patient complaints");
        String patientComplaints = scanner.nextLine();

        System.out.println("Enter prescribed treatments");
        String prescribedTreatments = scanner.nextLine();

        System.out.println("Enter was treatment success");
        boolean wasTreatmentSuccess;

        if (!scanner.hasNextBoolean()) {
            System.out.println("Incorrect type value! Set default value: true");
            wasTreatmentSuccess = true;
        }
        else {
            wasTreatmentSuccess = scanner.nextBoolean();
        }

        scanner.nextLine();

        return new Disease(name, whenStarted, duration, patientComplaints, prescribedTreatments, wasTreatmentSuccess);
    }
}

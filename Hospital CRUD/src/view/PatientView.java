package view;

import bean.Disease;
import bean.Human;
import bean.Patient;

import java.util.Scanner;

public class PatientView implements  HumanView {

    public Human StartToCreate() {

        Scanner scanner = new Scanner(System.in);

        Human human = HumanViewImplementation.StartToCreate();

        System.out.println("Enter ward number");
        int wardNumber = scanner.nextInt();
        scanner.nextLine();

        Disease disease = DiseaseView.StartToCreate();

        return  new Patient(human.getName(), human.getSurname(), human.getPatronymic(), human.getGender(),
                            human.getHomeAdress(), human.getBirthDay(), human.getPhoneNumber(),
                            human.getDepartmentName(), wardNumber, disease);
    }
}
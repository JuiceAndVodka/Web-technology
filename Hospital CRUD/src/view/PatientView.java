package view;

import bean.Disease;
import bean.Human;
import bean.Patient;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс {@link HumanView} для диалога между пользователем и приложением
 * для создания нового объекта класса {@link Patient}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class PatientView implements  HumanView {

    /**
     * Создаёт новый объект путём общения пользователя и приложения для ввода нужных значений
     * @return новый объект типа {@link Patient}
     */
    public Human startToCreate() {

        Scanner scanner = new Scanner(System.in);

        Human human = HumanViewImplementation.startToCreate();

        System.out.println("Enter ward number");
        int wardNumber;

        if (!scanner.hasNextInt()) {
            System.out.println("Incorrect type value! Set default value: 5");
            wardNumber = 5;
        }
        else {
            wardNumber = scanner.nextInt();
        }

        scanner.nextLine();

        Disease disease = DiseaseView.startToCreate();

        return  new Patient(human.getName(), human.getSurname(), human.getPatronymic(), human.getGender(),
                            human.getHomeAdress(), human.getBirthDay(), human.getPhoneNumber(),
                            human.getDepartmentName(), wardNumber, disease);
    }
}

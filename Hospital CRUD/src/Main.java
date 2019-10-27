import bean.Doctor;
import bean.Human;
import bean.Intern;
import bean.Nurse;
import dao.TextFileHumanDAO;
import view.ConsoleView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {

        /*TextFileHumanDAO textFileHumanDAO = new TextFileHumanDAO();

        ArrayList<Human> humansList = textFileHumanDAO.getAll();

        humansList.add(new Doctor());
        humansList.add(new Nurse());
        humansList.add(new Intern());

        textFileHumanDAO.saveHumansToTextFile(humansList);*/

        ConsoleView consoleView = new ConsoleView();

        consoleView.Start();
    }

}

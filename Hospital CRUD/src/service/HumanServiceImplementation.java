package service;

import bean.Human;
import dao.FactoryDAO;
import dao.HumanDAO;

import java.util.ArrayList;
import java.util.Comparator;

public class HumanServiceImplementation implements HumanService {

    public Human getHuman(int id) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        return humanDAO.getById(id);
    }

    public ArrayList<Human> getAllHumans() {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        return humanDAO.getAll();
    }

    public void addHuman(Human human) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        humanDAO.create(human);
    }

    public void updateHuman(int id, Human human) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        humanDAO.update(id, human);
    }

    public void deleteHumanById(int id) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        humanDAO.deleteById(id);
    }

    public ArrayList<Human> sortByFirstName() {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        humansList.sort(new HumanFirstNameComparator());

        return humansList;
    }

    public ArrayList<Human> sortByGender() {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        humansList.sort(new HumanGenderComparator());

        return humansList;
    }

    public ArrayList<Human> findByFirstName(String name) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        ArrayList<Human> appropriateHumansList = new ArrayList<>();

        for (Human human: humansList)
        {
            if(human.getName().equals(name))
                appropriateHumansList.add(human);
        }

        return appropriateHumansList;
    }

    class HumanFirstNameComparator implements Comparator<Human> {

        public int compare(Human firstHuman, Human secondHuman){

            return firstHuman.getName().compareTo(secondHuman.getName());
        }
    }

    class HumanGenderComparator implements Comparator<Human>{

        public int compare(Human firstHuman, Human secondHuman){

            return firstHuman.getGender().compareTo(secondHuman.getGender());
        }
    }
}

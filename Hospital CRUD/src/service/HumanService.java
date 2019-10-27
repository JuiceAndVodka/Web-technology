package service;

import bean.Human;

import java.util.ArrayList;

public interface HumanService {

    Human getHuman(int id);
    ArrayList<Human> getAllHumans();

    void addHuman(Human user);
    void updateHuman(int id, Human user);
    void deleteHumanById(int id);

    ArrayList<Human> sortByFirstName();
    ArrayList<Human> sortByGender();
    ArrayList<Human> findByFirstName(String name);
}

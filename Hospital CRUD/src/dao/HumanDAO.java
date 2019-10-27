package dao;

import bean.Human;

import java.util.ArrayList;

public interface HumanDAO {

    ArrayList<Human> getAll();
    Human getById(int id);

    boolean create(Human human);
    boolean update(int id, Human human);
    boolean deleteById(int id);

}

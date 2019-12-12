package dao;

import bean.Human;
import java.util.List;

public interface HumanDAO {

    List<Human> getAllHumans() throws ExceptionDAO;
    void addHumans(List<Human> humansList)throws ExceptionDAO;
}

package service;

import bean.Human;
import dao.FactoryDAO;
import dao.HumanDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Класс бизнес логики для объектов типа {@link Human}, реализующий {@link DepartmentService}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class HumanServiceImplementation implements HumanService {

    /**
     * Возвращает объект типа {@link Human}, связываясь с Базой Данных
     * {@link FactoryDAO#getHumanDAO()}
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    public Human getHuman(int id) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        return humanDAO.getById(id);
    }

    /**
     * Получает список объектов типа {@link Human}, связываясь с Базой Данных
     * {@link FactoryDAO#getHumanDAO()}
     * @return список объектов типа {@link Human}
     */
    public ArrayList<Human> getAllHumans() {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        return humanDAO.getAll();
    }

    /**
     * Передаёт на добавление в Базу Данных объект типа {@link Human}
     * {@link FactoryDAO#getHumanDAO()}
     * @param human передаваемый для добавления объект типа {@link Human}
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean addHuman(Human human) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();

        humanDAO.create(human);

        return true;
    }

    /**
     * Передаёт на обновление в Базу Данных объект типа {@link Human}
     * {@link FactoryDAO#getHumanDAO()}
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param human новый объект типа {@link Human}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean updateHuman(int id, Human human) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        humanDAO.update(id, human);

        return  true;
    }

    /**
     * Передаёт на удаление в Базу Данных объект типа {@link Human}
     * {@link FactoryDAO#getHumanDAO()}
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean deleteHumanById(int id) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        humanDAO.deleteById(id);

        return  true;
    }

    /**
     * Сортирует все элементы списка с объектами типа {@link Human} по названию отделения,
     * получая список из Базы Данных
     * {@link FactoryDAO#getHumanDAO()}
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Human}
     */
    public ArrayList<Human> sortByDepartmentName(boolean doesAscending) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        Collections.sort(humansList, new HumanDepartmentNameComparator().thenComparing(new HumanFirstNameComparator()));

        if (!doesAscending) {
            Collections.reverse(humansList);
        }

        humanDAO.saveHumansToTextFile(humansList);

        return humansList;
    }

    /**
     * Сортирует все элементы списка с объектами типа {@link Human} по полу человека,
     * получая список из Базы Данных
     * {@link FactoryDAO#getHumanDAO()}
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Human}
     */
    public ArrayList<Human> sortByGender(boolean doesAscending) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        Collections.sort(humansList, new HumanGenderComparator());

        if (!doesAscending) {
            Collections.reverse(humansList);
        }

        humanDAO.saveHumansToTextFile(humansList);

        return humansList;
    }

    /**
     * Выполняет поиск подходящих объектов типа {@link Human} по критерию названия отдела, получая
     * список объектов из Базы Данных
     * {@link FactoryDAO#getHumanDAO()}
     * @param name название отделения (критерий поиска)
     * @return список найденных объектов типа {@link Human}
     */
    public ArrayList<Human> findByDepartmentName(String name) {

        HumanDAO humanDAO = FactoryDAO.getInstance().getHumanDAO();
        ArrayList<Human> humansList =  humanDAO.getAll();
        ArrayList<Human> appropriateHumansList = new ArrayList<>();

        for (Human human: humansList)
        {
            if(human.getDepartmentName().equals(name))
                appropriateHumansList.add(human);
        }

        return appropriateHumansList;
    }

    /**
     * Класс, реализующий интерфейс {@link Comparator<Human>}, для сравнения имени двух объектов
     * @author Абраменко Алексей, 751003
     * @version 1.0
     */
    class HumanDepartmentNameComparator implements Comparator<Human> {

        public int compare(Human firstHuman, Human secondHuman){

            return firstHuman.getDepartmentName().compareTo(secondHuman.getDepartmentName());
        }
    }

    /**
     * Класс, реализующий интерфейс {@link Comparator<Human>}, для сравнения имени двух объектов
     * @author Абраменко Алексей, 751003
     * @version 1.0
     */
    class HumanFirstNameComparator implements Comparator<Human> {

        public int compare(Human firstHuman, Human secondHuman){

            return firstHuman.getName().compareTo(secondHuman.getName());
        }
    }

    /**
     * Класс, реализующий интерфейс {@link Comparator<Human>}, для сравнения пола двух объектов
     * @author Абраменко Алексей, 751003
     * @version 1.0
     */
    class HumanGenderComparator implements Comparator<Human>{

        public int compare(Human firstHuman, Human secondHuman){

            return firstHuman.getGender().compareTo(secondHuman.getGender());
        }
    }
}

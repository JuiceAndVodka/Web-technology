package service;

import bean.Human;

import java.util.ArrayList;

/**
 * Интерфейс для представления бизнес-логии для объеков типа {@link Human}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public interface HumanService {

    /**
     * Возвращает объект типа {@link Human}
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    Human getHuman(int id);

    /**
     * Получает список объектов типа {@link Human}
     * @return список объектов типа {@link Human}
     */
    ArrayList<Human> getAllHumans();

    /**
     * Добаляет передаваемый объект типа {@link Human} в список таких объектов
     * @param human передаваемый для добавления объект типа {@link Human}
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean addHuman(Human human);

    /**
     * Обновляет существующий объект в списке объектов типа {@link Human}
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param human новый объект типа {@link Human}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean updateHuman(int id, Human human);

    /**
     * Удаляет существующий объект из списка объектов типа {@link Human}
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean deleteHumanById(int id);

    /**
     * Сортирует все элементы списка с объектами типа {@link Human} по названию отделения
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Human}
     */
    ArrayList<Human> sortByDepartmentName(boolean doesAscending);

    /**
     * Сортирует все элементы списка с объектами типа {@link Human} по полу человека
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Human}
     */
    ArrayList<Human> sortByGender(boolean doesAscending);

    /**
     * Выполняет поиск подходящих объектов типа {@link Human} по критерию названия отдела
     * @param name этаж (критерий поиска)
     * @return список найденных объектов типа {@link Human}
     */
    ArrayList<Human> findByDepartmentName(String name);
}

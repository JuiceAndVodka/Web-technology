package service;

import bean.Department;

import java.util.ArrayList;

/**
 * интерфейс для представления бизнес-логики для объеков типа {@link Department}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public interface DepartmentService {

    /**
     * Возвращает объект типа {@link Department}
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    Department getDepartment(int id);

    /**
     * Получает список объектов типа {@link Department}
     * @return список объектов типа {@link Department}
     */
    ArrayList<Department> getAllDepartments();

    /**
     * Добаляет передаваемый объект типа {@link Department} в список таких объектов
     * @param department передаваемый для добавления объект типа {@link Department}
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean addDepartment(Department department);

    /**
     * Обновляет существующий объект в списке объектов типа {@link Department}
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param department новый объект типа {@link Department}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean updateDepartment(int id, Department department);

    /**
     * Удаляет существующий объект из списка объектов типа {@link Department}
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean deleteDepartmentById(int id);

    /**
     * Сортирует все элементы списка с объектами типа {@link Department} по названию отделения
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Department}
     */
    ArrayList<Department> sortDepartmentByName(boolean doesAscending);

    /**
     * Сортирует все элементы списка с объектами типа {@link Department} по этажу отделения
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Department}
     */
    ArrayList<Department> sortDepartmentByFloor(boolean doesAscending);

    /**
     * Выполняет поиск подходящих объектов типа {@link Department} по критерию этажа
     * @param floor этаж (критерий поиска)
     * @return список найденных объектов типа {@link Department}
     */
    ArrayList<Department> findDepartmentByFloor(int floor);
}

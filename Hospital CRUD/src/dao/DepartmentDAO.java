package dao;

import bean.Department;

import java.util.ArrayList;

/**
 * Интерфейс для общения с Базой Данных ради объекта типа {@link Department}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public interface DepartmentDAO {

    /**
     * Получает все объекты типа {@link Department} из Базы Данных
     * @return список объектов типа {@link Department}
     */
    ArrayList<Department> getAll();

    /**
     * Возвращает объект типа {@link Department} из Базы Данных
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    Department getById(int id);

    /**
     * Передаёт в Базу Данных новый объект типа {@link Department} для хранения
     * @param department передаваемый для хранения объект типа {@link Department}
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean create(Department department);

    /**
     * Обновляет существующий объект в Базе Данных
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param department новый объект типа {@link Department}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean update(int id, Department department);

    /**
     * Удаляет существующий объект из Базы Данных
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean deleteById(int id);

    /**
     * Сохраняет все объекты типа {@link Department} в текстовый файл
     * @param departmentsList список объектов типа {@link Department} для сохранения
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean saveDepartmentsToTextFile(ArrayList<Department> departmentsList);
}

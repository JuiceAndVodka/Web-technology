package service;

import bean.Department;
import dao.DepartmentDAO;
import dao.FactoryDAO;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Класс бизнес логики для объектов типа {@link Department}, реализующий {@link DepartmentService}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class DepartmentServiceImplementation implements DepartmentService {

    /**
     * Возвращает объект типа {@link Department}, связываясь с Базой Данных
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    public Department getDepartment(int id)
    {
        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();

        return departmentDAO.getById(id);
    }

    /**
     * Получает список объектов типа {@link Department}, связываясь с Базой Данных
     * {@link FactoryDAO#getDepartmentDAO()}
     * @return список объектов типа {@link Department}
     */
    public List<Department> getAllDepartments() {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();

        return departmentDAO.getAll();
    }

    /**
     * Передаёт на добавление в Базу Данных объект типа {@link Department}
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param department передаваемый для добавления объект типа {@link Department}
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean addDepartment(Department department) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.create(department);

        return true;
    }

    /**
     * Передаёт на обновление в Базу Данных объект типа {@link Department}
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param department новый объект типа {@link Department}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean updateDepartment(int id, Department department) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.update(id, department);

        return true;
    }

    /**
     * Передаёт на удаление в Базу Данных объект типа {@link Department}
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean deleteDepartmentById(int id) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.deleteById(id);

        return true;
    }

    /**
     * Сортирует все элементы списка с объектами типа {@link Department} по названию отделения,
     * получая список из Базы Данных
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Department}
     */
    public List<Department> sortDepartmentByName(boolean doesAscending) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  (ArrayList<Department>)departmentDAO.getAll();
        Collections.sort(departmentsList, new DepartmentNameComparator());

        if (!doesAscending) {
            Collections.reverse(departmentsList);
        }

        departmentDAO.saveDepartmentsToTextFile(departmentsList);

        return departmentsList;
    }

    /**
     * Сортирует все элементы списка с объектами типа {@link Department} по этажу отделения,
     * получая список из Базы Данных
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param doesAscending восходящая или нисходящая сортировка
     * @return список отсортированных объектов типа {@link Department}
     */
    public List<Department> sortDepartmentByFloor(boolean doesAscending) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  (ArrayList<Department>)departmentDAO.getAll();
        Collections.sort(departmentsList, new DepartmentFloorComparator());

        if (!doesAscending) {
            Collections.reverse(departmentsList);
        }

        departmentDAO.saveDepartmentsToTextFile(departmentsList);

        return departmentsList;
    }

    /**
     * Выполняет поиск подходящих объектов типа {@link Department} по критерию этажа, получая
     * список объектов из Базы Данных
     * {@link FactoryDAO#getDepartmentDAO()}
     * @param floor этаж (критерий поиска)
     * @return список найденных объектов типа {@link Department}
     */
    public List<Department> findDepartmentByFloor(int floor) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  (ArrayList<Department>)departmentDAO.getAll();
        ArrayList<Department> appropriateDepartmentsList = new ArrayList<>();

        for (Department department: departmentsList)
        {
            if(department.getFloor() == floor) {
                appropriateDepartmentsList.add(department);
            }
        }

        return appropriateDepartmentsList;
    }

    /**
     * Класс, реализующий интерфейс {@link Comparator<Department>}, для сравнения имени двух объектов
     * @author Абраменко Алексей, 751003
     * @version 1.0
     */
    private class DepartmentNameComparator implements Comparator<Department> {

        public int compare(Department firstDepartment, Department secondDepartment){

            return firstDepartment.getName().compareTo(secondDepartment.getName());
        }
    }

    /**
     * Класс, реализующий интерфейс {@link Comparator<Department>}, для сравнения этажей двух объектов
     * @author Абраменко Алексей, 751003
     * @version 1.0
     */
    private class DepartmentFloorComparator implements Comparator<Department>{

        public int compare(Department firstDepartment, Department secondDepartment){

            if(firstDepartment.getFloor()> secondDepartment.getFloor()) {
                return 1;
            }
            else if(firstDepartment.getFloor()< secondDepartment.getFloor()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}

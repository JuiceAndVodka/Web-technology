package service;

import bean.Department;
import dao.DepartmentDAO;
import dao.FactoryDAO;

import java.util.ArrayList;
import java.util.Comparator;

public class DepartmentServiceImplementation implements DepartmentService {

    public Department getDepartment(int id)
    {
        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();

        return departmentDAO.getById(id);
    }

    public ArrayList<Department> getAllDepartments() {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();

        return departmentDAO.getAll();
    }

    public void addDepartment(Department department) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.create(department);
    }

    public void updateDepartment(int id, Department department) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.update(id, department);
    }

    public void deleteDepartmentById(int id) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        departmentDAO.deleteById(id);
    }

    public ArrayList<Department> sortDepartmentByName() {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  departmentDAO.getAll();
        departmentsList.sort(new DepartmentNameComparator());

        return departmentsList;
    }

    public ArrayList<Department> sortDepartmentByFloor() {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  departmentDAO.getAll();
        departmentsList.sort(new DepartmentFloorComparator());

        return departmentsList;
    }

    public ArrayList<Department> findDepartmentByFloor(String name) {

        DepartmentDAO departmentDAO = FactoryDAO.getInstance().getDepartmentDAO();
        ArrayList<Department> departmentsList =  departmentDAO.getAll();
        ArrayList<Department> appropriateDepartmentsList = new ArrayList<>();

        for (Department department: departmentsList)
        {
            if(department.getName().equals(name)) {
                appropriateDepartmentsList.add(department);
            }
        }

        return appropriateDepartmentsList;
    }

    class DepartmentNameComparator implements Comparator<Department> {

        public int compare(Department firstDepartment, Department secondDepartment){

            return firstDepartment.getName().compareTo(secondDepartment.getName());
        }
    }

    class DepartmentFloorComparator implements Comparator<Department>{

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

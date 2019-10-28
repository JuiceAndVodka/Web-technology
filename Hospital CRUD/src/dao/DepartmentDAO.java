package dao;

import bean.Department;

import java.util.ArrayList;

public interface DepartmentDAO {

    ArrayList<Department> getAll();
    Department getById(int id);

    boolean create(Department department);
    boolean update(int id, Department department);
    boolean deleteById(int id);

    boolean saveDepartmentsToTextFile(ArrayList<Department> departmentsList);
}

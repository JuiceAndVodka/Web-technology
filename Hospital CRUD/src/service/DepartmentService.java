package service;

import bean.Department;

import java.util.ArrayList;

public interface DepartmentService {

    Department getDepartment(int id);
    ArrayList<Department> getAllDepartments();

    void addDepartment(Department user);
    void updateDepartment(int id, Department user);
    void deleteDepartmentById(int id);

    ArrayList<Department> sortDepartmentByName();
    ArrayList<Department> sortDepartmentByFloor();
    ArrayList<Department> findDepartmentByFloor(String name);
}

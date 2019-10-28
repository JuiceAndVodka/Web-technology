package service;

import bean.Department;

import java.util.ArrayList;

public interface DepartmentService {

    Department getDepartment(int id);
    ArrayList<Department> getAllDepartments();

    void addDepartment(Department user);
    void updateDepartment(int id, Department user);
    void deleteDepartmentById(int id);

    ArrayList<Department> sortDepartmentByName(boolean doesAscending);
    ArrayList<Department> sortDepartmentByFloor(boolean doesAscending);
    ArrayList<Department> findDepartmentByFloor(int floor);
}

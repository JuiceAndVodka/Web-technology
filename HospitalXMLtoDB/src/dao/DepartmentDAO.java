package dao;

import bean.Department;
import java.util.List;

public interface DepartmentDAO {

    List<Department> getAllDepartments()throws ExceptionDAO;
    void addDepartments(List<Department> departmentsList)throws ExceptionDAO;
}

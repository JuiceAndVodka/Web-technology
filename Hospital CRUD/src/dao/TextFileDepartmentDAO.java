package dao;

import bean.Department;
import bean.Identifier;
import constants.GlobalConstants;
import dao.Serializers.DepartmentTextFileSerializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileDepartmentDAO implements DepartmentDAO {

    private ArrayList<Department> departmentsCash = null;

    public ArrayList<Department> getAll() {

        ArrayList<Department> departmentsList = getAllDepartments();
        return (ArrayList<Department>)departmentsList.clone();
    }

    private ArrayList<Department> getAllDepartments() {

        if (departmentsCash != null) {
            return  departmentsCash;
        }

        ArrayList<Department> departmentsList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {

            fileReader = new FileReader(GlobalConstants.SourceFilePath + "\\Departments.txt");
            bufferedReader = new BufferedReader(fileReader);

            while (true) {

                String readedLine = bufferedReader.readLine();

                if (readedLine == null) {
                    break;
                }

                DepartmentTextFileSerializer departmentTextFileSerializer = new DepartmentTextFileSerializer();
                departmentsList.add(departmentTextFileSerializer.deserializeDepartment(readedLine));
            }
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
        finally {

            try {

                fileReader.close();
                bufferedReader.close();
            }
            catch (Exception exception) {

                System.out.println("Error: " + exception.getMessage());
                exception.printStackTrace();
            }

        }

        departmentsCash = departmentsList;

        return departmentsList;
    }

    public Department getById(int id) {

        Department foundedDepartment = null;
        ArrayList<Department> departmentsList = getAllDepartments();

        for (Department department: departmentsList) {

            if (department.getId() == id) {
                foundedDepartment = department;
            }
        }

        return  foundedDepartment;
    }

    public  boolean create(Department department) {

        ArrayList<Department> departmentsList = getAllDepartments();

        department.setId(Identifier.getUniqId((new ArrayList<>(departmentsList))));

        departmentsList.add(department);

        try {
            return saveDepartmentsToTextFile(departmentsList);
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return  false;
        }
    }

    public boolean update(int id, Department department) {

        ArrayList<Department> departmentsList = getAllDepartments();

        for(int i = 0; i < departmentsList.size(); i++)
        {
            if(departmentsList.get(i).getId() == id)
            {
                department.setId(id);
                departmentsList.set(i, department);

                try {
                    return saveDepartmentsToTextFile(departmentsList);
                }
                catch (Exception exception) {

                    System.out.println("Error: " + exception.getMessage());
                    exception.printStackTrace();

                    return false;
                }
            }
        };

        return false;
    }

    public boolean deleteById(int id) {

        ArrayList<Department> departmentsList = getAllDepartments();

        for (int i = 0; i < departmentsList.size(); i++) {

            if(departmentsList.get(i).getId() == id) {

                departmentsList.remove(i);
                break;
            }
        }

        try {
            return saveDepartmentsToTextFile(departmentsList);
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return  false;
        }
    }

    public boolean saveDepartmentsToTextFile(ArrayList<Department> departmentsList) {

        try (FileWriter writer = new FileWriter(GlobalConstants.SourceFilePath + "\\Departments.txt", false)) {

            for(Department department: departmentsList) {

                DepartmentTextFileSerializer departmentTextFileSerializer = new DepartmentTextFileSerializer();
                writer.write(departmentTextFileSerializer.serializeDepartment(department));
                writer.append('\n');
            }

            writer.flush();

            return  true;
        }
        catch(Exception exception){

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return false;
        }
    }
}

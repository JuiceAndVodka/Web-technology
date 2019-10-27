package dao;

import bean.Department;
import bean.Identifier;
import dao.Serializers.DepartmentTextFileSerializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileDepartmentDAO implements DepartmentDAO {

    private ArrayList<Department> departmentsCash = null;

    public ArrayList<Department> getAll() {

        if (departmentsCash != null) {
            return  (ArrayList<Department>)departmentsCash.clone();
        }

        ArrayList<Department> departmentsList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {

            fileReader = new FileReader("D:\\Departments.txt");
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

        return (ArrayList<Department>)departmentsList.clone();
    }

    public Department getById(int id) {

        Department foundedDepartment = null;
        ArrayList<Department> departmentsList = getAll();

        for (Department department: departmentsList) {

            if (department.getId() == id) {
                foundedDepartment = department;
            }
        }

        return  foundedDepartment;
    }

    public  boolean create(Department department) {

        ArrayList<Department> departmentsList = getAll();

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

        ArrayList<Department> departmentsList = getAll();

        for(int i = 0; i < departmentsList.size(); i++)
        {
            if(departmentsList.get(i).getId() == id)
            {
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

        ArrayList<Department> departmentsList = getAll();

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

        try (FileWriter writer = new FileWriter("D:\\Departments.txt", false)) {

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

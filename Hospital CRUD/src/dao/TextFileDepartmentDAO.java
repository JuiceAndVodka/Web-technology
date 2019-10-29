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

/**
 * Класс файлового представления Базы Данных, реализующий интерфейс {@link DepartmentDAO}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class TextFileDepartmentDAO implements DepartmentDAO {

    /** Список объектов типа {@link Department}, используемый в качестве кэша */
    private ArrayList<Department> departmentsCash = null;

    /**
     * Получение всех объектов типа {@link Department}, хранящихся в текстовом файле
     * @return список объектов типа {@link Department}
     */
    public ArrayList<Department> getAll() {

        ArrayList<Department> departmentsList = getAllDepartments();
        return (ArrayList<Department>)departmentsList.clone();
    }

    /**
     * Непосредственная загрузка объекто типа {@link Department} из текстового файла
     * @return список загруженных объектов
     */
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

    /**
     * Получение объекта из списка объектов по его идентификационному номеру
     * @param id идентификационный номер нужного объекта
     * @return найденный объект типа {@link Department}
     */
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

    /**
     * Сохранение недавно созданного объекта типа {@link Department}
     * @param department передаваемый для хранения объект типа {@link Department}
     * @return значение (true/ false), указывающее на результат операции
     */
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

    /**
     * Обновляет объект с подходящим идентификационным номера в текстовом файле
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param department новый объект типа {@link Department}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
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

    /**
     * Удаляет объект типа {@link Department} с подходящим идентификационным номером из файла
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
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

    /**
     * Сохраняет передаваемый список объектов типа {@link Department} в текстовый файл
     * @param departmentsList список объектов типа {@link Department} для сохранения
     * @return значение (true/ false), указывающее на результат операции
     */
    public boolean saveDepartmentsToTextFile(ArrayList<Department> departmentsList) {

        try (FileWriter writer = new FileWriter(GlobalConstants.SourceFilePath + "\\Departments.txt", false)) {

            for(Department department: departmentsList) {

                DepartmentTextFileSerializer departmentTextFileSerializer = new DepartmentTextFileSerializer();
                writer.write(departmentTextFileSerializer.serializeDepartment(department));
                writer.append('\n');
            }

            writer.flush();

            departmentsCash = (ArrayList<Department>)departmentsList.clone();

            return  true;
        }
        catch(Exception exception){

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return false;
        }
    }
}

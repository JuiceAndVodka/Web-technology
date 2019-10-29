package dao.Serializers;

import bean.Department;

/**
 * Класс текстового сериализатора объекта класса {@link Department}, содержащий в себе сериализатор и десериализатор
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class DepartmentTextFileSerializer {

    /** Поле символа для разделения полей объекта */
    private String fieldsDelimiter = "#";

    /**
     * Преобразует поля передаваемого объекта в нужное строковое представление для сериализации
     * @param department передаваемый объект для сериализации тип {@link Department}
     * @return строковое представление передаваемого объекта для сериализации
     */
    public String serializeDepartment(Department department)
    {
        String string = "Department" + fieldsDelimiter +
                        department.getId() + fieldsDelimiter +
                        department.getName() + fieldsDelimiter +
                        department.getFloor() + fieldsDelimiter +
                        department.getWardsAmount() + fieldsDelimiter +
                        department.getDoctorsAmount() + fieldsDelimiter +
                        department.getCurrentPatientsAmount() + fieldsDelimiter +
                        department.getMaxPatientsAmount() + fieldsDelimiter;

        return string;
    }

    /**
     * Преобразует передаваемую строку в нужный объект (десериализации)
     * @param stringDepartment строковое представление десериализуемого объекта
     * @return объект типа {@link Department}
     */
    public Department deserializeDepartment(String stringDepartment)
    {
        String[] departmentFields = stringDepartment.split(fieldsDelimiter);

        if(departmentFields.length != 8) {
            return null;
        }

        Department department = new Department(departmentFields[2], Integer.parseInt(departmentFields[3]), Integer.parseInt(departmentFields[4]),
                                               Integer.parseInt(departmentFields[5]), Integer.parseInt(departmentFields[6]), Integer.parseInt(departmentFields[7]));

        department.setId(Integer.parseInt(departmentFields[1]));

        return department;
    }

}

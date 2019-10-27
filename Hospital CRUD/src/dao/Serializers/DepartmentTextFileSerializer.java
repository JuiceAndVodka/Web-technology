package dao.Serializers;

import bean.Department;

public class DepartmentTextFileSerializer {

    private String fieldsDelimiter = "#";

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

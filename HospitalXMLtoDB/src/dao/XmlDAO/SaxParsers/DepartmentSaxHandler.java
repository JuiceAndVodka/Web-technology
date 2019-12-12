package dao.XmlDAO.SaxParsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import bean.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSaxHandler extends DefaultHandler {

    private List<Department> departmentsList = new ArrayList<Department>();
    private Department department;
    private StringBuilder text;

    public List<Department> getDepartmentsList()
    {
        return departmentsList;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Department"))
        {
            department = new Department("", 0, 0, 0, 0, 0);
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void  endElement(String uri,String localName,String qName)
    {
        DepartmentTagName tagName = DepartmentTagName.valueOf(qName.toUpperCase().replace("-","_"));
        switch(tagName){
            case ID:
                department.setId(Integer.parseInt(text.toString()));
                break;
            case NAME:
                department.setName(text.toString());
                break;
            case FLOOR:
                department.setFloor(Integer.parseInt(text.toString()));
                break;
            case WARDSAMOUNT:
                department.setWardsAmount(Integer.parseInt(text.toString()));
                break;
            case DOCTORSAMOUNT:
                department.setDoctorsAmount(Integer.parseInt(text.toString()));
                break;
            case CURRENTPATIENTSAMOUNT:
                department.setCurrentPatientsAmount(Integer.parseInt(text.toString()));
                break;
            case MAXPATIENTSAMOUNT:
                department.setMaxPatientsAmount(Integer.parseInt(text.toString()));
                break;
            case DEPARTMENT:
                departmentsList.add(department);
                department = null;
                break;
        }
    }

    public void warning(SAXParseException exception)
    {

    }

    public void error(SAXParseException exception){

    }

    public void fatalError(SAXParseException exception){

    }
}

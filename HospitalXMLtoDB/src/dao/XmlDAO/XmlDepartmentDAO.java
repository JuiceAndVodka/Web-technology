package dao.XmlDAO;

import bean.Department;
import dao.DepartmentDAO;
import dao.ExceptionDAO;
import dao.XmlDAO.SaxParsers.DepartmentSaxHandler;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Arrays;
import java.util.List;

public class XmlDepartmentDAO implements DepartmentDAO {

    public static final Logger LOG = Logger.getLogger(DepartmentDAO.class.getName());

    public List<Department> getAllDepartments()throws ExceptionDAO {
        List<Department> departmentsList = null;
        try {
            /*SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();*/
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DepartmentSaxHandler handler = new DepartmentSaxHandler();
            reader.setContentHandler(handler);
            reader.parse("C:\\Users\\User\\IdeaProjects\\HospitalXMLtoDB\\src\\xmlFiles\\departments.xml");
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            departmentsList = handler.getDepartmentsList();
        }
        catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
            throw new ExceptionDAO(e);
        }
        return departmentsList;
    }

    public void addDepartments(List<Department> librarians) throws ExceptionDAO {

    }
}

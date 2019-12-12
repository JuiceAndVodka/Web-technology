package dao.XmlDAO;

import bean.Human;
import dao.HumanDAO;
import dao.ExceptionDAO;
import dao.XmlDAO.SaxParsers.HumanSaxHandler;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.Arrays;
import java.util.List;

public class XmlHumanDAO {

    public static final Logger LOG = Logger.getLogger(HumanDAO.class.getName());

    public List<Human> getAllHumans()throws ExceptionDAO {
        List<Human> humansList = null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            HumanSaxHandler handler = new HumanSaxHandler();
            reader.setContentHandler(handler);
            reader.parse("C:\\Users\\User\\IdeaProjects\\HospitalXMLtoDB\\src\\xmlFiles\\humans.xml");
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            humansList = handler.getHumansList();
        }
        catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
            throw new ExceptionDAO(e);
        }
        return humansList;
    }

    public void addDepartments(List<Human> librarians) throws ExceptionDAO {

    }
}

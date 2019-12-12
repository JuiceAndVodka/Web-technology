package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import dao.DataBaseDAO.DBDepartmentDAO;
import dao.DataBaseDAO.DBHumanDAO;
import dao.ExceptionDAO;
import dao.XmlDAO.XmlDepartmentDAO;
import dao.XmlDAO.XmlHumanDAO;
import org.apache.log4j.*;

public class MigrationService {

    public static final Logger LOG = Logger.getLogger( MigrationService.class.getName());

    public static void MigrateAll() throws ExceptionService
    {
        try {
            LOG.log(Level.INFO,"Start departments parsing");
            XmlDepartmentDAO departmentDAO = new XmlDepartmentDAO();
            var departmentsList = departmentDAO.getAllDepartments();
            DBDepartmentDAO dbDepartmentDAO = new DBDepartmentDAO();
            dbDepartmentDAO.addDepartments(departmentsList);
            LOG.log(Level.INFO,"End departments parsing");

            LOG.log(Level.INFO,"Begin users parse");
            XmlHumanDAO humanDAO = new XmlHumanDAO();
            var humansList = humanDAO.getAllHumans();
            DBHumanDAO dbHumanDAO = new DBHumanDAO();
            dbHumanDAO.addHumans(humansList);
            LOG.log(Level.INFO,"End users parsing");

        }
        catch (ExceptionDAO e)
        {
            LOG.log(Level.ERROR,e.getMessage());
            throw new ExceptionService(e);
        }
    }
}

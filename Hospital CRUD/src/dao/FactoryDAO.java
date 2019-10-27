package dao;

public class FactoryDAO {

    private static final FactoryDAO factoryDAO = new FactoryDAO();

    private DepartmentDAO departmentDAO = new TextFileDepartmentDAO();
    private HumanDAO humanDAO = new TextFileHumanDAO();

    public static FactoryDAO getInstance() {
        return  factoryDAO;
    }

    public DepartmentDAO getDepartmentDAO() {
        return  departmentDAO;
    }

    public HumanDAO getHumanDAO() {
        return  humanDAO;
    }
}

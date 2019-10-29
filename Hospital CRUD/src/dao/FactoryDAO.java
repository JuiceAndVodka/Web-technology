package dao;

/**
 * Класс, являющийся фабрикой для получения нужного объекта для связи с Базой Данных
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class FactoryDAO {

    /** Поле экземпляра класса {@link FactoryDAO} */
    private static final FactoryDAO factoryDAO = new FactoryDAO();

    /** Поле объекта, выполняющего связь с Базой Данных для объектов типа {@link bean.Department}
     *  {@link TextFileHumanDAO}
     */
    private DepartmentDAO departmentDAO = new TextFileDepartmentDAO();

    /** Поле объекта, выполняющего связь с Базой Данных для объектов типа {@link bean.Human}
     * {@link TextFileHumanDAO}
     */
    private HumanDAO humanDAO = new TextFileHumanDAO();

    /**
     * Функция получения приватного поля {@link FactoryDAO#factoryDAO}
     * @return поле {@link FactoryDAO#factoryDAO}
     */
    public static FactoryDAO getInstance() {
        return  factoryDAO;
    }

    /**
     * Функция получения приватного поля {@link FactoryDAO#departmentDAO}
     * @return поле {@link FactoryDAO#departmentDAO}
     */
    public DepartmentDAO getDepartmentDAO() {
        return  departmentDAO;
    }

    /**
     * Функция получения приватного поля {@link FactoryDAO#humanDAO}
     * @return поле {@link FactoryDAO#humanDAO}
     */
    public HumanDAO getHumanDAO() {
        return  humanDAO;
    }
}

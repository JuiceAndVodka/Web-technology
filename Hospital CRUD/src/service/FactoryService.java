package service;

/**
 * Класс, являющийся фабрикой для получения нужного объекта для выполнения бизнес-логики
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class FactoryService {

    /** Поле экземпляра класса {@link FactoryService} */
    private static final FactoryService factoryService = new FactoryService();

    /** Поле объекта, выполняющего бизнес-логику для объектов типа {@link bean.Department}
     *  {@link DepartmentServiceImplementation}
     */
    private DepartmentService departmentService = new DepartmentServiceImplementation();

    /** Поле объекта, выполняющего бизнес-логику для объектов типа {@link bean.Human}
     * {@link HumanServiceImplementation}
     */
    private HumanService humanService = new HumanServiceImplementation();

    /**
     * Функция получения приватного поля {@link FactoryService#factoryService}
     * @return поле {@link FactoryService#factoryService}
     */
    public static FactoryService getInstance() {
        return factoryService;
    }

    /**
     * Функция получения приватного поля {@link FactoryService#departmentService}
     * @return поле {@link FactoryService#departmentService}
     */
    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    /**
     * Функция получения приватного поля {@link FactoryService#humanService}
     * @return поле {@link FactoryService#humanService}
     */
    public HumanService getHumanService() {
        return humanService;
    }
}

package service;

public class FactoryService {

    private static final FactoryService factoryService = new FactoryService();
    private DepartmentService departmentService = new DepartmentServiceImplementation();
    private HumanService humanService = new HumanServiceImplementation();

    public static FactoryService getInstance() {
        return factoryService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public HumanService getHumanService() {
        return humanService;
    }
}

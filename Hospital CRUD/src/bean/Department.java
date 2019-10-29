package bean;

/**
 * Класс Department, производный от класса {@link Identifier} и содержащий приватные поля, их геттеры и сеттеры,
 * а также переопределение метода {@link Department#toString()} и {@link Department#compareTo(Department)}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Department extends  Identifier implements Comparable<Department>
{
    /** Поле названия */
    private String Name;
    /** Поле этажа */
    private int Floor;
    /** Поле количества палат */
    private int WardsAmount;
    /** Поле количества врачей */
    private int DoctorsAmount;
    /** Поле текущего количества пациентов */
    private int CurrentPatientsAmount;
    /** Поле максимального количества пациентов */
    private int MaxPatientsAmount;

    /**
     * Конструктор без параметров класса Department, в котором поля инициализируются стандартными значениями
     * @see Department#Department(String, int, int, int, int, int)
     */
    public  Department()
    {
        this.Name = "Therapity departnment";
        this.Floor = 1;
        this.WardsAmount = 30;
        this.DoctorsAmount = 15;
        this.CurrentPatientsAmount = 22;
        this.MaxPatientsAmount = 11;
    }

    /**
     * Конструктор с параметрами класс Department, в котором поля инициализируются переданными значениями
     * @param name название отделения
     * @param floor этаж отделения
     * @param wardsAmount количество палат в отделении
     * @param doctorsAmount количество докторов в отделении
     * @param currentPatientsAmount текущее количество пациентов в отделении
     * @param maxPatientsAmount максимальное количество пациентов в отделении
     * @see Department#Department()
     */
    public Department(String name, int floor, int wardsAmount, int doctorsAmount, int currentPatientsAmount,
                      int maxPatientsAmount)
    {
        this.Name = name;
        this.Floor = floor;
        this.WardsAmount = wardsAmount;
        this.DoctorsAmount = doctorsAmount;
        this.CurrentPatientsAmount = currentPatientsAmount;
        this.MaxPatientsAmount = maxPatientsAmount;
    }

    /**
     * Функция получения приватного поля {@link Department#Name}
     * @return поле {@link Department#Name}
     */
    public String getName() {
        return Name;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#Name}
     * @param name название отделения
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Функция получения приватного поля {@link Department#Floor}
     * @return поле {@link Department#Floor}
     */
    public Integer getFloor() {
        return Floor;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#Floor}
     * @param floor этаж отделения
     */
    public void setFloor(int floor) {
        Floor = floor;
    }

    /**
     * Функция получения приватного поля {@link Department#WardsAmount}
     * @return поле {@link Department#WardsAmount}
     */
    public int getWardsAmount() {
        return WardsAmount;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#WardsAmount}
     * @param wardsAmount количество палат в отделении
     */
    public void setWardsAmount(int wardsAmount) {
        WardsAmount = wardsAmount;
    }

    /**
     * Функция получения приватного поля {@link Department#DoctorsAmount}
     * @return поле {@link Department#DoctorsAmount}
     */
    public int getDoctorsAmount() {
        return DoctorsAmount;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#DoctorsAmount}
     * @param doctorsAmount количество врачей в отделении
     */
    public void setDoctorsAmount(int doctorsAmount) {
        DoctorsAmount = doctorsAmount;
    }

    /**
     * Функция получения приватного поля {@link Department#CurrentPatientsAmount}
     * @return поле {@link Department#CurrentPatientsAmount}
     */
    public int getCurrentPatientsAmount() {
        return CurrentPatientsAmount;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#CurrentPatientsAmount}
     * @param currentPatientsAmount текущее количество пациентов в отделении
     */
    public void setCurrentPatientsAmount(int currentPatientsAmount) {
        CurrentPatientsAmount = currentPatientsAmount;
    }

    /**
     * Функция получения приватного поля {@link Department#MaxPatientsAmount}
     * @return поле {@link Department#MaxPatientsAmount}
     */
    public int getMaxPatientsAmount() {
        return MaxPatientsAmount;
    }

    /**
     * Функция задания нового значения приватному полю {@link Department#MaxPatientsAmount}
     * @param maxPatientsAmount максимальное количество пациентов в отделении
     */
    public void setMaxPatientsAmount(int maxPatientsAmount) {
        MaxPatientsAmount = maxPatientsAmount;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "Name: " + this.Name + "\n" +
                        "Id: " + this.getId() + "\n" +
                        "Floor: " + this.Floor + "\n" +
                        "WardsAmount: " + this.WardsAmount + "\n" +
                        "DoctorsAmount: " + this.DoctorsAmount + "\n" +
                        "CurrentPatientsAmount: " + this.CurrentPatientsAmount + "\n" +
                        "MaxPatientsAmount: " + this.MaxPatientsAmount + "\n\n";

        return string;
    }

    /**
     * Сравнивает поле {@link Department#Name} с полем {@link Department#Name} переданного объекта
     * @param department объект класса {@link Department}
     * @return число (-1 / 0 / 1), обозначающее, поле какого объекта меньше при сравнении
     */
    public int compareTo(Department department) {
        return Name.compareTo(department.getName());
    }
}

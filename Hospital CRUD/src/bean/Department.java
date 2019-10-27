package bean;

public class Department extends  Identifier implements Comparable<Department>
{
    private String Name;
    private int Floor;
    private int WardsAmount;
    private int DoctorsAmount;
    private int CurrentPatientsAmount;
    private int MaxPatientsAmount;

    public  Department()
    {
        this.Name = "Therapity departnment";
        this.Floor = 1;
        this.WardsAmount = 30;
        this.DoctorsAmount = 15;
        this.CurrentPatientsAmount = 22;
        this.MaxPatientsAmount = 11;
    }

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public int getWardsAmount() {
        return WardsAmount;
    }

    public void setWardsAmount(int wardsAmount) {
        WardsAmount = wardsAmount;
    }

    public int getDoctorsAmount() {
        return DoctorsAmount;
    }

    public void setDoctorsAmount(int doctorsAmount) {
        DoctorsAmount = doctorsAmount;
    }

    public int getCurrentPatientsAmount() {
        return CurrentPatientsAmount;
    }

    public void setCurrentPatientsAmount(int currentPatientsAmount) {
        CurrentPatientsAmount = currentPatientsAmount;
    }

    public int getMaxPatientsAmount() {
        return MaxPatientsAmount;
    }

    public void setMaxPatientsAmount(int maxPatientsAmount) {
        MaxPatientsAmount = maxPatientsAmount;
    }

    @Override
    public String toString()
    {
        String string = "Name: " + this.Name + "\n" +
                        "Floor: " + this.Floor + "\n" +
                        "WardsAmount" + this.WardsAmount + "\n" +
                        "DoctorsAmount: " + this.DoctorsAmount + "\n" +
                        "CurrentPatientsAmount: " + this.CurrentPatientsAmount + "\n" +
                        "MaxPatientsAmount: " + this.MaxPatientsAmount + "\n\n";

        return string;
    }

    public int compareTo(Department department) {
        return Name.compareTo(department.getName());
    }
}

package bean;

/**
 * Класс Disease, используемый в качестве поля класс {@link Patient}
 * @author Алексей Абраменко, группа 751003
 * @version 1.0
 */
public class Disease
{
    /** Поле названия */
    private String Name;
    /** Поле даты начала */
    private String WhenStarted;
    /** Поле продолжительности */
    private int Duration;
    /** Поле жалобы пациента */
    private String PatientComplaints;
    /** Поле прописанного лечения */
    private String PrescribedTreatment;
    /** Поле было ли лечение успешным */
    private Boolean WasTreatmentSuccess;

    /**
     * Конструктор без параметров класса {@link Disease}, в котором все поля инициализируются стандартными значениями
     * @see Disease#Disease(String, String, int, String, String, Boolean)
     */
    public  Disease()
    {
        this.Name = "Nothing";
        this.WhenStarted = "22.06.1941";
        this.Duration = 100;
        this.PatientComplaints = "It hurts";
        this.PrescribedTreatment = "Some pill";
        this.WasTreatmentSuccess = true;
    }

    /**
     * Конструктор с параметрами класс {@link Disease}, в котором все поля инициализируются переданными значениями
     * @param name название болензи
     * @param whenStarted дата начала болезни
     * @param duration продолжительность болезни
     * @param patientComplaints жалобы пациента
     * @param prescribedTreatment прописанное лечение
     * @param wasTreatmentSuccess было ли лечение успешным
     * @see Disease#Disease()
     */
    public  Disease(String name, String  whenStarted, int duration, String  patientComplaints, String prescribedTreatment, Boolean wasTreatmentSuccess)
    {
        this.Name = name;
        this.WhenStarted = whenStarted;
        this.Duration = duration;
        this.PatientComplaints = patientComplaints;
        this.PrescribedTreatment = prescribedTreatment;
        this.WasTreatmentSuccess = wasTreatmentSuccess;
    }

    /**
     * Функция получения приватного поля {@link Disease#Name}
     * @return поле {@link Disease#Name}
     */
    public String getName() {
        return Name;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#Name}
     * @param name название болезни
     */
    public void setName(String name)
    {
        Name = name;
    }

    /**
     * Функция получения приватного поля {@link Disease#WhenStarted}
     * @return поле {@link Disease#WhenStarted}
     */
    public String getWhenStarted()
    {
        return WhenStarted;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#WhenStarted}
     * @param whenStarted дата начала болезни
     */
    public void setWhenStarted(String whenStarted)
    {
        WhenStarted = whenStarted;
    }

    /**
     * Функция получения приватного поля {@link Disease#Duration}
     * @return поле {@link Disease#Duration}
     */
    public int getDuration()
    {
        return Duration;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#Duration}
     * @param duration продолжительность болезни
     */
    public void setDuration(int duration)
    {
        Duration = duration;
    }

    /**
     * Функция получения приватного поля {@link Disease#PatientComplaints}
     * @return поле {@link Disease#PatientComplaints}
     */
    public String getPatientComplaints()
    {
        return PatientComplaints;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#PatientComplaints}
     * @param patientComplaints жалобы пациента
     */
    public void setPatientComplaints(String patientComplaints)
    {
        PatientComplaints = patientComplaints;
    }

    /**
     * Функция получения приватного поля {@link Disease#PatientComplaints}
     * @return поле {@link Disease#PatientComplaints}
     */
    public String getPrescribedTreatment()
    {
        return PrescribedTreatment;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#PrescribedTreatment}
     * @param prescribedTreatment прописанное лечение
     */
    public void setPrescribedTreatment(String prescribedTreatment)
    {
        PrescribedTreatment = prescribedTreatment;
    }

    /**
     * Функция получения приватного поля {@link Disease#WasTreatmentSuccess}
     * @return поле {@link Disease#WasTreatmentSuccess}
     */
    public Boolean getWasTreatmentSuccess()
    {
        return WasTreatmentSuccess;
    }

    /**
     * Функция задания нового значения приватному полю {@link Disease#WasTreatmentSuccess}
     * @param wasTreatmentSuccess было ли лечение успешным
     */
    public void setWasTreatmentSuccess(Boolean wasTreatmentSuccess)
    {
        WasTreatmentSuccess = wasTreatmentSuccess;
    }

    /**
     * Превращает все поля класса в строковое представление корректного для вывода
     * @return строковое представление всех полей класса
     */
    @Override
    public String toString()
    {
        String string = "\t" + "Disease" + "\n" +
                        "\t" + "Name: " + this.Name + "\n" +
                        "\t" + "WhenStarted: " + this.WhenStarted + "\n" +
                        "\t" + "Duration: " + this.Duration + "\n" +
                        "\t" + "PatientComplaints: " + this.PatientComplaints + "\n" +
                        "\t" + "PrescribedTreatment: " + this.PrescribedTreatment + "\n" +
                        "\t" + "WasTreatmentsSuccess: " + this.WasTreatmentSuccess + "\n\n";

        return string;
    }
}

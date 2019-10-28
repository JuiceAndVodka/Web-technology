package bean;

public class Disease
{
    private String Name;
    private String WhenStarted;
    private int Duration;
    private String PatientComplaints;
    private String PrescribedTreatment;
    private Boolean WasTreatmentSuccess;

    public  Disease()
    {
        this.Name = "Nothing";
        this.WhenStarted = "22.06.1941";
        this.Duration = 100;
        this.PatientComplaints = "It hurts";
        this.PrescribedTreatment = "Some pill";
        this.WasTreatmentSuccess = true;
    }

    public  Disease(String name, String  whenStarted, int duration, String  patientComplaints, String prescribedTreatment, Boolean wasTreatmentSuccess)
    {
        this.Name = name;
        this.WhenStarted = whenStarted;
        this.Duration = duration;
        this.PatientComplaints = patientComplaints;
        this.PrescribedTreatment = prescribedTreatment;
        this.WasTreatmentSuccess = wasTreatmentSuccess;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getWhenStarted()
    {
        return WhenStarted;
    }

    public void setWhenStarted(String whenStarted)
    {
        WhenStarted = whenStarted;
    }

    public int getDuration()
    {
        return Duration;
    }

    public void setDuration(int duration)
    {
        Duration = duration;
    }

    public String getPatientComplaints()
    {
        return PatientComplaints;
    }

    public void setPatientComplaints(String patientComplaints)
    {
        PatientComplaints = patientComplaints;
    }

    public String getPrescribedTreatment()
    {
        return PrescribedTreatment;
    }

    public void setPrescribedTreatment(String prescribedTreatment)
    {
        PrescribedTreatment = prescribedTreatment;
    }

    public Boolean getWasTreatmentSuccess()
    {
        return WasTreatmentSuccess;
    }

    public void setWasTreatmentSuccess(Boolean wasTreatmentSuccess)
    {
        WasTreatmentSuccess = wasTreatmentSuccess;
    }

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

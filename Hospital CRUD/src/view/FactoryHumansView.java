package view;

import bean.*;

import java.util.HashMap;
import java.util.Map;

public class FactoryHumansView {

    static Map<String, HumanView> humansView = new HashMap<>(){};

    static {
        humansView.put(HeadPhysician.class.getSimpleName(),new HeadPhysicianView());
        humansView.put(Doctor.class.getSimpleName(),new DoctorView());
        humansView.put(Nurse.class.getSimpleName(),new NurseView());
        humansView.put(Intern.class.getSimpleName(),new InternView());
        humansView.put(Patient.class.getSimpleName(), new PatientView());
    }

    public static HumanView GetView(String classSimpleName) {
        return humansView.get(classSimpleName);
    }

}

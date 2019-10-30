package view;

import bean.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, являющийся фабрикой для получения нужного объекта для выполнения создания нового объекта
 * класса {@link Human}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class FactoryHumansView {

    /** Хэшмап (массив с парами "ключ-значение"), содержащий в себе интерфейс создания объекта */
    static Map<String, HumanView> humansView = new HashMap<>(){};

    static {
        humansView.put(HeadPhysician.class.getSimpleName(),new HeadPhysicianView());
        humansView.put(Doctor.class.getSimpleName(),new DoctorView());
        humansView.put(Nurse.class.getSimpleName(),new NurseView());
        humansView.put(Intern.class.getSimpleName(),new InternView());
        humansView.put(Patient.class.getSimpleName(), new PatientView());
    }

    /**
     * Функция получения приватного поля типа {@link HumanView}
     * @param classSimpleName имя типа класса для получения значения из {@link FactoryHumansView#humansView}
     * @return поле производного типа от {@link HumanView}
     */
    public static HumanView getView(String classSimpleName) {
        return humansView.get(classSimpleName);
    }

}

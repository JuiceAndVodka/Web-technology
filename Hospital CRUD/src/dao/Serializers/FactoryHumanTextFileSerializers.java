package dao.Serializers;

import bean.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, являющийся фабрикой сериализаторов производных от интерфейса {@link HumanTextFileSerializer} и
 * содержащий в себе методы сериализации и десериализации
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class FactoryHumanTextFileSerializers {

    /** Хэшмап (массив с парами "ключ-значение"), содержащий в себе сериализаторы */
    static Map<String, HumanTextFileSerializer> states = new HashMap<>(){};

    static {
        states.put(HeadPhysician.class.getSimpleName(),new HeadPhysicianTextFileSerializer());
        states.put(Doctor.class.getSimpleName(),new DoctorTextFileSerializer());
        states.put(Nurse.class.getSimpleName(),new NurseTextFileSerializer());
        states.put(Intern.class.getSimpleName(),new InternTextFileSerializer());
        states.put(Patient.class.getSimpleName(),new PatientTextFileSerializer());
    }

    /**
     * Сериализует передаваемый объект типа {@link Human}, вызывая нужный сериализатор, который достаётся
     * из {@link FactoryHumanTextFileSerializers#states}, благодаря методу getSimpleName(), который возвращает
     * имя типа передаваемого класса
     * @param human объект типа {@link Human} для сериализации
     * @return сериализованный объект в виде строкового представления
     */
    public String serializeHuman(Human human)
    {
        HumanTextFileSerializer humanTextFileSerializer = states.get(human.getClass().getSimpleName());
        return humanTextFileSerializer.serializeHuman(human);
    }

    /**
     * Десериализует передаваемый объект типа {@link Human}, вызывая нужный десериализатор, который достаётся
     * из {@link FactoryHumanTextFileSerializers#states}, благодаря методу getSimpleName(), который возвращает
     * имя типа передаваемого класса
     * @param stringHuman строковое представление объекта для десериализации
     * @return десериализованный объект
     */
    public Human deserializeHuman(String stringHuman)
    {
        String[] humanFields = stringHuman.split("#");
        HumanTextFileSerializer humanTextFileSerializer = states.get(humanFields[0]);
        return humanTextFileSerializer.deserializeHuman(stringHuman);
    }
}

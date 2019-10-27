package dao.Serializers;

import bean.*;

import java.util.HashMap;
import java.util.Map;

public class FactoryHumanTextFileSerializers {

    static Map<String, HumanTextFileSerializer> states = new HashMap<>(){};

    static {
        states.put(HeadPhysician.class.getSimpleName(),new HeadPhysicianTextFileSerializer());
        states.put(Doctor.class.getSimpleName(),new DoctorTextFileSerializer());
        states.put(Nurse.class.getSimpleName(),new NurseTextFileSerializer());
        states.put(Intern.class.getSimpleName(),new InternTextFileSerializer());
        states.put(Patient.class.getSimpleName(),new PatientTextFileSerializer());
    }

    public String serializeHuman(Human human)
    {
        HumanTextFileSerializer humanTextFileSerializer = states.get(human.getClass().getSimpleName());
        return humanTextFileSerializer.serializeHuman(human);
    }

    public Human deserializeHuman(String stringHuman)
    {
        String[] humanFields = stringHuman.split("#");
        HumanTextFileSerializer humanTextFileSerializer = states.get(humanFields[0]);
        return humanTextFileSerializer.deserializeHuman(stringHuman);
    }
}

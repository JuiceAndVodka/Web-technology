package dao;

import bean.Human;
import bean.Identifier;
import dao.Serializers.FactoryHumanTextFileSerializers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TextFileHumanDAO implements  HumanDAO {

    private ArrayList<Human> humansCash = null;

    @Override
    public ArrayList<Human> getAll() {

        if (humansCash != null) {
            return  (ArrayList<Human>)humansCash.clone();
        }

        ArrayList<Human> humansList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {

            fileReader = new FileReader("D:\\Humans.txt");
            bufferedReader = new BufferedReader(fileReader);

            while (true) {

                String readedLine = bufferedReader.readLine();

                if (readedLine == null) {
                    break;
                }

                FactoryHumanTextFileSerializers factoryHumanTextFileSerializers = new FactoryHumanTextFileSerializers();
                humansList.add(factoryHumanTextFileSerializers.deserializeHuman(readedLine));
            }
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
        finally {

            try {

                fileReader.close();
                bufferedReader.close();
            }
            catch (Exception exception) {

                System.out.println("Error: " + exception.getMessage());
                exception.printStackTrace();
            }

        }

        humansCash = humansList;

        return (ArrayList<Human>)humansList.clone();
    }

    @Override
    public Human getById(int id) {

        Human foundedHuman = null;
        ArrayList<Human> humansList = getAll();

        for (Human human: humansList) {

            if (human.getId() == id) {
                foundedHuman = human;
            }
        }

        return  foundedHuman;
    }

    @Override
    public  boolean create(Human department) {

        ArrayList<Human> humansList = getAll();

        department.setId(Identifier.getUniqId((new ArrayList<>(humansList))));

        humansList.add(department);

        try {
            return saveHumansToTextFile(humansList);
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return  false;
        }
    }

    @Override
    public boolean update(int id, Human human) {

        ArrayList<Human> humansList = getAll();

        for(int i = 0; i < humansList.size(); i++)
        {
            if(humansList.get(i).getId() == id)
            {
                humansList.set(i, human);

                try {
                    return saveHumansToTextFile(humansList);
                }
                catch (Exception exception) {

                    System.out.println("Error: " + exception.getMessage());
                    exception.printStackTrace();

                    return false;
                }
            }
        };

        return false;
    }

    @Override
    public boolean deleteById(int id) {

        ArrayList<Human> humansList = getAll();

        for (int i = 0; i < humansList.size(); i++) {

            if(humansList.get(i).getId() == id) {

                humansList.remove(i);
                break;
            }
        }

        try {
            return saveHumansToTextFile(humansList);
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return  false;
        }
    }

    public boolean saveHumansToTextFile(ArrayList<Human> humansList) {

        try (FileWriter writer = new FileWriter("D:\\Humans.txt", false)) {

            for(Human human: humansList) {

                FactoryHumanTextFileSerializers factoryHumanTextFileSerializers = new FactoryHumanTextFileSerializers();
                writer.write(factoryHumanTextFileSerializers.serializeHuman(human));
                writer.append('\n');
            }

            writer.flush();

            return  true;
        }
        catch(Exception exception){

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return false;
        }
    }
}

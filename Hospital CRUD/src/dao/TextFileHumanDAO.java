package dao;

import bean.Human;
import bean.Identifier;
import constants.GlobalConstants;
import dao.Serializers.FactoryHumanTextFileSerializers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TextFileHumanDAO implements  HumanDAO {

    private ArrayList<Human> humansCash = null;

    public ArrayList<Human> getAll() {

        ArrayList<Human> humansList = getAllHumans();
        return (ArrayList<Human>)humansList.clone();
    }

    private ArrayList<Human> getAllHumans() {

        if (humansCash != null) {
            return  humansCash;
        }

        ArrayList<Human> humansList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {

            fileReader = new FileReader(GlobalConstants.SourceFilePath + "\\Humans.txt");
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

        return humansList;
    }

    public Human getById(int id) {

        Human foundedHuman = null;
        ArrayList<Human> humansList = getAllHumans();

        for (Human human: humansList) {

            if (human.getId() == id) {
                foundedHuman = human;
            }
        }

        return  foundedHuman;
    }

    public  boolean create(Human department) {

        ArrayList<Human> humansList = getAllHumans();

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

    public boolean update(int id, Human human) {

        ArrayList<Human> humansList = getAllHumans();

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

    public boolean deleteById(int id) {

        ArrayList<Human> humansList = getAllHumans();

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

        try (FileWriter writer = new FileWriter(GlobalConstants.SourceFilePath + "\\Humans.txt", false)) {

            for(Human human: humansList) {

                FactoryHumanTextFileSerializers factoryHumanTextFileSerializers = new FactoryHumanTextFileSerializers();
                writer.write(factoryHumanTextFileSerializers.serializeHuman(human));
                writer.append('\n');
            }

            writer.flush();

            humansCash = (ArrayList<Human>)humansList.clone();

            return  true;
        }
        catch(Exception exception){

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return false;
        }
    }
}

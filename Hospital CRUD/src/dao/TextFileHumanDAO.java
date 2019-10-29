package dao;

import bean.Human;
import bean.Identifier;
import constants.GlobalConstants;
import dao.Serializers.FactoryHumanTextFileSerializers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Класс файлового представления Базы Данных, реализующий интерфейс {@link HumanDAO}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class TextFileHumanDAO implements  HumanDAO {

    /** Список объектов типа {@link Human}, используемый в качестве кэша */
    private ArrayList<Human> humansCash = null;

    /**
     * Получение всех объектов типа {@link Human}, хранящихся в текстовом файле
     * @return список объектов типа {@link Human}
     */
    public ArrayList<Human> getAll() {

        ArrayList<Human> humansList = getAllHumans();
        return (ArrayList<Human>)humansList.clone();
    }

    /**
     * Непосредственная загрузка объекто типа {@link Human} из текстового файла
     * @return список загруженных объектов
     */
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

    /**
     * Получение объекта из списка объектов по его идентификационному номеру
     * @param id идентификационный номер нужного объекта
     * @return найденный объект типа {@link Human}
     */
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

    /**
     * Сохранение недавно созданного объекта типа {@link Human}
     * @param human передаваемый для хранения объект типа {@link Human}
     * @return значение (true/ false), указывающее на результат операции
     */
    public  boolean create(Human human) {

        ArrayList<Human> humansList = getAllHumans();

        human.setId(Identifier.getUniqId((new ArrayList<>(humansList))));

        humansList.add(human);

        try {
            return saveHumansToTextFile(humansList);
        }
        catch (Exception exception) {

            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();

            return  false;
        }
    }

    /**
     * Обновляет объект с подходящим идентификационным номера в текстовом файле
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param human новый объект типа {@link Human}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
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

    /**
     * Удаляет объект типа {@link Human} с подходящим идентификационным номером из файла
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
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

    /**
     * Сохраняет передаваемый список объектов типа {@link Human} в текстовый файл
     * @param humansList список объектов типа {@link Human} для сохранения
     * @return значение (true/ false), указывающее на результат операции
     */
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

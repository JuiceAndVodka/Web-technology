package bean;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс Identifier, который нужен как главный родитель для остальных классов и содержащий приватные поля,
 * их геттеры и сеттеры, а также переопределение метода
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public class Identifier {

    /** Поле идентификационного номера */
    private int Id;

    /**
     * Функция получения приватного поля {@link Identifier#Id}
     * @return поле {@link Identifier#Id}
     */
    public int getId()
    {
        return Id;
    }

    /**
     * Функция задания нового значения приватному полю {@link Identifier#Id}
     * @param id идентификационный номер
     */
    public void setId(int id)
    {
        Id = id;
    }

    /**
     * Определяет, имеется ли переданный id уникальным по отношению переданного списка idenrifierList
     * @param id идентификационный номер, который нужно проверить
     * @param identifierList список объектов типа {@link Identifier}
     * @return значение (true / false), указывающее на уникальность id
     */
    public static boolean isIdUniq(int id, ArrayList<Identifier> identifierList)
    {
        for(Identifier identifier: identifierList)
        {
            if (identifier.getId() == id) {
                return false;
            }
        }
        return true;
    }

    /**
     * Получает уникальный id относительно переданного списка
     * @param identifierList список, относительно которого идёт поиск id
     * @return уникальный id
     */
    public static int getUniqId(ArrayList<Identifier> identifierList)
    {
        Random random = new Random(100000000);
        boolean isIdUniq;
        int uniqId;

        do {
            isIdUniq = true;
            uniqId = random.nextInt();

            for (Identifier identifier : identifierList) {
                if (identifier.getId() == uniqId) {
                    isIdUniq = false;
                }
            }
        } while (!isIdUniq || (uniqId == 0));

        return uniqId;
    }
}

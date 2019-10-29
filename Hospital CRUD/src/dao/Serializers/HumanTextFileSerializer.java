package dao.Serializers;

import bean.Human;

/**
 * Интерфейс текстового сериализатора для класса {@link Human}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public interface HumanTextFileSerializer {

    /**
     * Сериализует передаваемый объект типа {@link Human}
     * @param human объект типа {@link Human} для сериализации
     * @return сериализованный объект в виде строкового представления
     */
    public String serializeHuman(Human human);

    /**
     * Десериализует передаваемый объект типа {@link Human}
     * @param stringHuman строковое представление объекта для десериализации
     * @return десериализованный объект
     */
    public Human deserializeHuman(String stringHuman);
}

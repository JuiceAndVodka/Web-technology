package dao;

import bean.Human;

import java.util.ArrayList;

/**
 * Интерфейс для общения с Базой Данных ради объекта типа {@link Human}
 * @author Абраменко Алексей, 751003
 * @version 1.0
 */
public interface HumanDAO {

    /**
     * Получает все объекты типа {@link Human} из Базы Данных
     * @return список объектов типа {@link Human}
     */
    ArrayList<Human> getAll();

    /**
     * Возвращает объект типа {@link Human} из Базы ДАнных
     * @param id идентификационный номер нужного объекта
     * @return найденный по идентификационному номеру объект
     */
    Human getById(int id);

    /**
     * Передаёт в Базу Данных новый объект типа {@link Human} для хранения
     * @param human передаваемый для хранения объект типа {@link Human}
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean create(Human human);

    /**
     * Обновляет существующий объект в Базе Данных
     * @param id идентификационный номер объекта, на который будет заменён передаваемый объект
     * @param human новый объект типа {@link Human}, который будет заменён на существующий объект
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean update(int id, Human human);

    /**
     * Удаляет существующий объект из Базы Данных
     * @param id идентификационный номер удаляемого объекта
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean deleteById(int id);

    /**
     * Сохраняет все объекты типа {@link Human} в текстовый файл
     * @param humansList список объектов типа {@link Human} для сохранения
     * @return значение (true/ false), указывающее на результат операции
     */
    boolean saveHumansToTextFile(ArrayList<Human> humansList);

}

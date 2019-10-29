import view.ConsoleView;

/**
 * Основной класс программы, содержащий стартовую функцию приложения {@link Main#main(String[])}
 * @author Абраменко Алексей, группа 751003
 * @version 1.0
 */
public class Main {

    /**
     * Начинает работу приложения
     * @param args аргументы, переданные в командной строке при запуске программы
     */
    public static void main(String[] args)
    {

        ConsoleView consoleView = new ConsoleView();

        consoleView.Start();
    }

}

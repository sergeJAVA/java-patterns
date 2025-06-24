package patterns.composite;

/**
 * Класс {@code PythonDeveloper} является еще одним "листом" в паттерне Composite.
 * Он реализует интерфейс {@code Developer} и представляет собой
 * индивидуального Python-разработчика.
 */
public class PythonDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Python developer writes code...");
    }

}

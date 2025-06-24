package patterns.composite;

/**
 * Класс {@code JavaDeveloper} также является "листом" в паттерне Composite.
 * Он реализует интерфейс {@code Developer} и представляет собой
 * индивидуального Java-разработчика.
 */
public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes code...");
    }
}

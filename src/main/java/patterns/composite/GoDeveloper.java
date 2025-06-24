package patterns.composite;

/**
 * Класс {@code GoDeveloper} представляет собой "лист" в паттерне Composite.
 * Он реализует интерфейс {@code Developer} и представляет собой
 * индивидуального Go-разработчика.
 */
public class GoDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Go developer writes code...");
    }
}

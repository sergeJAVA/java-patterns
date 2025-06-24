package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая стул.
 */
public class Chair implements Furniture {

    /**
     * Выводит сообщение о создании стула в консоль.
     */
    @Override
    public void create() {
        System.out.println("Стул был создан.");
    }

}

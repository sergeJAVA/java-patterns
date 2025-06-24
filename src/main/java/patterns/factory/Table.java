package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая стол.
 */
public class Table implements Furniture {

    /**
     * Выводит сообщение о создании стола в консоль.
     */
    @Override
    public void create() {
        System.out.println("Стол создан.");
    }

}

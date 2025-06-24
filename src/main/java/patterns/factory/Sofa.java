package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая диван.
 */
public class Sofa implements Furniture {

    /**
     * Выводит сообщение о создании дивана в консоль.
     */
    @Override
    public void create() {
        System.out.println("Диван был создан.");
    }

}

package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая стул.
 */
public class Chair implements Furniture {

    private String message;

    /**
     * Выводит сообщение о создании стула в консоль.
     */
    @Override
    public void create() {
        message = "Стул был создан.";
        System.out.println(this.message);
    }

    /**
     * Возвращает сообщение о создании стула.
     *
     * @return сообщение "Стул был создан.".
     */
    @Override
    public String getMessage() {
        return message;
    }

}

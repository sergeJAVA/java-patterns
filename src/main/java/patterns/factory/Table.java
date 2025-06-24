package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая стол.
 */
public class Table implements Furniture {

    private String message;
    /**
     * Выводит сообщение о создании стола в консоль.
     */
    @Override
    public void create() {
        message = "Стол создан.";
        System.out.println(this.message);
    }

    /**
     * Возвращает сообщение о создании стола.
     *
     * @return сообщение "Стол создан.".
     */
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

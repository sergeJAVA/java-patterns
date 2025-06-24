package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link Furniture}, представляющая диван.
 */
public class Sofa implements Furniture {

    private String message;
    /**
     * Выводит сообщение о создании дивана в консоль.
     */
    @Override
    public void create() {
        message = "Диван был создан.";
        System.out.println(this.message);
    }

    /**
     * Возвращает сообщение о создании дивана.
     *
     * @return сообщение "Диван был создан.".
     */
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

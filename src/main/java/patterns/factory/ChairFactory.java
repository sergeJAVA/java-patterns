package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link FurnitureFactory},
 * отвечающая за создание объектов {@link Chair}.
 */
public class ChairFactory implements FurnitureFactory {

    /**
     * Создает и возвращает новый экземпляр {@link Chair}.
     *
     * @return новый объект {@link Chair}.
     */
    @Override
    public Furniture createFurniture() {
        return new Chair();
    }

}

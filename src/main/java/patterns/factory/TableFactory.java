package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link FurnitureFactory},
 * отвечающая за создание объектов {@link Table}.
 */
public class TableFactory implements FurnitureFactory {

    /**
     * Создает и возвращает новый экземпляр {@link Table}.
     *
     * @return новый объект {@link Table}.
     */
    @Override
    public Furniture createFurniture() {
        return new Table();
    }

}

package patterns.factory;

/**
 * Конкретная реализация интерфейса {@link FurnitureFactory},
 * отвечающая за создание объектов {@link Sofa}.
 */
public class SofaFactory implements FurnitureFactory {

    /**
     * Создает и возвращает новый экземпляр {@link Sofa}.
     *
     * @return новый объект {@link Sofa}.
     */
    @Override
    public Furniture createFurniture() {
        return new Sofa();
    }

}

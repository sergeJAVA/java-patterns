package patterns.factory;

/**
 * Интерфейс фабрики, предназначенный для создания объектов {@link Furniture}.
 * Это центральная часть паттерна "Фабричный метод", позволяющая подклассам решать,
 * какой конкретный класс инстанцировать.
 */
public interface FurnitureFactory {

    /**
     * Создает и возвращает новый экземпляр {@link Furniture}.
     *
     * @return новый объект, реализующий интерфейс {@link Furniture}.
     */
    Furniture createFurniture();

}

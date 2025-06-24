package patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования паттерна FactoryMethod и его компонентов.
 */
public class FactoryTest {

    /**
     * Тестирует создание стула через ChairFactory и проверку сообщения.
     */
    @Test
    void testChairCreation() {
        FurnitureFactory chairFactory = Main.createFurnitureFactoryBySpeciality("chair");
        Furniture chair = chairFactory.createFurniture();
        assertNotNull(chair);
        assertTrue(chair instanceof Chair);
        chair.create();
        assertEquals("Стул был создан.", chair.getMessage());
    }

    /**
     * Тестирует создание дивана через SofaFactory и проверку сообщения.
     */
    @Test
    void testSofaCreation() {
        FurnitureFactory factory = new SofaFactory();
        Furniture sofa = factory.createFurniture();
        assertNotNull(sofa);
        assertTrue(sofa instanceof Sofa);
        sofa.create();
        assertEquals("Диван был создан.", sofa.getMessage());
    }

    /**
     * Тестирует создание стола через TableFactory и проверку сообщения.
     */
    @Test
    void testTableCreation() {
        FurnitureFactory factory = new TableFactory();
        Furniture table = factory.createFurniture();
        assertNotNull(table);
        assertTrue(table instanceof Table);
        table.create();
        assertEquals("Стол создан.", table.getMessage());
    }

    /**
     * Тестирует метод createFurnitureFactoryBySpeciality для стула.
     */
    @Test
    void testFactoryMethodForChair() {
        FurnitureFactory factory = Main.createFurnitureFactoryBySpeciality("chair");
        assertNotNull(factory);
        assertTrue(factory instanceof ChairFactory);
        Furniture furniture = factory.createFurniture();
        assertTrue(furniture instanceof Chair);
        furniture.create();
        assertEquals("Стул был создан.", furniture.getMessage());
    }

    /**
     * Тестирует метод createFurnitureFactoryBySpeciality для дивана.
     */
    @Test
    void testFactoryMethodForSofa() {
        FurnitureFactory factory = Main.createFurnitureFactoryBySpeciality("sofa");
        assertNotNull(factory);
        assertTrue(factory instanceof SofaFactory);
        Furniture furniture = factory.createFurniture();
        assertTrue(furniture instanceof Sofa);
        furniture.create();
        assertEquals("Диван был создан.", furniture.getMessage());
    }

    /**
     * Тестирует метод createFurnitureFactoryBySpeciality для стола.
     */
    @Test
    void testFactoryMethodForTable() {
        FurnitureFactory factory = Main.createFurnitureFactoryBySpeciality("table");
        assertNotNull(factory);
        assertTrue(factory instanceof TableFactory);
        Furniture furniture = factory.createFurniture();
        assertTrue(furniture instanceof Table);
        furniture.create();
        assertEquals("Стол создан.", furniture.getMessage());
    }

    /**
     * Тестирует выброс исключения для несуществующей мебели.
     */
    @Test
    void testFactoryMethodForInvalidSpeciality() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Main.createFurnitureFactoryBySpeciality("bookcase");
        });
        assertEquals("\"bookcase\" не существует", exception.getMessage());
    }
}
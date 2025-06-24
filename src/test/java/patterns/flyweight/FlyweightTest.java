package patterns.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Тестовый класс для демонстрации паттерна Flyweight и фабрики {@code CharacterFactory}.
 *
 * @author sergeJava
 */
public class FlyweightTest {

    /**
     * Выполняется перед каждым тестовым методом.
     * Очищает кеш CharacterFactory, чтобы каждый тест начинался с чистого состояния.
     *
     * @author sergeJava
     */
    @BeforeEach
    void setUp() {
        CharacterFactory.clearCache();
    }

    /**
     * Тестирует, что {@code CharacterFactory} возвращает один и тот же объект
     * {@code CharacterType} для одинаковых названий типов.
     *
     * @author sergeJava
     */
    @Test
    @DisplayName("Следует переиспользовать объекты CharacterType для идентичных имен типов.")
    void testFlyweightReuse() {
        CharacterType type1 = CharacterFactory.getCharacterType("Воин");
        CharacterType type2 = CharacterFactory.getCharacterType("Воин");

        // Проверяем, что это один и тот же объект (ссылочное равенство)
        assertSame(type1, type2, "CharacterFactory должен повторно использовать существующие объекты Flyweight");
        assertEquals(1, CharacterFactory.getCacheSize(), "Должен быть создан только один уникальный тип персонажа.");
    }

    /**
     * Тестирует, что {@code CharacterFactory} создает новые объекты
     * {@code CharacterType} для разных названий типов.
     *
     * @author sergeJava
     */
    @Test
    @DisplayName("Должен создать новые объекты CharacterType для разных имен типов.")
    void testNewFlyweightCreation() {
        CharacterType type1 = CharacterFactory.getCharacterType("Лучник");
        CharacterType type2 = CharacterFactory.getCharacterType("Маг");

        assertNotSame(type1, type2, "CharacterFactory should create new flyweight objects for different type names.");
        assertEquals(2, CharacterFactory.getCacheSize(), "Two unique character types should be created.");
    }

    /**
     * Тестирует поведение {@code CharacterFactory} при запросе различных комбинаций типов.
     *
     * @author sergeJava
     */
    @Test
    @DisplayName("Должен правильно управлять несколькими различными типами персонажей.")
    void testMultipleCharacterTypes() {
        CharacterFactory.getCharacterType("Лучник"); // 1
        CharacterFactory.getCharacterType("Воин");   // 2
        CharacterFactory.getCharacterType("Маг");    // 3
        CharacterFactory.getCharacterType("Лучник"); // Reused 1
        CharacterFactory.getCharacterType("Воин");   // Reused 2

        assertEquals(3, CharacterFactory.getCacheSize(), "Должен создать 3 уникальных типа персонажей.");
    }

    /**
     * Тестирует, что {@code GameCharacter} правильно ссылается на объект Flyweight.
     *
     * @author sergeJava
     */
    @Test
    @DisplayName("GameCharacter должен правильно ссылаться на свой Flyweight тип")
    void testGameCharacterUsesCorrectFlyweight() {
        CharacterType expectedType = CharacterFactory.getCharacterType("Воин");
        GameCharacter warrior = new GameCharacter("Герой", 100, 150, expectedType);

        assertNotNull(warrior.getType(), "GameCharacter тип не должен быть null.");
        // Проверяем, что объект типа, назначенный персонажу, совпадает с ожидаемым Flyweight
        assertSame(expectedType, warrior.getType(), "GameCharacter должен использовать точный объект Flyweight.");
        assertEquals("Воин", warrior.getType().getTypeName(), "Имя типа Character должно совпадать.");
    }
}

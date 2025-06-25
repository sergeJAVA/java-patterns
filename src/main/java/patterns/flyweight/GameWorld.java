package patterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code GameWorld} является клиентской частью, которая использует
 * паттерн Flyweight для эффективного создания и управления множеством игровых персонажей.
 *
 * @author sergeJava
 */
public class GameWorld {

    private static final Logger LOG = LoggerFactory.getLogger(GameWorld.class);
    private final List<GameCharacter> characters = new ArrayList<>();

    /**
     * Добавляет нового персонажа в игровой мир, используя фабрику для получения
     * легковесного объекта {@code CharacterType}.
     *
     * @param name     Имя персонажа.
     * @param typeName Тип персонажа (например, "Лучник").
     * @param x        Начальная координата X.
     * @param y        Начальная координата Y.
     * @author sergeJava
     */
    public void createCharacter(String name, String typeName, int x, int y) {
        CharacterType type = CharacterFactory.getCharacterType(typeName);
        if (type != null) {
            GameCharacter character = new GameCharacter(name, x, y, type);
            characters.add(character);
            LOG.info("Персонаж '{}' создан. Всего персонажей: {}", name, characters.size());
        } else {
            LOG.error("Не получилось создать персонажа '{}': Неизвестный тип '{}'.", name, typeName);
        }
    }

    /**
     * Отображает всех персонажей в игровом мире.
     * @author sergeJava
     */
    public void renderAllCharacters() {
        LOG.info("\n--- Рендеринг всех персонажей (всего: {}) ---", characters.size());
        for (GameCharacter character : characters) {
            character.render();
        }
        LOG.info("\nКоличество всех уникальных CharacterType объектов в кэше: {}", CharacterFactory.getCacheSize());
    }

    /**
     * Главный метод для демонстрации паттерна Flyweight в игровой симуляции.
     *
     * @param args Аргументы командной строки (не используются).
     * @author sergeJava
     */
    public static void main(String[] args) {
        GameWorld world = new GameWorld();

        // Создаем много персонажей, но с ограниченным количеством уникальных типов
        world.createCharacter("Арес", "Воин", 10, 20);
        world.createCharacter("Зевс", "Воин", 30, 40); // Воин будет переиспользован
        world.createCharacter("Артемида", "Лучник", 50, 60);
        world.createCharacter("Аполлон", "Лучник", 70, 80); // Лучник будет переиспользован
        world.createCharacter("Мерлин", "Маг", 90, 100);
        world.createCharacter("Гэндальф", "Маг", 110, 120); // Маг будет переиспользован
        world.createCharacter("Леголас", "Лучник", 130, 140); // Лучник будет переиспользован

        world.renderAllCharacters();

        // Ожидаемый результат:
        // Несмотря на то, что мы создали 7 игровых персонажей,
        // количество уникальных объектов CharacterType будет гораздо меньше
        // (в данном случае: Воин, Лучник, Маг - всего 3)
    }

}

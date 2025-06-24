package patterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс {@code GameCharacter} представляет собой **контекстный (клиентский) объект**.
 * Он содержит свойства персонажа, такие как его имя и текущие координаты, и ссылается на легковесный объект
 * {@code CharacterType}.
 * @author sergeJava
 */
public class GameCharacter {

    private static final Logger LOG = LoggerFactory.getLogger(GameCharacter.class);

    private final String name; // Уникальное имя персонажа (экстраинсивное)
    private int x;             // Координата X (экстраинсивное)
    private int y;             // Координата Y (экстраинсивное)
    private final CharacterType type; // Ссылка на легковесный объект (интринсивное)

    /**
     * Конструктор для {@code GameCharacter}.
     *
     * @param name Имя персонажа.
     * @param x    Начальная координата X.
     * @param y    Начальная координата Y.
     * @param type Объект {@code CharacterType}, представляющий общие свойства типа персонажа.
     * @author sergeJava
     */
    public GameCharacter(String name, int x, int y, CharacterType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
        LOG.debug("Создан GameCharacter '{}' типа '{}' на ({},{})", name, type.getTypeName(), x, y);
    }

    /**
     * Отображает персонажа, используя его интринсивные свойства (через Flyweight)
     * и экстраинсивные свойства (имя, позиция).
     * @author sergeJava
     */
    public void render() {
        LOG.info("Рендеринг {} ({}): на ({},{})", name, type.getTypeName(), x, y);
        type.displayTypeInfo(); // Используем интринсивные свойства
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CharacterType getType() {
        return type;
    }

}

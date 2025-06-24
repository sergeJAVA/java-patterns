package patterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Класс {@code CharacterType} представляет собой **легковесный (Flyweight) объект**.
 * Он содержит **интринсивные (неизменяемые и разделяемые)** свойства типа персонажа,
 * такие как название типа, путь к файлу анимации и путь к файлу иконки.
 *
 * @author sergeJava
 */
public class CharacterType {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterType.class);

    private final String typeName; // Например, "Лучник", "Воин", "Маг"
    private final String animationPath;
    private final String iconPath;

    /**
     * Конструктор для {@code CharacterType}.
     * Создает новый объект типа персонажа.
     *
     * @param typeName      Название типа персонажа.
     * @param animationPath Путь к файлу анимации для этого типа.
     * @param iconPath      Путь к файлу иконки для этого типа.
     * @author sergeJava
     */
    public CharacterType(String typeName, String animationPath, String iconPath) {
        this.typeName = typeName;
        this.animationPath = animationPath;
        this.iconPath = iconPath;
        LOG.debug("Создан новый CharacterType: TypeName={}, AnimationPath={}, IconPath={}", typeName, animationPath, iconPath);
    }

    public String getTypeName() {
        return typeName;
    }

    public String getAnimationPath() {
        return animationPath;
    }

    public String getIconPath() {
        return iconPath;
    }

    /**
     * Отображает информацию о типе персонажа (чтобы имитировать использование этих данных).
     * @author sergeJava
     */
    public void displayTypeInfo() {
        LOG.debug("Type: {}, Animation: {}, Icon: {}", typeName, animationPath, iconPath);
    }

    /**
     * Переопределение метода {@code equals} для сравнения объектов {@code CharacterType}.
     * Важно для работы фабрики Flyweight.
     * @param o Объект для сравнения.
     * @return {@code true}, если объекты равны; {@code false} в противном случае.
     * @author sergeJava
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterType that = (CharacterType) o;
        return Objects.equals(typeName, that.typeName) &&
                Objects.equals(animationPath, that.animationPath) &&
                Objects.equals(iconPath, that.iconPath);
    }

    /**
     * Переопределение метода {@code hashCode} для правильной работы с коллекциями,
     * использующими хеширование (например, {@code HashMap} на фабрике).
     * @return Хеш-код объекта.
     * @author sergeJava
     */
    @Override
    public int hashCode() {
        return Objects.hash(typeName, animationPath, iconPath);
    }

}

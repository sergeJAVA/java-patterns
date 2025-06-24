package patterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code CharacterFactory} является **фабрикой легковесных объектов (Flyweight Factory)**.
 * Он управляет созданием и повторным использованием объектов {@code CharacterType}.
 * Если запрошенный тип персонажа уже существует, он возвращает существующий объект;
 * в противном случае, создает новый.
 *
 * @author sergeJava
 */
public final class CharacterFactory {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterFactory.class);
    private static final Map<String, CharacterType> CACHE = new HashMap<>();

    private CharacterFactory() {
        // Приватный конструктор для предотвращения создания экземпляров (утилитарный класс)
    }

    /**
     * Возвращает или создает объект {@code CharacterType} на основе названия типа.
     * Этот метод гарантирует, что для одинаковых названий типов будет возвращен
     * один и тот же легковесный объект.
     *
     * @param typeName Название типа персонажа (например, "Лучник", "Воин", "Маг").
     * @return Объект {@code CharacterType} (либо существующий, либо новый).
     * @author sergeJava
     */
    public static CharacterType getCharacterType(String typeName) {
        CharacterType type = CACHE.get(typeName);

        if (type == null) {
            String animationPath;
            String iconPath;

            // Якобы видимость загрузки ресурсов для персонажа
            switch (typeName.toLowerCase()) {
                case "лучник" -> {
                    animationPath = "animations/archer.anim";
                    iconPath = "icons/archer.png";
                }

                case "воин" -> {
                    animationPath = "animations/warrior.anim";
                    iconPath = "icons/warrior.png";
                }
                case "маг" -> {
                    animationPath = "animations/mage.anim";
                    iconPath = "icons/mage.png";
                }

                default -> {
                    LOG.warn("Запрошен неизвестный тип персонажа: {}", typeName);
                    return null;
                }
            }

            type = new CharacterType(typeName, animationPath, iconPath);
            CACHE.put(typeName, type);
            LOG.info("Создан и закеширован новый CharacterType: {}", typeName);
        } else {
            LOG.debug("Переиспользование существующего CharacterType: {}", typeName);
        }
        return type;
    }

    /**
     * Возвращает количество уникальных (кешированных) типов персонажей.
     * Используется для проверки эффективности паттерна Flyweight.
     *
     * @return Количество уникальных объектов {@code CharacterType} в фабрике.
     * @author sergeJava
     */
    public static int getCacheSize() {
        return CACHE.size();
    }

    /**
     * Очищает кеш фабрики. Используется в основном для тестов.
     * @author sergeJava
     */
    public static void clearCache() {
        CACHE.clear();
        LOG.info("CharacterFactory кеш очищен.");
    }

}

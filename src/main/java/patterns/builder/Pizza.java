package patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Представляет собой неизменяемый объект пиццы,
 *  который может быть создан с использованием паттерна Builder.</p>
 *
 *  <p>Этот класс инкапсулирует характеристики пиццы, такие как размер,
 *  тип корочки, соус, начинки и наличие дополнительного сыра.
 *  Объекты {@code Pizza} создаются с помощью своего внутреннего статического
 *  класса {@link Pizza.Builder}, что позволяет гибко конфигурировать
 *  пиццу с различными комбинациями ингредиентов.</p>
 */
public final class Pizza {

    private String size;
    private String crust;
    private String sauce;
    private List<String> toppings;
    private boolean extraCheese;

    /**
     * <p>Приватный конструктор класса {@code Pizza}.</p>
     * <p>Этот конструктор вызывается исключительно из метода {@link Builder#build()}
     * и не предназначен для прямого использования клиентами. Он инициализирует
     * поля {@code Pizza} на основе значений, установленных в {@code Builder}.</p>
     *
     * @param builder Объект {@link Builder}, содержащий сконфигурированные параметры пиццы.
     */
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.toppings = new ArrayList<>(builder.toppings); // Создаем новую коллекцию
        this.extraCheese = builder.extraCheese;
    }

    /**
     * Возвращает размер пиццы.
     *
     * @return Строковое представление размера пиццы (например, "Small", "Medium", "Large").
     */
    public String getSize() {
        return size;
    }

    /**
     * Возвращает тип корочки пиццы.
     *
     * @return Строковое представление типа корочки (например, "Тонкая Корочка", "Толстая Корочка", "Gluten-Free Корочка").
     */
    public String getCrust() {
        return crust;
    }

    /**
     * Возвращает тип соуса, используемого в пицце.
     *
     * @return Строковое представление соуса (например, "Томатный Соус", "Песто Соус").
     */
    public String getSauce() {
        return sauce;
    }

    /**
     * Возвращает список начинок, добавленных в пиццу.
     *
     * @return {@link List} строк, представляющих начинки (например, "Грибы", "Лук", "Пепперони").
     * Возвращаемый список является копией, чтобы предотвратить внешние изменения.
     */
    public List<String> getToppings() {
        return toppings;
    }

    /**
     * Проверяет, добавлено ли в пиццу дополнительное количество сыра.
     *
     * @return {@code true}, если добавлен дополнительный сыр; {@code false} в противном случае.
     */
    public boolean isExtraCheese() {
        return extraCheese;
    }

    /**
     * Возвращает строковое представление объекта {@code Pizza},
     * включающее все его характеристики.
     *
     * @return Отформатированная строка с содержимым пиццы.
     */
    @Override
    public String toString() {
        return "Pizza:\n" +
                "  Size: " + size + "\n" +
                "  Crust: " + crust + "\n" +
                "  Sauce: " + sauce + "\n" +
                "  Toppings: " + (toppings.isEmpty() ? "None" : String.join(", ", toppings)) + "\n" +
                "  Extra Cheese: " + (extraCheese ? "Yes" : "No") + "\n";
    }

    /**
     * <p>Внутренний статический класс {@code Builder} для конструирования объектов {@code Pizza}.</p>
     *
     * <p>Этот класс предоставляет методы для установки различных характеристик пиццы
     * и в конечном итоге собирает и возвращает полноценный объект {@code Pizza}.</p>
     */
    public static class Builder {

        private String size;
        private String crust;
        private String sauce;
        private List<String> toppings = new ArrayList<>();
        private boolean extraCheese = false;

        /**
         * <p>Конструктор для {@code Builder}, инициализирующий обязательные параметры пиццы.</p>
         * <p>При создании {@code Builder} необходимо указать размер пиццы и тип корочки.</p>
         *
         * @param size Строковое представление размера пиццы (например, "Средняя", "Большая").
         * @param crust Строковое представление типа корочки (например, "Тонкая Корочка", "Толстая Корочка").
         */
        public Builder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }

        /**
         * Устанавливает тип соуса для пиццы.
         *
         * @param sauce Строковое представление соуса (например, "Томатный Соус").
         * @return Текущий экземпляр {@code Builder} для цепочки вызовов.
         */
        public Builder addSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        /**
         * Добавляет одну начинку к пицце. Этот метод можно вызывать несколько раз
         * для добавления нескольких начинок.
         *
         * @param topping Строковое представление начинки (например, "Грибы").
         * @return Текущий экземпляр {@code Builder} для цепочки вызовов.
         */
        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        /**
         * Устанавливает флаг наличия дополнительного сыра.
         *
         * @param extraCheese {@code true}, если нужен дополнительный сыр; {@code false} в противном случае.
         * @return Текущий экземпляр {@code Builder} для цепочки вызовов.
         */
        public Builder withExtraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        /**
         * <p>Собирает и возвращает полностью сконфигурированный объект {@code Pizza}.</p>
         * <p>Перед созданием объекта выполняет базовую валидацию обязательных полей.</p>
         *
         * @return Новый объект {@code Pizza} с установленными характеристиками.
         * @throws IllegalStateException Если обязательные параметры (размер или корочка) не были установлены.
         */
        public Pizza build() {
            // Здесь можно добавить проверки валидации, если нужно
            if (this.size == null || this.size.isEmpty()) {
                throw new IllegalStateException("Нужно выбрать размер пиццы!");
            }
            if (this.crust == null || this.crust.isEmpty()) {
                throw new IllegalStateException("Нужно выбрать толщину корочку!");
            }
            return new Pizza(this);
        }
    }

}

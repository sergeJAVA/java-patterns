package patterns.factory;

/**
 * Главный класс приложения, демонстрирующий использование паттерна "Фабричный метод".
 * Здесь определяется, какая конкретная фабрика будет использоваться в зависимости от входных данных,
 * а затем создается и используется соответствующая мебель.
 */
public final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        // Создаем фабрику для стола
        FurnitureFactory tableFactory = createFurnitureFactoryBySpeciality("table");
        // Используем фабрику для создания стола и вызываем метод create()
        tableFactory.createFurniture().create();

        // Пример использования для других типов мебели:
         FurnitureFactory chairFactory = createFurnitureFactoryBySpeciality("chair");
         chairFactory.createFurniture().create(); // Выведет "Стул был создан."

         FurnitureFactory sofaFactory = createFurnitureFactoryBySpeciality("sofa");
         sofaFactory.createFurniture().create(); // Выведет "Диван был создан."

        // Пример вызова с несуществующей специальностью
         try {
             createFurnitureFactoryBySpeciality("closet");
         } catch (RuntimeException e) {
             System.err.println(e.getMessage()); // Выведет "closet" не существует
         }
    }

    /**
     * Статический метод, который создает и возвращает конкретную {@link FurnitureFactory}
     * на основе предоставленной строки специальности.
     * Этот метод действует как "простая фабрика" (Simple Factory)
     * для создания фабрик в контексте паттерна "Фабричный метод".
     *
     * @param speciality строка, указывающая тип мебели (например, "chair", "sofa", "table").
     * @return конкретный экземпляр {@link FurnitureFactory}, соответствующий указанной специальности.
     * @throws RuntimeException если указанная специальность не поддерживается.
     */
    static FurnitureFactory createFurnitureFactoryBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("chair")) {
            return new ChairFactory();
        } else if (speciality.equalsIgnoreCase("sofa")) {
            return new SofaFactory();
        } else if (speciality.equalsIgnoreCase("table")) {
            return new TableFactory();
        }
        throw new RuntimeException("\"" + speciality + "\" не существует");
    }

}

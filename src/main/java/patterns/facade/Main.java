package patterns.facade;

public final class Main {

    private Main() {

    }

    /**
     * Основной метод для демонстрации использования SmartHomeFacade.
     * Создает экземпляр фасада и вызывает его упрощенные методы.
     * @author sergeJava
     */
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();

        // Клиент взаимодействует только с фасадом, не зная о сложности подсистем
        smartHome.cozyEvening(20);

        System.out.println("\n--- Время идет... ---");

        smartHome.goodNight();
    }

}

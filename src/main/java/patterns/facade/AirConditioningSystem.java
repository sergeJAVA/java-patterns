package patterns.facade;

public class AirConditioningSystem {

    /**
     * Включает кондиционер и устанавливает температуру.
     * @param temperature желаемая температура.
     */
    public void turnOnAC(int temperature) {
        System.out.println("Кондиционер включён, температура установлена на " + temperature + " градусов.");
    }

    /**
     * Выключает кондиционер.
     */
    public void turnOffAC() {
        System.out.println("Кондиционер выключен.");
    }

}

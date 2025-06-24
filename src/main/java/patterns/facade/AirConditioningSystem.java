package patterns.facade;

/**
 * Интерфейс {@code AirConditioningSystem} представляет подсистему управления кондиционированием.
 * Это еще один компонент, которым будет управлять фасад.
 * @author sergeJAVA
 */
public class AirConditioningSystem {

    /**
     * Включает кондиционер и устанавливает температуру.
     * @param temperature желаемая температура.
     * @author sergeJava
     */
    public void turnOnAC(int temperature) {
        System.out.println("Кондиционер включён, температура установлена на " + temperature + " градусов.");
    }

    /**
     * Выключает кондиционер.
     * @author sergeJava
     */
    public void turnOffAC() {
        System.out.println("Кондиционер выключен.");
    }

}

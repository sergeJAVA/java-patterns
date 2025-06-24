package patterns.facade;

/**
 * Интерфейс {@code LightSystem} представляет собой подсистему управления освещением.
 * Это один из компонентов, которым будет управлять фасад.
 * @author sergeJAVA
 */
public class LightSystem {

    /**
     * Включает свет.
     * @author sergeJava
     */
    public void turnOnLights() {
        System.out.println("Свет включён.");
    }

    /**
     * Выключает свет.
     * @author sergeJava
     */
    public void turnOffLights() {
        System.out.println("Свет выключен.");
    }

}

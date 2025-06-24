package patterns.facade;

/**
 * Интерфейс {@code MusicSystem} представляет подсистему управления музыкой.
 * Это третий компонент, которым будет управлять фасад.
 * @author sergeJAVA
 */
public class MusicSystem {

    /**
     * Включает музыку.
     * @author sergeJava
     */
    public void playMusic() {
        System.out.println("Музыка играет...");
    }

    /**
     * Выключает музыку.
     * @author sergeJava
     */
    public void stopMusic() {
        System.out.println("Музыка остановилась...");
    }

}

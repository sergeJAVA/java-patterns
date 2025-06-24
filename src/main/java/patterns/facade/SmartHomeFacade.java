package patterns.facade;

/**
 * Класс {@code SmartHomeFacade} является фасадом, который предоставляет
 * упрощенный интерфейс для взаимодействия со сложными подсистемами
 * (освещение, кондиционирование, музыка).
 * Он скрывает внутреннюю сложность и предоставляет высокоуровневые методы
 * для выполнения общих операций.
 * @author sergeJAVA
 */
public class SmartHomeFacade {

    private LightSystem lightSystem;
    private AirConditioningSystem acSystem;
    private MusicSystem musicSystem;

    /**
     * Конструктор для {@code SmartHomeFacade}.
     * Инициализирует все подсистемы, с которыми будет работать фасад.
     * @author sergeJava
     */
    public SmartHomeFacade() {
        this.lightSystem = new LightSystem();
        this.acSystem = new AirConditioningSystem();
        this.musicSystem = new MusicSystem();
    }

    /**
     * Упрощенный метод для настройки дома для вечернего отдыха.
     * Этот метод взаимодействует со всеми необходимыми подсистемами,
     * скрывая их сложность от клиента.
     * @param temperature желаемая температура для кондиционера.
     * @author sergeJava
     */
    public void cozyEvening(int temperature) {
        System.out.println("\nНастраиваемся на уютный вечер...");
        lightSystem.turnOnLights();
        acSystem.turnOnAC(temperature);
        musicSystem.playMusic();
        System.out.println("Уютная вечерняя обстановка готова!");
    }

    /**
     * Упрощенный метод для выключения всех систем в доме.
     * Этот метод взаимодействует со всеми необходимыми подсистемами,
     * скрывая их сложность от клиента.
     * @author sergeJava
     */
    public void goodNight() {
        System.out.println("\nОтключаемся на ночь...");
        lightSystem.turnOffLights();
        acSystem.turnOffAC();
        musicSystem.stopMusic();
        System.out.println("Все системы отключены. Спокойной ночи!");
    }

}

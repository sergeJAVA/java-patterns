package patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code Team} представляет "композит" в паттерне Composite.
 * Он содержит коллекцию объектов {@code Developer} (как листьев, так и других композитов),
 * что позволяет обрабатывать как отдельных разработчиков, так и их группы
 * единообразно.
 */
public class Team {

    private List<Developer> developers = new ArrayList<>();

    /**
     * Добавляет нового разработчика в текущую команду.
     * @param developer объект {@code Developer}, который будет добавлен.
     */
    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    /**
     * Удаляет разработчика из текущей команды.
     * @param developer объект {@code Developer}, который будет удален.
     */
    public void removeDeveloper(Developer developer) {
        developers.removeIf(d -> d.equals(developer));
    }

    /**
     * Метод {@code createProject()} демонстрирует основную идею паттерна Composite:
     * клиент может взаимодействовать с объектами-композитами и объектами-листьями
     * единообразно. Вызов этого метода на объекте {@code Team} приведет к тому,
     * что каждый разработчик в команде выполнит свою операцию {@code writeCode()}.
     */
    public void createProject() {
        System.out.println("Team creates project...");
        for (Developer developer : developers) {
            developer.writeCode();
        }
    }

}

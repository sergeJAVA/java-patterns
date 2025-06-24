package patterns.singleton;

/**
 * Класс Person представляет собой человека с именем и возрастом.
 */
public final class Person {

    private static final Person INSTANCE = new Person("Sergey", 20);
    private String name;
    private int age;

    /**
     * Конструктор класса Person (приватный, потому что класс является синглтоном).
     * @param name Имя человека.
     * @param age Возраст человека.
     */
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * Возвращает экземпляр класса Person.
     * @return Экземпляр класса Person.
     */
    public static Person getInstance() {
        return INSTANCE;
    }

    /**
     * Возращает имя человека
     * @return Имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     * @param name Имя человека.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает возраст человека.
     * @return Возраст человека.
     */
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст человека.
     * @param age Возраст человека.
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Метод say выводить выводит в консоль сообщение, которое вы передаёте параметром message.
     * @param message сообщение для вывода в консоль.
     */
    public void say(String message) {
        System.out.println(message);
    }

}

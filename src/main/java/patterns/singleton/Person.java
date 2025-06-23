package patterns.singleton;

public final class Person {

    private static final Person INSTANCE;
    private String name;
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        INSTANCE = new Person("Sergey", 20);
    }

    public static Person getInstance() {
        return INSTANCE;
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
     * @param message - сообщение для вывода в консоль.
     */
    public void say(String message) {
        System.out.println(message);
    }

}

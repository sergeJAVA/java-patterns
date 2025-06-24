import patterns.singleton.Person;

public final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        Person.getInstance().say("Calling the “say()” method from the Person singleton class");
    }

}

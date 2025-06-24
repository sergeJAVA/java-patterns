import patterns.builder.Pizza;
import patterns.singleton.Person;

public final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        Person.getInstance().say("Calling the “say()” method from the Person singleton class");

        Pizza veggieDelight = new Pizza.Builder("Маленькая", "Gluten-Free Корочка")
                .withSauce("Песто соус")
                .addTopping("Грибы")
                .addTopping("Лук")
                .addTopping("Болгарский перец")
                .withExtraCheese(false)
                .build();
        System.out.println("\n" + veggieDelight);
    }

}

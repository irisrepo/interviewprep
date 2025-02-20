package src.main.com.sss.java.javaprograms.designpatterns.Builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .setCrust("Thin Crust")
                .setCheese("Mozzarella")
                .setSize("Large")
                .setToppings("Pepperoni, Olives")
                .build();

        System.out.println(pizza);
    }
}


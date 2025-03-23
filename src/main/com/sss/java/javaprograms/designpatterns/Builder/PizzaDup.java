package src.main.com.sss.java.javaprograms.designpatterns.Builder;

public class PizzaDup {

    private String crust;
    private String cheese;
    private String size;
    private String toppings;

    private PizzaDup(PizzaBuilder pizzaBuilder) {
        this.crust = pizzaBuilder.crust;
        this.cheese = pizzaBuilder.cheese;
        this.size = pizzaBuilder.size;
        this.toppings = pizzaBuilder.toppings;
    }

    public static class PizzaBuilder{
       private String crust;
       private String cheese;
       private String size;
       private String toppings;


       public PizzaBuilder setCrust(String crust) {
           this.crust = crust;
           return this;
       }
       public PizzaBuilder setCheese(String cheese) {
           this.cheese = cheese;
           return this;
       }

       public PizzaBuilder setSize(String size) {
           this.size = size;
           return this;
       }
       public PizzaBuilder setToppings(String toppings) {
           this.toppings = toppings;
           return this;
       }
   }

}



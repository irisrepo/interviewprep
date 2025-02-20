package src.main.com.sss.java.javaprograms.designpatterns.Builder;

public class Pizza {
    private String crust;
    private String cheese;
    private String size;
    private String toppings;

    // Constructor is private to enforce using the builder
    private Pizza(PizzaBuilder builder) {
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    public String toString() {
        return "Pizza [Crust=" + crust + ", Cheese=" + cheese + ", Size=" + size + ", Toppings=" + toppings + "]";
    }

    // Static Builder class
    public static class PizzaBuilder {
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

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

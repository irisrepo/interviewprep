package src.main.com.sss.java.javaprograms.designpatterns.Factory;

public class Main {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.createAnimal("dog");
        animal.speak();
    }
}

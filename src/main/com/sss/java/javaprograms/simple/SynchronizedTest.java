package src.main.com.sss.java.javaprograms.simple;

public class SynchronizedTest {
    public static void main(String[] args) {
        Singlteton instance = Singlteton.INSTANCE;
      System.out.print(instance);
    }

    enum Singlteton{
        INSTANCE;
    }
}

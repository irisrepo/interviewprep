package src.main.com.sss.java.javaprograms.simple;

public class FibannociTest {
    public static void main(String[] args) {
        int n = 10;
        int f1 = 0, f2 = 1, f3;
        for (int i = 1; i <= n; i++) {
            f3 = f1 + f2;
            f2 = f1;
            f1 = f3;
            System.out.print(" " + f3);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

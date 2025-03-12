package src.main.com.sss.java.javaprograms.thread;

public class ThreadTest {
    public static void main(String[] args) {
     for(int i=0 ;i<5; i++){
        Thread t = new Thread(new Task());
         t.start();
     }

    }

}

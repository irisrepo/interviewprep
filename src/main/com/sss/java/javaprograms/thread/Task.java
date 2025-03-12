package src.main.com.sss.java.javaprograms.thread;

public class Task implements  Runnable{
    public  void run(){
        System.out.println("Current Thread"+Thread.currentThread().getName());
    }
}

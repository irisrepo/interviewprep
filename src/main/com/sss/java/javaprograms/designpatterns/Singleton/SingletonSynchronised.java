package src.main.com.sss.java.javaprograms.designpatterns.Singleton;

public class SingletonSynchronised {
    public static SingletonSynchronised instance;

    private SingletonSynchronised(){

    }
    public static  synchronized SingletonSynchronised getInstance(){ //here lock
        if(instance == null){
            synchronized (SingletonSynchronised.class){
                if(instance == null){
                    instance = new SingletonSynchronised();
                }
            }

        }
        return instance;
    }
}

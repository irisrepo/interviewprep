package src.main.com.sss.java.javaprograms.designpatterns.Singleton;

class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    //Lazy initialisation
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static  void print() {
        System.out.println("Singleton class print method");
    }

}

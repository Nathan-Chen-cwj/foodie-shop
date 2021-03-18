/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/7 17:12
 */
public class Singleton {
    public static Singleton instance = null;

    private Singleton() {
    }

    public synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

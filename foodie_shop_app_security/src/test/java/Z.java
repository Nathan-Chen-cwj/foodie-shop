import java.util.Map;
import java.util.TreeMap;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/7 15:36
 */
public class Z extends X{
        Y y=new Y();
        public Z(){
            System.out.print("Z");
        }
        public static void main(String[] args) {
            new Z();
            Animal a = new Animal();
            Animal b = new Dog();
            a.move();
            b.move();
            Thread thread = new Thread();
            thread.run();
            Map<Integer, String> map = new TreeMap<>();
            map.put(0,"value");
        }


}
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
}
class Dog extends Animal{
    public void move(){
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}

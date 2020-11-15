/**
 *  1. Spider继承Animal类。
    2. 定义默认构造器，它调用父类构造器来指明所有蜘蛛都是8条腿。
    3. 实现eat方法
*/
public class Spider extends Animal {
    public Spider(){
        super(8);
    }
    public void eat(){
        System.out.println("The spider eat bugs with its net");
    }
}

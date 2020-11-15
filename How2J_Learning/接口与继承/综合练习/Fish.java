/**
 *  1. 创建Fish类，它继承Animal类
    2. 重写Animal的walk方法以表明鱼不能走且没有腿。
    3. 实现Pet接口
    4. 无参构造方法
    5. 提供一个private 的name属性
*/
public class Fish extends Animal implements Pet{
    private String name;
    public Fish(){
        super();
    }
    public  void walk(){
        System.out.println("Fish can not walk and dones't have leg");
    }
    public void eat(){
        System.out.println("The fish :["+name+"] now is eating");
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void play(){
        System.out.println("The fish :["+name+"] now is playing");
    }
}

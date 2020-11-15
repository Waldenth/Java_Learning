/**
 * 1. 创建Animal类，它是所有动物的抽象父类。
   2. 声明一个受保护的整数类型属性legs，它记录动物的腿的数目。
   3. 定义一个受保护的构造器，用来初始化legs属性。
   4. 声明抽象方法eat。
   5. 声明具体方法walk来打印动物是如何行走的（包括腿的数目）。
*/
public abstract class Animal{
    protected int legs;
    protected Animal(int ...legs){
        if(legs.length==0)
            System.out.println("Create an animal without leg");
        else{
            this.legs=legs[0];
            System.out.println("Create an animal with "+legs[0]+" leg");
        }
    }
    public abstract void eat();
    public void walk(){
        System.out.println("This animal is walking with its "+legs+" leg");
    }
}
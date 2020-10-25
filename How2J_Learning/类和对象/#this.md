### this

this这个关键字，相当于普通话里的“**我**”

#### 何为this

**this即代表当前对象**

```java
public class Hero {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度
    //打印内存中的虚拟地址
    public void showAddressInMemory(){
        System.out.println("打印this看到的虚拟地址："+this);
    } 
    public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "盖伦";
        //直接打印对象，会显示该对象在内存中的虚拟地址
        //格式：Hero@c17164 c17164即虚拟地址，每次执行，得到的地址不一定一样
        System.out.println("打印对象看到的虚拟地址："+garen);
        //调用showAddressInMemory，打印该对象的this，显示相同的虚拟地址Hero@c17164
        garen.showAddressInMemory();
         
        Hero teemo =  new Hero();
        teemo.name = "提莫";
        System.out.println("打印对象看到的虚拟地址："+teemo);
        teemo.showAddressInMemory();
    }  
     
}
```

**this.variablename**可以访问对象的属性

```java
public class Hero {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度
    //参数名和属性名一样
    //在方法体中，只能访问到参数name
    public void setName1(String name){
        name = name;//由于参数名和属性名一样，访问不到Hero.name
    }     
    //为了避免setName1中的问题，参数名不得不使用其他变量名
    public void setName2(String heroName){
        name = heroName;
    }
    //也通过this访问属性
    public void setName3(String name){
        //name代表的是参数name
        //this.name代表的是属性name
        this.name = name;
    }   
    public static void main(String[] args) {
        Hero  h =new Hero();
         
        h.setName1("teemo");
        System.out.println(h.name);//打印null，没有赋值成功
         
        h.setName2("garen");
        System.out.println(h.name);    
         
        h.setName3("死歌");
        System.out.println(h.name);    
    }
}
```

#### 通过this调用其他的构造方法

如果要在一个构造方法中，调用另一个构造方法，可以使用this()

```java
public class Hero {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度  
    //带一个参数的构造方法
    public Hero(String name){
        System.out.println("一个参数的构造方法");
        this.name = name;
    }     
    //带两个参数的构造方法
    public Hero(String name,float hp){
        this(name);//这里在两个参数的构造方法中调用了带一个参数的构造方法
        System.out.println("两个参数的构造方法");
        this.hp = hp;
    }
    public static void main(String[] args) {
        Hero teemo =  new Hero("提莫",383);
        System.out.println(teemo.name);    
    }  
}
```

**特别注意！！**

**对于this语句，在一个构造方法中，调用另一个构造方法。这个构造方法必须是构造函数中的第一个语句**
## final

final修饰类，方法，基本类型变量，引用的时候分别有不同的意思。

### final修饰类

当Hero被修饰成final的时候，表示Hero不能够被继承
其子类会出现编译错误，即不可以`public class ADHero extends Hero`

```java
public final class Hero extends Object {
    String name; //姓名
    float hp; //血量       
}
```

### final 修饰方法

`Hero`的`useItem`方法被修饰成`final`,那么该方法在`ADHero`中，不能够被重写

```java
public class Hero extends Object {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度
    public final void useItem(Item i){
        System.out.println("hero use item");
        i.effect();
    }   
    public Hero(){
        System.out.println("Hero的无参的构造方法 ");
    }
    public Hero(String name){
        System.out.println("Hero的有一个参数的构造方法 ");
        this.name = name;
    }
    public static void main(String[] args) {
        new Hero();
    }     
}
```

### final 修饰基本类型变量

final修饰基本类型变量，表示该变量只有一次赋值机会
赋值后就不能再赋值了

### final修饰引用

`final`修饰引用
如`h`引用被修饰成`final`，表示该引用只有**1**次指向对象的机会

```java
 final Hero h;
 h  =new Hero();
 h  =new Hero();//编译错误
```

### 常量

常量指的是可以公开，直接访问，不会变化的值

```java
 public static final int itemTotalNumber = 6;//物品栏的数量
```

### 问题

设计一个类SomeString,继承 String类。 能否继承？

**答：不能，因为String类是``final``修饰的，不能被继承**
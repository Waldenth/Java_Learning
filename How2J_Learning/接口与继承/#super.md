### 关键字super



#### 实例化子类，父类的构造方法一定会被调用

实例化一个`ADHero()`, 其构造方法会被调用
其**父类的构造方法也会被调用**
并且是父类构造方法**先调用**

！！！

**子类构造方法会默认调用父类的 无参的构造方法**

**super**是指向父类的引用，如果构造方法没有显示地调用父类的构造方法，那么编译器会自动为它加上一个默认的`super()`方法调用。如果父类由没有默认的无参构造方法，编译器就会报错，`super(...)`语句必须是构造方法的第一个子句。

相对的，**this**表示一个对象的引用,它指向正在执行方法的对象.

#### 类比this

`super`可以用于调用父类的构造方法

**父类**

```java
public class Hero {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度
    public void useItem(Item i){
        System.out.println("hero use item");
        i.effect();
    }   
    //无参构造
    public Hero(){
        System.out.println("Hero的无参的构造方法 ");
    }
    //有参构造
    public Hero(String name){
        System.out.println("Hero的有一个参数的构造方法 ");
        this.name = name;
    }
    public static void main(String[] args) {
        new Hero();
    }     
}
```

**子类**

使用关键字**super** 显式调用父类带参的构造方法

```java
public class ADHero extends Hero implements AD{
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
    public ADHero(String name){
        super(name);//显式调用父类代餐构造方法
        System.out.println("AD Hero的构造方法");
    }
    public static void main(String[] args) {
        new ADHero("德莱文");
    } 
}
```

**注意！！！**

`super(...)`语句必须是构造方法的第一个子句。

**调用父类属性**

通过`super`调用父类的`moveSpeed`属性
`ADHero`也提供了属性`moveSpeed`

```java
public class ADHero extends Hero implements AD{
    int moveSpeed=400; //移动速度
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
    public int getMoveSpeed(){
        return this.moveSpeed;//自己的movespeed
    } 
    public int getMoveSpeed2(){
        return super.moveSpeed;//父类的movespeed
    }     
    public static void main(String[] args) {
        ADHero h= new ADHero();

        System.out.println(h.getMoveSpeed());
        System.out.println(h.getMoveSpeed2());    
    } 
}
```

**调用父类方法**

`ADHero`重写了`useItem`方法，并且在`useItem`中**通过super调用父类的`useItem`方法**

```java
package charactor;
 
import property.Item;
import property.LifePotion;
 
public class ADHero extends Hero implements AD {
    int moveSpeed = 400; // 移动速度
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
    public int getMoveSpeed() {
        return this.moveSpeed;
    }
    public int getMoveSpeed2() {
        return super.moveSpeed;
    }
    // 重写useItem，并在其中调用父类的userItem方法
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
    public static void main(String[] args) {
        ADHero h = new ADHero();
        LifePotion lp = new LifePotion();
    }
}
```

#### 练习

父类Hero提供了一个有参的构造方法:

```java
public Hero(String name){
  	this.name = name;
}
```

但是没有提供无参的构造方法
子类应该怎么处理？

**解答**

由于作为子类，无论如何 都会调用父类的构造方法。默认情况下，会调用父类的无参的构造方法。 但是，当父类没有无参构造方法的时候( 提供了有参构造方法，并且不显示提供无参构造方法)，子类就会抛出异常，因为它尝试去调用父类的无参构造方法。 这个时候，子类应该必须通过`super`去调用父类声明的，存在的，有参的构造方法。

如果不希望在调用父类构造方法时赋值`name`，子类构造方法可以写成

```java
public ADHero(){
	super("");
    ....
}
```


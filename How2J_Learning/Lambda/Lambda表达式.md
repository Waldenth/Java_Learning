## Lambda表达式

假设一个情景： 找出满足条件的Hero
本教程将从使用**普通方法**，**匿名类**，以及**Lambda**这几种方式，逐渐的引入Lambda的概念

### 普通方法

使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据

 $hp>100 \&\& damage<50$

```java
public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;  
    public int damage;
    public Hero(){
           
    }
    public Hero(String name) {
        this.name =name;
   
    }  
    //初始化name,hp,damage的构造方法
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
   
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
}

```

```java
public interface HeroChecker {
    public boolean test(Hero h);
}

```

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        Collections.sort(heros);
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        
        filter(heros); // 普通方法

        /** 匿名类方法 **/
        /** 匿名类指的是在声明一个类的同时实例化它,是一个新的类 **/
        HeroChecker checker=new HeroChecker(){
            public boolean test(Hero h){
                return (h.hp>100&&h.damage<50);
            }
        };
        filter(heros, checker);

        /** Lambda方式 **/
        /** 从一个匿名类一点点演变成Lambda表达式 **/
        filter(heros,h->h.hp>100&&h.damage<50);

    }
  
    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if(hero.hp>100 && hero.damage<50)
                System.out.print(hero);
        }
    }

    private static void filter(List<Hero>heros,HeroChecker checker){
        for(Hero hero:heros){
            if(checker.test(hero)){
                System.out.print(hero);
            }
        }
    }
}
```

匿名类指的是在**声明一个类的同时实例化它**，使代码更加简洁精练
通常情况下，要使用一个接口或者抽象类，都必须创建一个子类

有的时候，为了快速使用，直接实例化一个抽象类(或者实现一个接口)，并“**当场**”实现其抽象方法(接口方法)。
既然实现了抽象方法，那么就是一个新的类，只是这个类，没有命名。
这样的类，叫做匿名类

#### 匿名类演变成Lambda

Lambda表达式可以看成是匿名类一点点**演变过来**

1. 匿名类的正常写法

```java
HeroChecker c1 = new HeroChecker() {
    public boolean test(Hero h) {
        return (h.hp>100 && h.damage<50);
    }
};
```

2. 把外面的壳子去掉
   只保留**方法参数**和**方法体**
   参数和方法体之间加上符号 **->**

```java
HeroChecker c2 = (Hero h) ->{
	return h.hp>100 && h.damage<50;
};
```

3. 把return和{}去掉

```java
HeroChecker c3 = (Hero h) ->h.hp>100 && h.damage<50;
```

4. 把 参数类型和圆括号去掉**(只有一个参数的时候，才可以去掉圆括号)**

 ```java'
HeroChecker c4 = h ->h.hp>100 && h.damage<50;
 ```

5. 把c4作为参数传递进去

 ```java
filter(heros,c4);
 ```

6. 直接把表达式传递进去

```java
filter(heros, h -> h.hp > 100 && h.damage < 50);
```

与[匿名类](https://how2j.cn/k/interface-inheritance/interface-inheritance-inner-class/322.html#step687) 概念相比较，
Lambda 其实就是**匿名方法**，这是一种**把方法作为参数**进行传递的编程思想。

虽然代码是这么写

```java
filter(heros, h -> h.hp > 100 && h.damage < 50);
```

但是，Java会在背后，悄悄的，把这些都还原成[匿名类方式](https://how2j.cn/k/lambda/lambda-lamdba-tutorials/697.html#step2552)。
引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞。

#### 弊端

Lambda表达式虽然带来了代码的简洁，但是也有其局限性。

1. 可读性差，与**啰嗦的**但是**清晰的**匿名类代码结构比较起来，Lambda表达式一旦变得比较长，就难以理解
2. 不便于调试，很难在Lambda表达式中增加调试信息，比如日志
3. 版本支持，Lambda表达式在JDK8版本中才开始支持，如果系统使用的是以前的版本，考虑系统的稳定性等原因，而不愿意升级，那么就无法使用。

Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。

#### 练习

把[比较器-Comparator](https://how2j.cn/k/collection/collection-comparator-comparable/693.html#step828) 章节中的代码，按照[从匿名类演变成Lambda表达式](https://how2j.cn/k/lambda/lambda-lamdba-tutorials/697.html#step2556)的步骤，改写为Lambda表达式

```java
//引入Comparator，指定比较的算法 (匿名类)
Comparator<Hero> c = new Comparator<Hero>() {
	@Override
	public int compare(Hero h1, Hero h2) {
        //按照hp进行排序
        if(h1.hp>=h2.hp)
            return 1;  //正数表示h1比h2要大
        else
            return -1;
	}
};
Collections.sort(heros,c);

//把外面壳子去掉,只保留方法参数和方法体
Comparator<Hero> c= (Hero h1, Hero h2)->{
	return h1.hp>=h2.hp?1:-1;
};
//把return和{}去掉
Comparator<Hero> c= (Hero h1, Hero h2)->h1.hp>=h2.hp?1:-1;
//把参数类型和圆括号去掉(只有一个参数的时候，才可以去掉圆括号)
Comparator<Hero> c=(h1,h2)->h1.hp>=h2.hp?1:-1;
//把c作为参数传递进去
Comparator<Hero> c=(h1,h2)->h1.hp>=h2.hp?1:-1;
Collections.sort(heros,c);
//直接传递表达式
Collections.sort(heros,(h1,h2)->h1.hp>=h2.hp?1:-1)

```



```java
Collections.sort(heros,(h1,h2)->h1.hp>=h2.hp?1:-1);
//
Collections.sort(heros,(h1,h2)->{
    if(h1.hp>=h2.hp)
        return 1;
  	else
        return -1;
})
```

λ表达式就是接口里的唯一未实现方法，语法是这样子的，*（参数列表）-> 函数体*。然后只有一的时候可以省略，一个参数可以省略小括号，一句函数体可以省略大括号，哦，对了 一句函数体的话，return也可以省略。所以只有一的时候省略。

λ表达式描述的是接口里的唯一未实现方法，那它怎么知道是接口的哪一个方法呢。实现类或者匿名内部类都可以通过方法名，参数类型之类的找出，而λ表达式又没方法名，参数类型也是没有的，这按传统的方法就没辙了。所以java8给了一个简单粗暴的办法，就找接口里面唯一没有实现的方法。所以如果接口里面有多个未实现方法，那就会编译报错了。

### Lambda方法引用

#### 引用静态方法

首先为`TestLambda`添加一个静态方法：

```java
public static boolean testHero(Hero h) {
   return h.hp>100 && h.damage<50;
}
```

Lambda表达式：

```java
filter(heros, h->h.hp>100 && h.damage<50);
```

在Lambda表达式中调用这个静态方法：

```java
filter(heros, h -> TestLambda.testHero(h) );
```

调用静态方法还可以改写为：

```java
filter(heros, TestLambda::testHero);
```

#### 引用对象方法

与引用静态方法很类似，只是传递方法的时候，需要一个对象的存在

```java
TestLambda testLambda = new TestLambda();
filter(heros, testLambda::testHero);
```

#### 引用容器中的对象方法

首先为Hero添加一个方法

```java
public boolean matched(){
   return this.hp>100 && this.damage<50;
}
```

使用Lambda表达式

```java
filter(heros,h-> h.hp>100 && h.damage<50 );
```

在Lambda表达式中调用容器中的对象Hero的方法matched

```java
filter(heros,h-> h.matched() );
```

matched恰好就是容器中的对象Hero的方法，那就可以进一步改写为

```java
filter(heros, Hero::matched);
```

#### 引用构造器

有的接口中的方法会返回一个对象，比如**`java.util.function.Supplier`**提供
了一个get方法，返回一个对象。

```java
public interface Supplier<T> {
   	 T get();
}
```

设计一个方法，参数是这个接口

```java
public static List getList(Supplier<List> s){
 	 return s.get();
}
```

为了调用这个方法，有3种方式
第一种匿名类：

```java
Supplier<List> s = new Supplier<List>() {
	public List get() {
		return new ArrayList();
	}
};
List list1 = getList(s);
```

第二种：Lambda表达式

```java 
List list2 = getList(()->new ArrayList());
```

第三种：引用构造器

`ArrayList::new`表示的是当前的`getList(arg==Supplier<List> s)`的`S`传入参数是一个

实现的接口`get()`方法是返回一个`ArrayList`的匿名类

```java
List list3 = getList(ArrayList::new);
```

### Lambda 聚合操作

遍历数据的传统方式就是使用for循环，然后条件判断，最后打印出满足条件的数据

```java
for (Hero h : heros) {
   if (h.hp > 100 && h.damage < 50)
       System.out.println(h.name);
}
```

使用聚合操作方式，**画风**就发生了变化：

```java
heros
	.stream()
	.filter(h -> h.hp > 100 && h.damage < 50)
	.forEach(h -> System.out.println(h.name));
```

#### Stream和管道

```java
heros
	.stream()
	.filter(h -> h.hp > 100 && h.damage < 50)
	.forEach(h -> System.out.println(h.name));
```

要了解聚合操作，首先要建立**Stream**和**管道**的概念
**Stream** 和Collection结构化的数据不一样，Stream是一系列的元素，就像是生产线上的罐头一样，一串串的出来。
**管道**指的是一系列的聚合操作。

管道又分3个部分
**管道源**：在这个例子里，源是一个List
**中间操作**： 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
**结束操作**：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像`forEach`，什么都不返回, 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断

**注：** 这个Stream和I/O章节的`InputStream,OutputStream`是不一样的概念。

#### 管道源

把Collection切换成管道源很简单，调用stream()就行了。

 ```java
heros.stream()
 ```

但是数组却没有stream()方法，需要使用

 ```java
Arrays.stream(hs)
 ```

 或者

`Stream.of(hs)`

```java
import charactor.Hero;
 
public class TestAggregate {
 
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //管道源是集合
        heros
        .stream()
        .forEach(h->System.out.println(h.name));
         
        //管道源是数组
        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)
        .forEach(h->System.out.println(h.name));
    }
}
```

#### 中间操作

每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
中间操作比较多，主要分两类
对元素进行筛选 和 转换为其他形式的流
**对元素进行筛选：**
filter 匹配
distinct 去除重复(根据equals判断)
sorted 自然排序
sorted(Comparator<T>) 指定排序
limit 保留
skip 忽略
**转换为其他形式的流**
`mapToDouble` 转换为`double`的流
`map `转换为任意类型的流

```java
import charactor.Hero;
  
public class TestAggregate {
  
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
        System.out.println("满足条件hp>100&&damage<50的数据");
          
        heros
            .stream()
            .filter(h->h.hp>100&&h.damage<50)
            .forEach(h->System.out.print(h));
          
        System.out.println("去除重复的数据，去除标准是看equals");
        heros
            .stream()
            .distinct()
            .forEach(h->System.out.print(h));
        System.out.println("按照血量排序");
        heros
            .stream()
            .sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
            .forEach(h->System.out.print(h));
          
        System.out.println("保留3个");
        heros
            .stream()
            .limit(3)
            .forEach(h->System.out.print(h));
          
        System.out.println("忽略前3个");
        heros
            .stream()
            .skip(3) //忽略前3个
            .forEach(h->System.out.print(h));
          
        System.out.println("转换为double的Stream");
        heros
            .stream()
            .mapToDouble(Hero::getHp)
            .forEach(h->System.out.println(h));
          
        System.out.println("转换任意类型的Stream");
        heros
            .stream()
            .map((h)-> h.name + " - " + h.hp + " - " + h.damage)
            .forEach(h->System.out.println(h));
          
    }
}
```

#### 结束操作

当进行结束操作后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,。
结束操作才真正进行遍历行为，前面的中间操作也在这个时候，才真正的执行。
常见结束操作如下：
**forEach()** 遍历每个元素
**toArray()** 转换为数组
**min(Comparator<T>)** 取最小的元素
**max(Comparator<T>)** 取最大的元素
**count()** 总数
**`findFirst()`** 第一个元素


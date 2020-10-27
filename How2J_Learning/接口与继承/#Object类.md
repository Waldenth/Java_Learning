## Object类

Object类是所有类的父类

声明一个类的时候，默认是继承了Object
`public class Hero extends Object`

### toString()

`Object`类提供一个`toString`方法，所以所有的类都有`toString`方法
`toString()`的意思是返回当前对象的**字符串表达**
通过 `System.out.println` 打印对象就是打印该对象的`toString()`返回值

```java
public class Hero {
    public String name;
    protected float hp;
      
    public String toString(){
        return name;
    }
    public static void main(String[] args) {
         
        Hero h = new Hero();
        h.name = "盖伦";
        System.out.println(h.toString());
        //直接打印对象就是打印该对象的toString()返回值
        System.out.println(h);
    }
}
```

### finalize()

当一个对象没有任何引用指向的时候，它就满足垃圾回收的条件

当它被垃圾回收的时候，它的finalize() 方法就会被调用。

finalize() **不是开发人员主动调用**的方法，而是由虚拟机JVM调用的。

```java
public class Hero {
    public String name;
    protected float hp;
      
    public String toString(){
        return name;
    }
    public void finalize(){
        System.out.println("这个英雄正在被回收");
    }
    public static void main(String[] args) {
        //只有一引用
        Hero h;
        for (int i = 0; i < 100000; i++) {
            //不断生成新的对象
            //每创建一个对象，前一个对象，就没有引用指向了
            //那些对象，就满足垃圾回收的条件
            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
            //一旦这个对象被回收，它的finalize()方法就会被调用
            h = new Hero();
        }
    }
}
```

### equals()

equals() 用于判断两个对象的内容是否相同

假设，当两个英雄的hp相同的时候，我们就认为这两个英雄相同

```java
public class Hero {
    public String name;
    protected float hp;
      
    public boolean equals(Object o){//这是对equals()的重写
        // 参考对象转型.md,这里判断一个引用所指向的对象，是否是Hero类型，或者Hero的子类
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }  
    public static void main(String[] args) {
        Hero h1= new Hero();
        h1.hp = 300;
        Hero h2= new Hero();
        h2.hp = 400;
        Hero h3= new Hero();
        h3.hp = 300;
         
        System.out.println(h1.equals(h2));
        System.out.println(h1.equals(h3));
    }
}
```

### ==

这不是Object的方法，但是用于判断两个对象是否相同
**更准确的讲**，用于判断两个引用，是否指向了同一个对象

### hashCode()

hashCode方法返回一个对象的哈希值，hashCode的意义，将放在[hashcode 原理](https://how2j.cn/k/collection/collection-hashcode/371.html)章节讲解

### 线程同步相关方法

`Object`还提供线程同步相关方法
`wait()`
`notify()`
`notifyAll()`
这部分内容的理解需要建立在对线程安全有足够的理解的基础之上，所以会放在[线程交互](https://how2j.cn/k/thread/thread-wait-notify/358.html) 的章节讲解

### getClass()

getClass()会返回一个对象的[类对象](https://how2j.cn/k/reflection/reflection-class/108.html)，属于高级内容，不适合初学者过早接触，关于类对象的详细内容请参考[反射机制](https://how2j.cn/k/reflection/reflection-reflection/107.html)

### 练习

重写`Item`的 `toString()`, `finalize()`和`equals()`方法
`toString() `返回Item的`name + price`
`finalize() `输出当前对象正在被回收
`equals(Object o) `首先判断`o`是否是`Item`类型，然后比较两个`Item`的`price`是否相同
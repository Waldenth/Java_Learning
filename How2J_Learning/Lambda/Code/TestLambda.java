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
        //Collections.sort(heros);
        Collections.sort(heros,(h1,h2)->{
            if(h1.damage>h2.damage)
                return 1;
            else
                return -1;
        });
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");

        System.out.println("---------------------");
        filter(heros); // 普通方法
        System.out.println("---------------------");
        /** 匿名类方法 **/
        /** 匿名类指的是在声明一个类的同时实例化它,是一个新的类 **/
        HeroChecker checker=new HeroChecker(){
            public boolean test(Hero h){
                return (h.hp>100&&h.damage<50);
            }
        };
        filter(heros, checker);
        System.out.println("---------------------");
        /** Lambda方式 **/
        /** 从一个匿名类一点点演变成Lambda表达式 **/
        filter(heros,h->h.hp>100&&h.damage<50);
        System.out.println("---------------------");

        System.out.println("Lambda直接引用静态方法");
        filter(heros,h->TestLambda.testHero(h));
        System.out.println("另一种写法");
        filter(heros,TestLambda::testHero);

        System.out.println("引用容器中的对象方法");
        filter(heros,h->h.matched());


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

    public static boolean testHero(Hero h){
        return h.hp>100&&h.damage<50;
    }

}

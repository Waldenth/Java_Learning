package multiplethread;

import charactor.QuickHero;

public class TestThreadPriority {
    public static void main(String[] args) {
          
        final QuickHero gareen = new QuickHero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;
  
        final QuickHero teemo = new QuickHero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;
          
        final QuickHero bh = new QuickHero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;
          
        final QuickHero leesin = new QuickHero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;
          
        Thread t1= new Thread(){
            public void run(){
 
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }              
            }
        };
         
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
          
    }
}

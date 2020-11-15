public class Test {
    public static void main(String[]args){
        Cat myCat=new Cat("Kitty");
        Spider aSpider=new Spider();
        Fish myFish=new Fish();
        test(myCat,aSpider,myFish);
    }
    private static void test(Cat myCat,Spider aSpider,Fish myFish){
        myCat.play();
        aSpider.eat();
        myFish.eat();
        myFish.setName("belly");
        myFish.eat();
    }
}

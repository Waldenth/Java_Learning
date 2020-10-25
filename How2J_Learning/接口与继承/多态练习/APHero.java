public class APHero extends Hero implements Mortal {
    public void die(){
        System.out.println("APHero "+this.name+" 死亡");
    }
}

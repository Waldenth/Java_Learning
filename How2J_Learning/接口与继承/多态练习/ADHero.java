public class ADHero extends Hero implements Mortal{
    public void die(){
        System.out.println("ADHero "+this.name+" 死亡");
    }
}
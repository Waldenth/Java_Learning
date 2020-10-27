public class LifePotion extends Item {
    public void effect(){
        System.out.println("回血");
    }
    public boolean disposable(){
        return true;
    }
}

public class MagicPotion extends Item {
    public void effect(){
        System.out.println("回魔法");
    }
    public boolean disposable(){
        return true;
    }
}

public class Hero{
    String name;
    public void kill(Mortal m){
        System.out.println(this.name+"发动了攻击");
        m.die();
    }
}
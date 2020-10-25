public class run{
    public static void main(String[]args){
        ADHero h1=new ADHero();
        h1.name="AA";
        APHero h2=new APHero();
        h2.name="BB";
        h1.kill(h2);
        h2.kill(h1);
    }
}
class Dog{
    String name;
    String says;
    public Dog(String str,String str2){
        name=str;
        says=str2;
    }
    public Dog(){

    }
}
public class Ex5and6 {
    public static void main(String[]args){
        Dog spot=new Dog("spot","Ruff!");
        Dog scruffy=new Dog();
        scruffy.name="scruffy";
        scruffy.says="Wruf!";
        System.out.println(spot.name+" "+spot.says);
        System.out.println(scruffy.name+" "+scruffy.says);
        Dog newIndex=spot;
        if(newIndex.equals(spot)){
            System.out.println("EQUALL");
        }
    }
}

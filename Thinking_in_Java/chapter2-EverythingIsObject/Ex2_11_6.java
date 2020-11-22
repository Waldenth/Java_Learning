public class Ex2_11_6 {
    public static void main(String[]args){
        class StoreStuff{
            int storage(String s) {
                return s.length() * 2;
            }	
        }
        StoreStuff s=new StoreStuff();
        System.out.println(s.storage("hi"));
    }
}

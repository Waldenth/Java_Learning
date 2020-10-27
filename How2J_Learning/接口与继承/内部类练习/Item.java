public abstract class Item{
    String name;
    int price;
    public abstract boolean disposable();
        public static void main(String[]args){
            Item i=new Item(){
            public boolean disposable(){
                return false;
            }
        };
        System.out.println(i.disposable());
    }   
}
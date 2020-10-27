public class Item { //extends Object
    String name;
    int price;
    public Item(String name,int price){
        this.name=name;
        this.price=price;
    }
    public String toString(){
        return name+price;
    }
    public void finalize(){
        System.out.println("回收名字是"+this.name+"的Item");
    }
    public boolean equals(Object o){
        if(o instanceof Item){
            Item i=(Item) o;
            if(i.price==this.price){
                System.out.println("价格相同");
                return true;
            } else{
                System.out.println("价格不同,不匹配");
                return false;
            }
        }else{
            System.out.println("不匹配");
            return false;
        }
        
    }
    public static void main(String[]args){
        Item a=new Item("西瓜",100);
        Item b=new Item("苹果",50);
        a.equals(b);
        System.out.println(a.toString());
    }
}

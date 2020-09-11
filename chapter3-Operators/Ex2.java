//: operators/Assign.java
// TIJ4 Chapter Operators, Exercise 2, page 97 
// Create a class containing a float and use it to demonstrate aliasing
class tube{
    float data;
}
public class Ex2{
    public static void main(String[]args){
        tube t1=new tube();
        tube t2=new tube();
        //need point out number format
        t1.data=3.14159f;
        t2.data=2.71828f;
        System.out.println("t1="+t1.data+" t2="+t2.data);
        t1=t2;
        t2.data=1.000f;
        System.out.println("t1="+t1.data+" t2="+t2.data);
    }
}
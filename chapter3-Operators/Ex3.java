//: operators/PassObject2.java
// TIJ4 Chapter Operators, Execise 3, page p98
// Create a class containing a float and use it to demonstrate aliasing during
// method calls

class Box{
    float data;
}
public class Ex3 {
    static void f(Box x){
        x.data=2.71828f;
    }
    public static void main(String[]args) {
        Box tmp=new Box();
        tmp.data=3.1415f;
        System.out.println("data="+tmp.data);
        f(tmp);
        System.out.println("data="+tmp.data);
    }
}

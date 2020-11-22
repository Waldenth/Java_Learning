public class Ex2_11_4and5 {
    public static void main(String[]args){
        class DataOnly {
            int i;
            double d;
            boolean b;
            void show() {
                System.out.println(i);
                System.out.println(d);
                System.out.println(b);	
            }
        }
        DataOnly data=new DataOnly();
        data.i=100;
        data.d=3.1415926;
        data.b=true;
        data.show();	
    }
}

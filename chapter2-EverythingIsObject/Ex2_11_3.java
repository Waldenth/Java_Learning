// TIJ4 Chapter Object, Exericise 3, page 90
// object/ATNTest.java
// Find the code fragments involving ATypeName and turn them into a program
// that compiles and runs.
public class Ex2_11_3 {
	public static void main(String[]args) {
		class ATypeName{
			int a;
			char b;
			boolean c;
			void show() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
		}
		ATypeName obj=new ATypeName();
		obj.a=1;
		obj.b='M';
		obj.c=true;
		obj.show();
	}
}

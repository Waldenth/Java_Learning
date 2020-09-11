// operators/LongValues.java
// TIJ4 Chapter Operaters, Exercise 8, page 109
// Show that hex and octal notations work with long values. 
// Use Long.toBinaryString to display the results.

public class Ex8 {
	public static void main(String[] args) {
		long n1 = 0xffff; // hexadecimal
		long n2 = 077777; // octal
		System.out.println("long n1 in hex = " + Long.toBinaryString(n1));
		System.out.println("long n2 in oct = " + Long.toBinaryString(n2));
	}
}
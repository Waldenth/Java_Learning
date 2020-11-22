// operators/BinaryTest.java
// TIJ4 Chapter Operators, Exercise 10, page 112 
/* Write a program with two constant values, one with alternating binary ones and
* zeroes, with a zero in the least-significant digit, and the second, also
* alternating, with a one in the least-significant digit (hint: It's easiest to 
* use hexadecimal constants for this). Take these two values and combine them in
* all possible ways using the bitwise operators, and display the results using
* Integer.toBinaryString(). 
*/

public class Ex10 {
	public static void main(String[] args) {
		int i = 1 + 4 + 16 + 64;
		int j = 2 + 8 + 32 + 128;
		System.out.println("i = " + Integer.toBinaryString(i));
		System.out.println("j = " + Integer.toBinaryString(j));
		System.out.println("i & j = " + Integer.toBinaryString(i & j));
		System.out.println("i | j = " + Integer.toBinaryString(i | j));
		System.out.println("i ^ j = " + Integer.toBinaryString(i ^ j));
		System.out.println("~i = " + Integer.toBinaryString(~i));
		System.out.println("~j = " + Integer.toBinaryString(~j));
	}
}
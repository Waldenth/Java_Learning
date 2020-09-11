//: operators/CoinToss.java
// TIJ4 Chapter Operators, Exercise 7, page 106
// Write a program that simulates coin-flipping

import java.util.*; 

public class Ex7 {
	public static void main(String[] args) {
        int head=0;
        int tail=0;
        int count=50000;
        Random TossCoin=new Random();	
        for(int i=0;i<count;i++){
            if(TossCoin.nextBoolean()){
                head++;
            }else{
                tail++;
            }
        }
        System.out.println(head+" "+tail);
	}
}

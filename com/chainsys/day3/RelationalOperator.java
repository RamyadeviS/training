package com.chainsys.day3;
import java.util.Scanner;
public class RelationalOperator {

	public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
     System.out.println("enter your age");
     int yourAge=scanner.nextInt();
     if(yourAge>19) {
    	 System.out.println("you are major");
     }
     else {
    	 System.out.println("you are minor");
     }

	}

}
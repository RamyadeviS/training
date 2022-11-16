package com.chainsys.day3;

import java.util.Scanner;

public class RelationalOperator1 {

	public static void main(String[] args) {
		int age;
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("enter your age");
	    int yourAge=scanner.nextInt();
	    if(yourAge>19) {
	    	 System.out.println("Enter marrital status");
	    	 String marritalStatus=scanner.next();
	    	 if(marritalStatus.equals("married")){
	    	 System.out.println("you are married");
	     }
	     else {
	    	 System.out.println("you are unmarried");
	     }
	    }
	    	 else {
	    System.out.println("you are not eligible to married");	      
	    	 }
		}



	}



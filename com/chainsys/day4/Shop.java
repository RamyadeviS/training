package com.chainsys.day4;
import java.util.Scanner;
public class Shop {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter your purchasing cost");
    int purchasingCost=sc.nextInt();
    if(purchasingCost>1000) {
    	purchasingCost=purchasingCost-(purchasingCost/100)*10;
    	System.out.println("you will get discount,10%"+purchasingCost);
    	
    }
    else
    {
    	System.out.println("you will not get discount");
    }

	}

}

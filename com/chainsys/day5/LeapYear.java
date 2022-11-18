package com.chainsys.day5;
import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a year");
        int year=sc.nextInt();
        while(year<=1997) {
        	System.out.println(""+year);
        	if(year%4<=0) {
        		System.out.println("is lea year");
        		year++;
        	}
        	else {
        		System.out.println("is not leap year");
        		year++;
        	}
        }
	}

}

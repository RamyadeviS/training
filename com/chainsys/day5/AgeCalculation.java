package com.chainsys.day5;
import java.util.Scanner;
public class AgeCalculation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the gender");
        String gender=sc.next();
        System.out.println("enter the age");
        int age=sc.nextInt();
        if(age >25 && gender.equals("man")) {
        	System.out.println("man");
        	
        }
        else if(age >20 && gender.equals("women")) {
        	System.out.println("women");
        }
        else if (age <25 && gender.equals("boy")) {
        	System.out.println("boy");
        	
        }
        else if (age <25 && gender.equals("girl")){
        	System.out.println("girl");
        }
        else {
        	System.out.println("invalid");
        }
        	
        	
        }
        
	}
	



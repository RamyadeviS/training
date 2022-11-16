package com.chainsys.day3;
import java.util.Scanner;
public class Grading {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter mark");
	int mark=scanner.nextInt();
	if(mark<25) {
		System.out.println("Grade:F");
		
	}
	else if(mark>=25&&mark>=45) {
		System.out.println("Grade:E");
	}
		else if(mark>=45&&mark>=50) {
			System.out.println("Grade:D");
		}
		else if(mark>=50&&mark>=60) {
			System.out.println("Grade:C");
		}
		else if(mark>=60&&mark>=80) {
			System.out.println("Grade:B");
		}
		else if(mark>80) {
			System.out.println("Grade:A");
		}
		else
		{
			System.out.println("Invali mark");
		
		
	}
			
			
			
			

	}

}

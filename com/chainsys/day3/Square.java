package com.chainsys.day3;
import java.util.Scanner;
public class Square {

	public static void main(String[] args) {
	    Scanner scanner=new Scanner(System.in);
		System.out.println("enter length");
		int length=scanner.nextInt();
		System.out.println("enter breadth");
		int breadth=scanner.nextInt();
		if(length==breadth) {
			System.out.println("it is a square");
		}
		else {
			System.out.println("it is not a square");
			
		}
	}

}

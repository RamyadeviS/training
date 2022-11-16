package com.chainsys.day4;
import java.util.Scanner;
public class medicalCause {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your medical cause");
	String medicalCause=sc.next();
	if(medicalCause.equals("yes")) {
System.out.println("you will allow the exam");
	}
	else
	{
		System.out.println("youwill not allow the exam ");
	}
}
}

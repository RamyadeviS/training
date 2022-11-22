package com.chainsys.day7;

import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		String s;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("enter two numbers:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("choose the operation:+,-,*,%,/");
		char op=sc.next().charAt(0);
		switch(op) 
		{
		case'+':{
			System.out.println("addition:"+(num1+num2));
			break;
		}
		case'-':{
			System.out.println("subraction:"+(num1-num2));
			break;
		}
		case'*':{
			System.out.println("multiplication:"+(num1*num2));
			break;
		}
		
		case'/': {
			System.out.println("division:"+(num1/num2));
			break;
		}
		case'%': {
			System.out.println("modulus:"+(num1%num2));
			break;
		}
		default:
		{
			System.out.println("invalid operator");
		}
		}
		
		System.out.println("do you want to continue the operation?y/no");
	    s=sc.next();
	    
		}while(s.equals("y"));
		
		}
	
}

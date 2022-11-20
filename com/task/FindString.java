package com.task;

public class FindString {

	public static void main(String[] args) {
		String s="Hello world";
		int a=s.indexOf('o');
		System.out.println("the first occuence of the letter of 'o' is in "+a+" position");
		int b=s.indexOf(' ');
		System.out.println("the first occuence of the letter of '' is in "+b+" position");
		int a1=s.indexOf('o');
		System.out.println("the first occuence of the letter of 'o' is in "+a1+" position");
		int b1=s.indexOf(' ');
		System.out.println("the first occuence of the letter of '' is in "+b1+" position");

	}

}

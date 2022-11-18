package com.chainsys.day6;

public class Calculator  {
	public static void main(String[]args) {
		addition();
		difference();
		product();
	}
	
	public static void difference() {
		int i=10,j=-5;
		int diff=j-i;
    System.out.println("difference:"+diff);
	}
public static void addition() {
	int i=10,j=-5;
	int sum=i+j;
	System.out.println("sum:"+sum);
	}
public static void product() {
	int i=10,j=-5;
	System.out.println(i*j);
}
}

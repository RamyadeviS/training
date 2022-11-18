package com.chainsys.day5;
import java.util.Scanner;
public class Integers {

	public static void main(String[] args) {
	int n,sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the numbers");
	n=sc.nextInt();
	for (int i=1;i<n;i++) {
		sum+=i;
		}
		System.out.println(sum);
	
	
	
	}

}

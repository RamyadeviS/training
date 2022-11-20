package com.task;
import java.util.Scanner;
public class SumAndProduct {

	public static void main(String[] args) {
		int sum=0;
		int product=1;
		int[]a=new int[5];
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the 4 elemets");
		for(int i=0;i<a.length;i++) {
			a[i]=scanner.nextInt();
			sum=sum+a[i];
			product=product*a[i];
		}		
			System.out.println("sum of all the elements of an array:"+sum);
			System.out.println("product of all the elements of an array:"+product);
		}
	}



package com.chainsys.day5;
import java.util.Arrays;
import java.util.Scanner;
public class MaximumNumbers {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int number;
		System.out.println("enter the size of an array");
		number=scanner.nextInt();
		int num[]=new int[number];
		System.out.println("enter a number");
		
		for(int i=0;i<number;i++) {
			num[i]=scanner.nextInt();
		}
		
		Arrays.sort(num);
		for(int i=0;i<number;i++){
		
		}
		for(int i=number-1;i>1;i--) {
			if(num[i]!=num[i-1]) {
			System.out.println(num[i]+"and"+num[i-1]+"is two maximum elements in array");
		
			break;
			}
		}
	}
}
			
		
			

	



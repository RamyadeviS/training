package com.chainsys.day5;
import java.util.Scanner;
public class Average {

	public static void main(String[] args) {
    int count;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter count of numbers");
    count=sc.nextInt();
    int number,sum=0;
    float average=0;
    for(int i=0;i<count;i++) {
    number=sc.nextInt();
    sum=sum+number;
	}
    average=sum/count;
    System.out.println("entered the sum of numbers:"+sum);
    System.out.println("enter average numbers:"+average);
    

	}

}

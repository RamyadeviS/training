package com.task;
import java.util.Scanner;
public class LargestSmallest {
	public static void main(String[] args) {
		int a[]= {10,20,3,4,11};
		int smallest=a[0];
		int largest=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>largest) {
				largest=a[i];
				}
			
				else if(a[i]<smallest) {
					smallest=a[i];
				
			System.out.println("the number is largest::"+largest); 
			System.out.println("the number is smallest::"+smallest);
			
			}
				
		
	}
				
}
		
}	
		

	



package com.task;

public class OddEvenArray {

	public static void main(String[] args) {
		int a[]= {1,2,3,5,6,8,9,30};
		System.out.println("odd numbers are:");
		for(int i=0;i<a.length;i++) {
			if(a[i]%2!=0) {
				System.out.println(a[i]);
			}
		}
System.out.println("even umbers are:");
for(int i=0;i<a.length;i++) {
	if(a[i]%2==0) {
		System.out.println(a[i]);
	}
}
	}
	

}

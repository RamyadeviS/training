package com.chainsys.day8;
import java.util.Scanner;
public class EmailArray {

	public static void main(String[] args) {
		/*String a[]={"raja@gmail.com","sush@gmail.com","deva@gmail.com","sne@gmail.com","ramu@gmail.com"};
		for(int i=0;i<a.length;i++)	{
			System.out.println("email:"+a[i]);
		}*/
     Scanner sc=new Scanner(System.in);
     String s[]=new String[2];
     System.out.println("enter an email:");
     for(int i=0;i<s.length;i++) {
    	 s[i]=sc.next();
    	 if(s[i].length()<8) {
    		 System.out.println("your mail is invalid:");	 
     }
    	 else {
    		 System.out.println("valid email:");
    	 }
     }
     for(int i=0;i<s.length;i++) {
    	 if(s.length>10) {
    		 System.out.println("email id:"+s[i]);
    	 }
    	 
    	 }
     }
	
	}


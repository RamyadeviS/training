package com.chainsys.day9;

public class UserName {

	public static void main(String[] args) throws InvalidAgeException {
		int age=2;
		if(age>18) {
	    System.out.println("eligible");  
			
		}else
			throw new InvalidAgeException();
	}

}

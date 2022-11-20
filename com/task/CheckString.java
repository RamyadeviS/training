package com.task;

public class CheckString {

	public static void main(String[] args) {
		String s="umberlla";
		boolean b=true;
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i)=='e') {
				System.out.println("Is the letter 'e' present in the string:"+b);
				break;
			}
		}

	}

}

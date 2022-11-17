package com.chainsys.day5;

public class Constructor {
	int a;
	Boolean b;
	 Constructor(){
		 a=5;
		 b=true;
	
	 }

	public static void main(String[] args) {
		Constructor con = new Constructor();
		System.out.println("default value:");
		System.out.println("boolean "+con.b);
        System.out.println("int "+con.a);
	}

}

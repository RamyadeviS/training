package com.chainsys.day9;

public class ExS {

	public static void main(String[] args) {
		int no1 = 10, no2 = 0, no = 5;
		try {
			int result = no1 + no2;
			System.out.println(result);
			int avg = no1 / no2;
			System.out.println(avg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
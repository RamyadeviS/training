package com.chainsys.day8;
import java.util.ArrayList;
public class ListOfArrays {

	public static void main(String[] args) {
	ArrayList rollNo=new ArrayList();
		rollNo.add(34);
		rollNo.add(3);
		rollNo.add(47);
		rollNo.add(54);
		System.out.println(rollNo);
		rollNo.add(36);
		rollNo.add(84);
		rollNo.add(74);
		rollNo.add(3,46);
		System.out.println(rollNo);
		rollNo.remove(1);
		System.out.println(rollNo);
	}

}

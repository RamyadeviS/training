package com.chainsys.day8;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
	  int [] mobileNumber= {21443,567789,678098,56780};
	  Arrays.sort(mobileNumber);
	  for(int i=0;i<mobileNumber.length;i++) {
		  System.out.println(mobileNumber[i]);
	  }
	  System.out.println(Arrays.binarySearch(mobileNumber,567789));
	  String []name= {"ram","anu","kumar","priya"};
	  Arrays.sort(name);
	  for(int i=0;i<name.length;i++) {
		  System.out.println(name[i]);
	  }
	  System.out.println(Arrays.binarySearch(name,"kumar"));
      String[]newNameList=Arrays.copyOf(name,10);
      newNameList[5]="devi";
      newNameList[6]="raja";
      newNameList[7]="krishna";
      for(int i=0;i<newNameList.length; i++) {
    	  System.out.println(newNameList[i]);
      }
	}

}

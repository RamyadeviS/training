package com.chainsys.day8;
import java.util.Scanner;
public class GstCalculation {

	public static void main(String[] args) {
		String productName = null;
		int productQuantity = 0;
		int amount=0,total=0;
		int gstAmount=0;
		int bill=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user name");
		String name=sc.next();
		if(name.length()>3) {
			System.out.println("your name is valid");
		System.out.println("enter a category");
		System.out.println("1.mobiles:");
		System.out.println("2.food:");
		System.out.println("3.textile:");
		System.out.println("4.plastic");
		System.out.println("5.Electronics");
		System.out.println("choose the category");
		int c1=sc.nextInt();
		switch(c1) {
		
		case 1:{
			System.out.println("product name");	
		 productName=sc.next();
			System.out.println("product quantity");
			productQuantity=sc.nextInt();
			System.out.println("do you want to purchase this mobile/y/n");
			String a=sc.next();
			if(a.equals("yes")) {
				System.out.println("the GST will be 20%");
				System.out.println("enter amount");
		        	 amount=sc.nextInt();
		        	 total=productQuantity*amount;
		        	 gstAmount=(amount*20)/100;
		        	 bill=total+gstAmount;
					System.out.println("your payable amount is:"+bill);
		        	System.out.println("your purchasing is confirmed");
		        }
		        else {
		        	System.out.println("your purchasing is not confirmed");
		        }
		     }
			break;
			
		case 2:{
			System.out.println("enter the name of dish");
		 productName=sc.next();
			System.out.println("enter the food amount");
			 amount=sc.nextInt();
			 System.out.println("food quantity");
			 productQuantity=sc.nextInt();
			System.out.println("the GST will be 10%");
			 total=productQuantity*amount;
			 gstAmount=(amount*10)/100;
        	 bill=total+gstAmount;
			System.out.println("your payable amount is:"+bill);
		}
		break;
		
		case 3:{
			System.out.println("product name");
		 productName=sc.next();
		 System.out.println("product quantity");
		 productQuantity=sc.nextInt();
			System.out.println("do you want to purchase this dress/y/n");
			String s=sc.next();
			if(s.equals("yes")) {
				System.out.println("the GST will be 40%");
				System.out.println("enter amount");
			      amount=sc.nextInt();
			      total=productQuantity*amount;
			      gstAmount=(amount*40)/100;
		          bill=total+gstAmount;
			System.out.println("your payable amount is:"+bill);
			System.out.println("your purchasing is confirmed");
	        }
	        else {
	        	System.out.println("your purchasing is not confirmed");
		}
		}
		break;
			
		case 4:{
			
			System.out.println("product name");
			productName=sc.next();
			System.out.println("product quantity");
			productQuantity=sc.nextInt();
		    System.out.println("do you want to purchase this dress/y/n");
			String s=sc.next();
				if(s.equals("yes")) {
					System.out.println("the GST will be 10%");
					System.out.println("enter amount");
				      amount=sc.nextInt();
				      total=productQuantity*amount;
				      gstAmount=(amount*10)/100;
			          bill=total+gstAmount;
				System.out.println("your payable amount is:"+bill);
				System.out.println("your purchasing is confirmed");
		        }
		        else {
		        	System.out.println("your purchasing is not confirmed");
			
		        } 
		}
				break;
				
				case 5:{
					System.out.println("product name");
					productName=sc.next();
					System.out.println("product quantity");
					productQuantity=sc.nextInt();
				    System.out.println("do you want to purchase this dress/y/n");
					String s=sc.next();
						if(s.equals("yes")) {
							System.out.println("the GST will be 25%");
							System.out.println("enter amount");
						      amount=sc.nextInt();
						      total=productQuantity*amount;
						      gstAmount=(amount*25)/100;
					          bill=total+gstAmount;
						System.out.println("your payable amount is:"+bill);
						System.out.println("your purchasing is confirmed");
				        }
				        else {
				        	System.out.println("your purchasing is not confirmed");
				        }
				}
			
		System.out.println("*******welcome*******");
		System.out.println("------------------------------");
		System.out.println("      Bill no:"+45);
		System.out.println("\t\t\tDate:23/11/2022");  
		System.out.println("\t\t\tTime:8AM");	
		System.out.println("------------------------------");
		System.out.println("customer name:"+name);
		System.out.println("------------------------------");
		System.out.println("product name:"+productName);
		System.out.println("------------------------------");	
		System.out.println("product quantity:"+productQuantity);
		System.out.println("------------------------------");
		System.out.println("price:"+amount);
		System.out.println("------------------------------");
		System.out.println("GST price:"+gstAmount);
		System.out.println("-------------------------------");
		System.out.println("Total amount:"+bill);
		System.out.println("--------------------------------");
		System.out.println("****Thank you!* Visit Again***");
		System.out.println("--------------------------------");
		
		}
		}
		else {
			System.out.println("your name is invalid");
}
}
}


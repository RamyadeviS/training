package com.chainsys.day7;
import java.util.Scanner;
public class CabBooking {

	public static void main(String[] args) {
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.println("choose your cab type");
		
		System.out.println("1.mini car:");
		System.out.println("2.micro car:");
		System.out.println("3.prime car:");
		System.out.println("enter the types of car");
		int c=sc.nextInt();
		switch(c) {
		case 1:{
			System.out.println("mini car");
			System.out.println("it cost Rs12/km");
			System.out.println("do you want to continue with mini/y/n");
			String s=sc.next();
			while(s.equals("s")) {
			System.out.println("enter how many km you have to a travel:");
			int c1=sc.nextInt();
			a=c1*12;
			System.out.println("your payable amonut is:"+a);
			System.out.println("do you want to confirm your cab booking?");
			char choice=sc.next().charAt(0);
			int bookingNumber = (int) ((float) Math.random()*10000);
			System.out.println("Booking Reference : "+bookingNumber);
			if(choice=='y') {
				System.out.println("your cab is booked");
			}
			else {
				System.out.println("you cancelled your cab");
				
			}
			}
		break;
		}
			case 2:{
				System.out.println("micro car");
				System.out.println("it cost Rs10/km");
				System.out.println("do you want to continue with micro/y/n");
				String s=sc.next();
				while(s.equals("s")) {
				System.out.println("enter how many km you have to a travel:");
				int c2=sc.nextInt();
				a=c2*10;
				System.out.println("your payable amonut is:"+a);
				System.out.println("do you want to confirm your cab booking?");
				char choice=sc.next().charAt(0);
				int bookingNumber = (int) ((float) Math.random()*10000);
				System.out.println("Booking Reference : "+bookingNumber);
				if(choice=='y') {
					System.out.println("your cab is booked");
			}
				else {
					System.out.println("you cancelled your cab");
				}
				}
			
			break;
			
			}
				case 3:{
					System.out.println("prime car");
					System.out.println("it cost Rs8/km");
					System.out.println("do you want to continue with prime/y/n");
					String s=sc.next();
					while(s.equals("s")) {
					System.out.println("enter how many km you have to a travel:");
					int c3=sc.nextInt();
					a=c3*8;
					System.out.println("your payable amonut is:"+a);
					System.out.println("do you want to confirm your cab booking?");
					char choice=sc.next().charAt(0);
					int bookingNumber = (int) ((float) Math.random()*10000);
					System.out.println("Booking Reference : "+bookingNumber);
					if(choice=='y') {
						System.out.println("your cab is booked");
					}
					else {
						System.out.println("you cancelled your cab");
					}
					}
				
					break;
				}
				
				default: {
					System.out.println("invalid choice");
				}
				

}
			
		}
}
		

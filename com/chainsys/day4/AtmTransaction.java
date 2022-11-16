package com.chainsys.day4;
import java.util.Scanner;
public class AtmTransaction {

	public static void main(String[] args) {
		int balance=100000;
	Scanner scanner=new Scanner(System.in);
	System.out.println("ATM");
	System.out.println("Choose the functions:"+("withdraw,transaction,check balance,exit"));
	String functions=scanner.next();
	if(functions.equals("withdraw")) {
		System.out.println("enter withdraw money");
		int amount=scanner.nextInt();
		if(balance>=amount) {
			balance=balance-amount;
			System.out.println("pleasew collect your money");	
		}
	}
	else if(functions.equals("transaction"))
	{
	System.out.println("enter transaction money");
	int transactionMoney=scanner.nextInt();
	System.out.println("money transacted");
	
	}
    else if(functions.equals("checkbalance")) {
    	System.out.println("entercheckbalace:"+balance);  	
    }
    else if(functions.equals("exit"))
    {
    	System.exit(0);	
    }
    else {
    	System.out.println("functions invalid");
    	
    }
	   
	}
}

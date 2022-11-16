package com.chainsys.day3;
import java.util.Scanner;
public class Cricket {
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter two teams");
	String teamA=scanner.next();
	String teamB=scanner.next();
	System.out.println("Enter team score");
	int score=scanner.nextInt();
	if(score<200) {
		System.out.println("team A is winner");
		
	}
	else {
		System.out.println("team B is winner");
	}
	

	}

}

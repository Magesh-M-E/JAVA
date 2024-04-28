package com.divisosoft.atmproject;
import java.util.Scanner;
public class Atm{
static Scanner scan = new Scanner(System.in);
	public static void main(String[] atmproject){
	boolean flag = true;
	while(flag){
		System.out.println("\t\t\t WELCOME TO ABC BANK ATM SERVICE \t\t\t");
		System.out.println("please insert your card (yes/no)");
		String card = scan.nextLine();
		if(card.equals("yes")){
			Bank accountInfo = new AccountInfo("SBI","PATHIRIPALA");
			boolean check =true;
			while(check){
			String toupper=" press 1 to create account \n press 2 to deposit \n press 3 to withdraw \n press 4 to view balance \n press 5 to print mini statement \n press 6 to account transfer \n press 7 to exit";
			System.out.println(toupper.toUpperCase());
			String opt = scan.nextLine();
				switch(opt){
					case "1":accountInfo.createAccount();
					break;
					
					case "2":accountInfo.deposite();
					break;
					
					case "3":accountInfo.withdraw();
					break;
					
					case "4":accountInfo.viewBalance();
					break;
					
					case "5":accountInfo.printMiniStatement();
					break;

					case "6":accountInfo.accountTransfer();
					break;			
					
					case "7":check = false;
					break;
					

				}
			}
		}
		if(card.equals("no")){
			break;
		}
		
	}
}
}

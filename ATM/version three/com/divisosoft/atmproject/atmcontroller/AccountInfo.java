package com.divisosoft.atmproject.atmcontroller;
import java.util.*;
import com.divisosoft.atmproject.atmmodel.Account;
import com.divisosoft.atmproject.atmcontroller.*;

public abstract class AccountInfo  implements Bank{
	  String bankName;
	  
public AccountInfo(String bankName )
{
	this.bankName=bankName;
}
	
	
	Map<Integer,Account> MapAccountList = new HashMap<>();
	Map<Integer,String> statementList = new HashMap<>();

	Scanner scan = new Scanner(System.in);
	
	public void createAccount(){
		Account account = new Account();
		System.out.println("enter your pin");
		int a =scan.nextInt();
		account.setpin(a);
		System.out.println("enter account number");
		account.setaccountNumber(scan.nextInt());
		MapAccountList.put(a,account);
		statementList.put(a,"");
	}
	
	
	
	public void deposite(){
		System.out.println("enter pin number");
		int depoPin=scan.nextInt();	
		if(MapAccountList.containsKey(depoPin)){
			Account creditaccounts = MapAccountList.get(depoPin);
			System.out.println("enter the amount to deposite");
			int creditamount = scan.nextInt();
			int finalCreditBalance = creditaccounts.getbalance()+creditamount;
			creditaccounts.setbalance(finalCreditBalance);
			String depostatementHistory =statementList.get(depoPin);
			statementList.put(depoPin,depostatementHistory+"\n"+"CREDIT AMOUNT :"+creditamount+" BALANCE :"+finalCreditBalance);
		}
		else{
			System.out.println("please enter correct pin");
		}
	}	
	
	
	
	public void withdraw(){
		System.out.println("enter pin number");
		int withPin = scan.nextInt();
		if(MapAccountList.containsKey(withPin)){
			Account debitAccount = MapAccountList.get(withPin);
			System.out.println("Enter the withdrawal amount");
			int debitamount = scan.nextInt();
			if(debitAccount.getbalance()>=debitamount){
				int finalDebitBalance=debitAccount.getbalance()-debitamount;
				debitAccount.setbalance(finalDebitBalance);
				String withStatementHistory = statementList.get(withPin);
				statementList.put(withPin,withStatementHistory+"\n"+"DEBIT AMOUNT :"+debitamount+" BALANCE :"+finalDebitBalance);	
			}
			else{
				System.out.println("INSUFFICIENT BALANCE");
			}
		}
		else{
			System.out.println("please enter correct pin");
		}	
	}
	
		
	public  abstract void viewBalance();{
		System.out.println("enter your pin number");
		int balancePin = scan.nextInt();
		if(MapAccountList.containsKey(balancePin)){
			Account balanceAccount = MapAccountList.get(balancePin);
			System.out.println("Balance is :"+balanceAccount.getbalance());
		}
		else{
			System.out.println("please enter correct pin");
		}
	}
	
	

	public void printMiniStatement(){
		System.out.println("enter your pin");
		int statementPin = scan.nextInt();
		int statementPi = scan.nextInt();
		String statementAcc = statementList.get(statementPi);
		System.out.println(statementAcc);		
	}
	
	
	
	public void accountTransfer(){
		System.out.println("PLEASE ENTER YOUR PIN NUMBER");
		int yourPin = scan.nextInt();
		System.out.println("PLEASE ENTER THE RECIPIENT PIN NUMBER");
		int recPin = scan.nextInt();
		if(yourPin!=recPin){
			System.out.println("PLEASE ENTER AMOUNT");
			int transferingAmount = scan.nextInt();
		
			if(MapAccountList.containsKey(yourPin)&&MapAccountList.containsKey(recPin)){
				Account transferAccount = MapAccountList.get(yourPin);
				Account receivingAccount = MapAccountList.get(recPin);
				if(transferAccount.getbalance()>=transferingAmount){
					String tranaccHistory = statementList.get(yourPin);
					String recAccHistory = statementList.get(recPin);
			
					int transferAccountFinalBalance =transferAccount.getbalance()-transferingAmount;
					int receivingAccountFinalBalancr = receivingAccount.getbalance()+transferingAmount;
			
					statementList.put(yourPin,tranaccHistory+""+"DEBIT AMOUNT :"+transferingAmount+" BALANCE :"+transferAccountFinalBalance);
					statementList.put(recPin,recAccHistory+""+"CREDIT AMOUNT :"+transferingAmount+" BALANCE "+receivingAccountFinalBalancr);
			
					transferAccount.setbalance(transferAccountFinalBalance);
					receivingAccount.setbalance(receivingAccountFinalBalancr);
				}
				else{
					System.out.println("INSUFFICIENT BALANCE");
				}
			}
			else{
				System.out.println("PLEASE ENTER CORRECT PIN NUMBER");
			}
		}
		else{
			System.out.println("AMOUNT TRANSFER TO SAME ACCOUNT IS NOT POSSIBLE");
		}		
	}
}
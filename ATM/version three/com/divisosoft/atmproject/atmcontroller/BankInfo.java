package com.divisosoft.atmproject.atmcontroller;
import  com.divisosoft.atmproject.atmmodel.*;
public class BankInfo extends AccountInfo{

	String branchName;
	
	public BankInfo(String bankName,String branchName){
	super(bankName);
	this.branchName=branchName;
	System.out.println("\t\t\t"+bankName +" WELCOMES YOU"+"\n"+"\t\t\t"+branchName+"BRANCH");
	}
	
		public   void viewBalance(){
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
	
}
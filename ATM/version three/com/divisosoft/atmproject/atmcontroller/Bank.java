package com.divisosoft.atmproject.atmcontroller;
import com.divisosoft.atmproject.atmmodel.Account;

public interface Bank{
	public void createAccount();
	public void deposite();
	public void withdraw();
	public void viewBalance();
	public void printMiniStatement();
	public void accountTransfer();
}
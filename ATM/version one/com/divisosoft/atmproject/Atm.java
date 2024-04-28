import java.util.*;
public class Atm {
	
	Scanner scan = new Scanner(System.in);
	List<Account>accountList=new ArrayList<>();	
	
	public void createAccount(){
		Account account = new Account();
		System.out.println("enter your pin");
		account.setpin(scan.nextInt());	
		System.out.println("enter account number");
		account.setaccountNumber(scan.nextInt());
		accountList.add(account);
	}
	
	public void deposite(){
		Account creaccount = new Account();
		System.out.println("enter pin number");
		creaccount.setpin(scan.nextInt());
		for(Account creditaccounts:accountList){
			if(creditaccounts.equals(creaccount)){
				System.out.println("enter the amount to deposite");
				int creditamount = scan.nextInt();
				int finalCreditBalance=creditaccounts.getbalance()+creditamount;
				creditaccounts.setbalance(finalCreditBalance);
			}
			else{
				System.out.println("please enter correct pin");
			}
		}	
	}
	
	public void withdraw(){
		Account debitAccount = new Account();
		System.out.println("enter pin number");
		debitAccount.setpin(scan.nextInt());	
		for(Account debitaccounts:accountList){
			if(debitaccounts.equals(debitAccount)){
				System.out.println("Enter thw withdrawal amount");
				int debitamount = scan.nextInt();
				int finalDebitBalance=debitaccounts.getbalance()-debitamount;
				debitaccounts.setbalance(finalDebitBalance);
			}
			else{
				System.out.println("please enter correct pin");
			}
		}		
	}
	
	public void viewBalance(){
		Account balanceView = new Account();
		System.out.println("enter your pin number");
		balanceView.setpin(scan.nextInt());
		for(Account balance:accountList){
			if(balanceView.equals(balance)){
				System.out.println("Balance is :"+balance.getbalance());
			}
			else{
				System.out.println("please enter correct pin");
			}
		}	
	}
}


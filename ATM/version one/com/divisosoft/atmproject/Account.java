import java.util.Scanner;
public class Account{

	private int accountNumber;
	private int pin;
	private int balance;


	public int getaccountNumber(){
		return accountNumber;
	}
	
	public void setaccountNumber(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public int getpin(){
		return pin;
	}
	
	public void setpin(int pin){
		this.pin = pin;
	}

	public int getbalance(){
		return balance;
	}
	
	public void setbalance(int balance){
		this.balance = balance;
	}


		public boolean equals(Object obj){
			if(((Account)obj).pin==this.pin){
				return true;
			}
			else{
				return false;
			}
		}
	public String toString(){
		return getaccountNumber()+""+getpin();
	}
}
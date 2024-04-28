import java.util.Scanner;

public class Tdd{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] atmproject){
	boolean flag = true;
	while(flag){
		System.out.println("\t\t\t WELCOME TO ABC BANK ATM SERVICE \t\t\t");
		System.out.println("please insert your card (yes/no)");
		String card = scan.nextLine();
		if(card.equals("yes")){
			Atm atm = new Atm();
			boolean check =true;
			while(check){
			System.out.println(" press 1 to create account \n press 2 to deposit \n press 3 to withdraw \n press 4 to view balance \n press 5 to exit");
			String opt = scan.nextLine();
				switch(opt){
					case "1":atm.createAccount();
					break;
					
					case "2":atm.deposite();
					break;
					
					case "3":atm.withdraw();
					break;
					
					case "4":atm.viewBalance();
					break;
					
					case "5":check = false;
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
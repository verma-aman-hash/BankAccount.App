package bank_Appllication_From_Udemy;

import java.io.FileNotFoundException;
import java.util.List;

public class BankAccountApp implements Runnable{
	public static void main (String []args) throws InterruptedException, FileNotFoundException {
		String file = "/Users/aman/Desktop/NewBankAccounts.csv";
		Thread newthread1 = new Thread();
		Thread newthread2 = new Thread();
		newthread1.start();
		newthread2.start();
		List<String[]> newAccountHolder = AccountUtility.read(file);
		AccountUtility.loadCustomer(newAccountHolder);
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

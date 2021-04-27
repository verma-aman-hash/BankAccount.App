package bank_Appllication_From_Udemy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AccountUtility {
	public static void loadCustomer(List<String[]> newAccountHolder ) throws InterruptedException {
		List<Account> account = new LinkedList<Account>();

		
		for(String[] sd :newAccountHolder) {
			String[] name =sd[0].split(" ");
			String fname =name[0];
			String lname =name[1];
			long ssn = Long.parseLong(sd[1]);
			String accountType = sd[2];
			long initialDeposit =Long.parseLong(sd[3]);
			if(accountType.equalsIgnoreCase("savings")) {
				System.out.println("OPENING SAVING ACCOUNTS");
				account.add(new SavingsAccount(fname, lname, ssn, accountType, initialDeposit));
				System.err.println("\n\n******************************************************************************************************************************************************************");

			}
			else if(accountType.equalsIgnoreCase("checking")) {
				System.out.println("OPENING CHECKING ACCOUNT");
				account.add(new CheckingAccount(fname, lname, ssn, accountType, initialDeposit));
				System.err.println("\n\n******************************************************************************************************************************************************************");

			}
			else {
				System.err.println("Account Type could not found.");
			}
//			
		}
	}
	public static List <String[]> read(String file){
		
		String sb;
		List <String[]> newCustomer = new LinkedList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			while((sb = br.readLine()) != null) {
				String[] splitRowValues = sb.split(",");
				newCustomer.add(splitRowValues);}
			
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("COULD NOT READ FILE");
		e.printStackTrace();}
		return newCustomer;
	}
}
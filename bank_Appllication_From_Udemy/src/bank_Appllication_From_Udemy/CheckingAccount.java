package bank_Appllication_From_Udemy;

import java.util.concurrent.ThreadLocalRandom;

public class CheckingAccount extends Account{
	
	//Checking Account holders are assigned a DebitCaed with a 12-digit number and 4-digit pin.
	private long  debitCardNo;
	private int pin;

	public CheckingAccount(String firstName, String lastName, long ssn, String accountType, double intialDeposit) throws InterruptedException {
		super(firstName, lastName, ssn, accountType, intialDeposit);
		super.setAccountNumberbyType(2);
		this.setDebitCardNo();
		this.setPin();
		
		this.showInfo();
		
		super.showInfo();
		this.shpwBalance();
		this.ShowDebitCardInfo();
		
		
		}
	@Override
	public double setInterestRate() {
		rate = getInterestRate()*0.15;
		return rate;
	}
		public void ShowDebitCardInfo() {
			System.out.println("\t\t\t\tChecking Account Features are :"+
								"\t\tYour Debit Card Number is :"+getDebitCardNo()+
								"\t\tYour Debit card pin is :"+getPin()+"\n\n");
		}

	
		public void showInfo() {
			System.out.print("ACCOUNT TYPE :CHECKING");
		}
		public void shpwBalance() {
			System.out.println("\t\t\t\tCHEKING BALANCE :$"+super.getFinalBalance());
		}
		
		public long getDebitCardNo() {
			return debitCardNo;
		}

		public void setDebitCardNo() {
			this.debitCardNo = ThreadLocalRandom.current().nextLong(100000000000l, 999999999999l);
		}

		public int getPin() {
			return pin;
		}

		public void setPin() {
			this.pin = (int) (Math.random()*Math.pow(10, 4));
		}

		

}

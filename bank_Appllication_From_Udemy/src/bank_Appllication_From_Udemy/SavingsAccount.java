package bank_Appllication_From_Udemy;

public class SavingsAccount extends Account{
	
	//Savings Account holders are given a Safety Deposit box,identified by a 3-digit number and accessed with a 4-digit code.
	private int safetyDepositBox;
	private int safetyDepositPin;
	
	

	public SavingsAccount(String firstName, String lastName, long ssn, String accountType, double intialDeposit) throws InterruptedException {
		super(firstName, lastName, ssn, accountType, intialDeposit);
		super.setAccountNumberbyType(1);
		this.setSafetyDepositBox();
		this.setSafetyDepositPin();
		
		this.showInfo();
		
		super.showInfo();
		this.showBalance();
		this.showfeatures();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public double setInterestRate() {
		//saving account will use .25 points less than the base rate
		rate = getInterestRate()-0.25;
		return rate;
	}
	
	public int getSafetyDepositBox() {
		return safetyDepositBox;
	}
	public void setSafetyDepositBox() {
		this.safetyDepositBox =  (int) ((Math.random())*Math.pow(10, 3));
	}
	public int getSafetyDepositPin() {
		return safetyDepositPin;
	}
	public void setSafetyDepositPin() {
		this.safetyDepositPin = (int) ((Math.random())*Math.pow(10, 4));
	}
	public void showInfo() {
		System.out.print("ACCOUNT TYPE :\tSAVINGS");
		
	}
	public void showBalance() {
		System.out.println("\t\t\t\tSAVINGS BALANCE :$"+super.getFinalBalance());
	}
	public void showfeatures() {
		System.out.println("\t\t\t\tSaving Account Features are :"
							+"\t\tYour Safety Deposit Box is :"+getSafetyDepositBox()
							+"\t\t\tYour Safety Deposit Box pin is :"+getSafetyDepositPin()+"\n\n");
	}
	

}

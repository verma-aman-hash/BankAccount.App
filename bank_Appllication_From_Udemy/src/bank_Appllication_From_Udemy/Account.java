package bank_Appllication_From_Udemy;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public abstract class Account implements InterestRate,customerActivity {
	
	static BinaryOperator<Double> deposit =(a,b)->a+b;
	static BinaryOperator<Double> withdraw = (a,b) -> a-b;
	static BiPredicate<Double, Double> isWithdrawPossible =(a,b)-> a>b;//accept 2 inputs returns boolean value
	static Consumer<Double> lowBalance = t -> System.out.println("Transaction Failed : Your balance is "+t);	
	
	//names,social security numbers,account type,and initial deposit
	public long accountCreationTime=System.currentTimeMillis();
	private String firstName;
	private String lastName;
	private long ssn;
	private double initialDeposit;
	private double finalBalance=initialDeposit;
	private String accountType;
	private String accountNumber="e32dexed234";
	private double compoundAmmount;
	double rate;
	
	
	public Account(String firstName, String lastName, long ssn, String accountType, double intialDeposit) throws InterruptedException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.accountType = accountType;
		this.initialDeposit = intialDeposit;
		this.finalBalance=intialDeposit;
		this.setAccountNumber(ssn, accountType);
		this.setInterestRate();
		Thread.sleep((int)(Math.random()*Math.pow(10, 1)));
		this.compound();
		}
	
	private String setAccountNumber(long ssn,String accountType) {
		
//		11-digit Account Number (generated with the following process:)
//		1 or 2 depending on savings or checking.
//		last 2 digit of SSN
//		unique 5-digit number
//		and random 3-digit number
		String ssn2=String.valueOf(ssn);
		String last2ofSSN =ssn2.substring(ssn2.length()-2).strip();
		int random3 = ThreadLocalRandom.current().nextInt(100,999);
		int unique5 =ThreadLocalRandom.current().nextInt(10000,99999);
		return accountNumber=last2ofSSN+unique5+random3;
		
		
	}
	public abstract double setInterestRate();
	
	public double compound() {
		long compoundTime=System.currentTimeMillis()-accountCreationTime;
		compoundAmmount = finalBalance*rate/100*compoundTime;
		finalBalance=finalBalance+compoundAmmount;
		
		
		return finalBalance;
		
	}
	
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
		
		
	}
	public double getIntialDeposit() {
		return initialDeposit;
	}
	public void setIntialDeposit(double intialDeposit) {
		this.initialDeposit = intialDeposit;
	}
	
	
	public double getFinalBalance() {
		return finalBalance;
	}
	public void setFinalBalance(double finalBalance) {
		this.finalBalance = finalBalance;
	}
	
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	protected void setAccountNumberbyType(int accountType) {
		this.accountNumber = accountType+accountNumber;
	}
	@Override
	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", intialDeposit="
				+ initialDeposit + ", finalBalance=" + finalBalance + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + "]";
	}
	
	
	
	@Override
	public void deposit(Account account,Double ammount) {
		
		account.setFinalBalance(deposit.apply(account.getFinalBalance(), ammount).doubleValue());
		System.out.println("HI "+account.getFirstName()+" your Account "+account.accountNumber+" is creditd with amount :$"+ammount);
		System.out.println("Transaction Sucessfull");
		System.out.println("Balance after Deposit :"+finalBalance);
		
		}
	
	@Override
	public void withdraw(Account account,Double ammount) {
		if(isWithdrawPossible.test(account.getFinalBalance(), ammount)) {
			 account.setFinalBalance(withdraw.apply(account.getFinalBalance(), ammount).doubleValue());
			 	System.out.println("HI "+account.getFirstName()+" your Account "+account.accountNumber+" is debited with amount :$"+ammount);
				System.out.println("Transaction Sucessfull");
				System.out.println("Balance after Deposit :"+finalBalance);
		}
		else {
			lowBalance.accept(account.getFinalBalance());
		}}

	@Override
	public void transfer(Account senderAccount, Account reciverAccount, Double ammount) {
		senderAccount.setFinalBalance(withdraw.apply(senderAccount.getFinalBalance(), ammount).doubleValue());
		if(isWithdrawPossible.test(senderAccount.getFinalBalance(), ammount)) {
		reciverAccount.setFinalBalance(deposit.apply(reciverAccount.getFinalBalance(), ammount).doubleValue());
			System.out.println("Hi "+reciverAccount.getFirstName()+" Transfer of Amount Recived: $"+ammount+" from " +senderAccount.getFirstName());
			System.out.println(reciverAccount.getFirstName()+" your available balance is $:"+reciverAccount.getFinalBalance());
			System.out.println(senderAccount.getFirstName()+" your available balance is $:"+senderAccount.getFinalBalance());

		}
		else {
			System.out.println("Transfer from "+senderAccount.getFirstName()+" with Account :"+senderAccount.accountNumber+" got failed.");
			System.out.println(senderAccount.getFirstName()+" your available balance is $:"+senderAccount.getFinalBalance());
			System.out.println(reciverAccount.getFirstName()+" your available balance is $:"+reciverAccount.getFinalBalance());
		}}
	@Override
	public void showInfo() {
		
		System.out.println("\t\tACCOUNT NUMBER :"+accountNumber
							+"\t\tNAME : "+firstName+" "+lastName
							+"\t\t\t\tInitial Balance :"+initialDeposit
							+"\n\t\t\t\tSocil Security No :"+ssn
							+"\t\tINTEREST RATE :" +rate+"%"
							+"\t\t\t\tCOMPOUND AMOUNT :"+compoundAmmount
							);
	}
	

}

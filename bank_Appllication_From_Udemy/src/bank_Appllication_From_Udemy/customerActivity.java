package bank_Appllication_From_Udemy;

public interface customerActivity {
	//Both saving and checking accounts share the following properties:
//	deposit()
//	withdraw()
//	transfer()
//	showInfo()
	/**
	 * public void deposit(Account account,Double ammount) {
		
		account.setFinalBalance(deposit.apply(account.getFinalBalance(), ammount).doubleValue());
		
		}
	
	@Override
	public void withdraw(Account account,Double ammount) {
		if(isWithdrawPossible.test(account.getFinalBalance(), ammount))
			 account.setFinalBalance(withdraw.apply(account.getFinalBalance(), ammount).doubleValue());
		else
			lowBalance.accept(account.getFinalBalance());
		}

	@Override
	public void transfer(Account senderAccount, Account reciverAccount, Double ammount) {
		withdraw.apply(senderAccount.getFinalBalance(), ammount);
		if(isWithdrawPossible.test(senderAccount.getFinalBalance(), ammount))
		deposit.apply(reciverAccount.getFinalBalance(), ammount);
		else
			System.out.println("Transfer not possible");
		}
	
	 */
public void deposit(Account account,Double ammount);
public void withdraw(Account account,Double ammount);
public void transfer(Account senderAccount, Account reciverAccount, Double ammount);
public void showInfo();

}

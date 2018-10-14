/**
 * @author Mark Goldstein
 */

import java.util.ArrayList;

public class Bank {
	private final int MAX_NUM = 50;
	private  ArrayList <BankAccount> bankAccList ;
	private String bankName ;

	//Default constructor for creating bank account
	public Bank()
	{
		bankName = "E Corp";
		bankAccList = new ArrayList<>();
	}
	/*
	 * Method openNewAccount():
	 * Input: BankAccount object
	 * Process: Assigns object passed to numAcct
	 * spot of bank account arry
	 * Output: Void
	 */
	public boolean openNewAccount( BankAccount bankAccount)
	{
		int index = findAcct(bankAccount);// Checks that account not in use
		if(index != -1) {
			bankAccList.add(bankAccount);
			System.out.print(" this is from open ");
			return true;
		} else {
			return false;

		}

	}
	/*
	 * Method findAcc():
	 * Input:requested account
	 * Process: linear search requested account.
	 * Output: index of account requested
	 */
	private int findAcct( BankAccount  bankAccount)
	{

		for (int index = 0; index < bankAccList.size(); index++)
			if (bankAccList.get(index).getAccNum() == bankAccount.getAccNum()) {
				System.out.print("from FIND");
				return index;// returns index
			}

		return -1;
	}

	/**
	 * Method for find acct when account number 
	 * @param index
	 * @return
	 */
	private int findAcct( int  accNum)
	{
		for (int i = 0; i < bankAccList.size(); i++) {
//			System.out.println(bankAccList.get(i).getAccNum());
//			System.out.println(accNum);
			if (bankAccList.get(i).getAccNum() == accNum ) {
				
				return i;// returns index
			}
			
		}
		return -1;
	}




	private int findAcctSSN(String social )
	{

		if(social.length() == 9) {
			for (int index = 0; index < bankAccList.size(); index++) {
				if (bankAccList.get(index).getAccDet().
						getSocSec().equals(social)) {
					return index;
				}
			}
			return -1;
			//flag for no account found

		}
		else
		{
			//flag for invalid length
			return -2;
		}
	}
	/*
	 * Method openNewAccount():
	 * Input: Parameters for making a new account
	 * with attributes being read in ie from a file or keyboard.
	 * Process: Makes new account in bankAcct array,
	 *  at numAccts spot, uses setter methods
	 * to set the details. Nested classes are used
	 * and passed to successfully do this.
	 * Output:
	 */
//		public void openNewAccount( int reqAcc, int accountNum,
//				double accBal, String first,
//				String last, String socSec, String type)
//		{
//			//		int index = findAcct(reqAcc);// Checks that account not in use
//			//		if(index === -1) {
//				bankAcc.add(arg0)
//			}
//			bankAcc = new BankAccount[numAccts];
//			bankAcc[numAccts].setAccNum(accountNum);
//			bankAcc[numAccts].setAccType(type);
//			bankAcc[numAccts].setAccBal(accBal);
//			bankAcc[numAccts].setAccDet(first,last, socSec);
//	//		numAccts++;
//		}


	public boolean openNewAccount( int accNum, BankAccount bankAcc)
	{
		int index = findAcct(accNum);// Checks that account not in use
		if(index == -1) {
						bankAccList.add(bankAcc);
			return true;
		} else{
			return false;
			// numAccts++;
		}
	}

	/*
	 * Method deleteAcct():
	 * Input:  index of account to delete
	 * Process: Manipulates BankAccount object array
	 * to remove and replace the deleted account.
	 * Output: none
	 */
	public boolean deleteAcct(BankAccount bankAccount)
	{
		//Efficiently deletes account by cutting last account in array
		//and replacing the selected account found for deletion.
		int index = findAcct(bankAccount);
		if( index != 1 ){
			bankAccList.remove(index); 
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Method setAcctInfo():
	 * Input:Index of account, amount and if deposit.
	 * Process: Does deposits and withdrawals using boolean to distinguish
	 * if making a deposit, if not, subtracts the amount from acct bal and
	 * sets the account balance to that amount.
	 * Outout:None
	 */
	public void setAcctInfo( BankAccount bankAcct, boolean deposit)
	{


		int index = findAcct(bankAcct);
		bankAcct = bankAccList.get(index);
		if (deposit) {
			bankAccList.set(index, bankAcct);


			// WIll be sending a put together object to replace the
			//one that was at that index, effectivly editing the inf
		}
		else
		{
			bankAccList.set(index, bankAcct);
		}

	}


	public void setAcctInfo( int index, double amount, Bank bank, boolean deposit)
	{
		BankAccount bankAcc = new BankAccount( bank.getAcct(index).getAccDet().getNameOnAcc().getFirst(), 
				bank.getAcct(index).getAccDet().getNameOnAcc().getLast(), 
				bank.getAcct(index).getAccDet().getSocSec(),
				bank.getAcct(index).getAccNum(), 
				bank.getAcct(index).getAccType(),
				bank.getAcct(index).getAccBal());
		int accNum = findAcct(index);
		if (deposit) {


			bank.getAcct(index).setAccBal((bank.getAcct(index).getAccBal()) + amount);

		} else {

			bank.getAcct(index).setAccBal((bank.getAcct(index).getAccBal()) - amount);


		}

	}


	//	public BankAccount getAcct(int acct)
	//	{
	////		BankAccount bankAcc = new BankAccount( bank.getAcct(index).getAccDet().getNameOnAcc().getFirst(), 
	////				bank.getAcct(index).getAccDet().getNameOnAcc().getLast(), 
	////				bank.getAcct(index).getAccDet().getSocSec(),
	////				bank.getAcct(index).getAccNum(), 
	////				bank.getAcct(index).getAccType(),
	////				bank.getAcct(index).getAccBal());
	//		int index = findAcct(acct);
	//		return bankAccList.get(index);
	//	}


	//Getter for account object
	//	public BankAccount getAcct(int acct, boolean accNum)
	//	{
	//		int index = findAcct(acct);
	//		return bankAccList.get(index);
	//	}
	//Getter for account object
	public  BankAccount getAcct(int accNum)
	{
		int index = findAcct(accNum);
		System.out.println(index);
		System.out.println(bankAccList.size());
		return bankAccList.get(index);
	}

	public  BankAccount getAcct(String social)
	{
		int index = findAcctSSN(social);
		System.out.println(index);
		System.out.println(bankAccList.size());
		return bankAccList.get(index);
	}


	public int getNumAcc() {
		return bankAccList.size();
	}




}

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
//	public boolean openNewAccount( BankAccount bankAccount)
//	{
//		int index = findAcct(bankAccount);// Checks that account not in use
//		if(index != -1) {
//			bankAccList.add(bankAccount);
//			System.out.print(" this is from open ");
//			return true;
//		} else {
//			return false;
//
//		}
//
//	}
	/*
	 * Method findAcc():
	 * Input:requested account object
	 * Process: linear search requested account.
	 * Output: index of account requested
	 */
	public int findAcct( BankAccount  bankAccount)
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
	public int findAcct(int accNum)
	{
		for (int i = 0; i < bankAccList.size(); i++) {
//			System.out.println(bankAccList.get(i).getAccNum());
//			System.out.println(accNum);
			if (bankAccList.get(i).getAccNum() == accNum ) {
				System.out.println(bankAccList.get(i).getAccNum());
				return i;// returns index
			}
			
		}
		return -1;
	}



	public int findAcctSSN(String social )
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
	public boolean deleteAcct(int index )
	{
		//Efficiently deletes account by cutting last account in array
		//and replacing the selected account found for deletion.
//		int index = findAcct(bankAccount);
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
	public void setAcct( BankAccount bankAcct, boolean deposit)
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

		public BankAccount getAcct(int index)
		{			
			return bankAccList.get(index);
		}

	public  BankAccount getAcct(String social)
	{
		int index = findAcctSSN(social) ;
		System.out.println(index);
		System.out.println(bankAccList.size());
		return bankAccList.get(index);
	}


	public int getNumAcc() {
		return bankAccList.size();
	}

}

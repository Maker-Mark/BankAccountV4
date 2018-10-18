/**
 * @author Mark Goldstein
 */
import java.util.ArrayList;

public class BankAccount {
	//data members of BankAccount object
	private Depositor accDet = new Depositor();
	private int accNum;
	private String accType;
	private String status  = "open";
	private double accBal;
	private ArrayList<Transaction> trans = new ArrayList<>()  ;

	//Default constructor
	public BankAccount()
	{
		accDet = new Depositor();
		accNum = 0;
		accType = "none";
		accBal = 0.00;
		status  = "Open";
		Transaction transaction = new Transaction (accNum, "Default", accBal);

		trans.add(transaction);
	}

	//Constructor for initializing object with values
	public BankAccount(String first, String last, String social,int accountNum,
			String type, double bal)
	{
		accNum = accountNum;
		accType = type;
		accBal= bal;
		accDet = new Depositor(first, last, social);
		first = accDet.getNameOnAcc().getFirst();
		last = accDet.getNameOnAcc().getLast();
		social= accDet.getSocSec();
		status  = "Open";
		Transaction transaction = new Transaction (accountNum, "Open Account", bal);

		trans.add(transaction);

	}
	public void makeDeposit(int accNumber, int index, double amount) {
		accBal += amount;
		Transaction transaction = new Transaction( accNumber, "Deposit", amount);
		trans.add(transaction);//Adding trans with associated index
		System.out.println("SIZE IS NOW" + trans.size());
	}

	public boolean makeWithdrawal(int accNumber, double amt) {
		if( amt >= 0) {
			accBal -= amt;
			Transaction transaction = new Transaction(accNumber, "Withdrawal", amt);
			trans.add(transaction);

			return true;
		}else {
			return false; // message for less than
		}
	}
	//return array
	public  ArrayList<Transaction>  getTransactions(BankAccount bankAcc, int accNum)
	{

	//
	// 	for(int i = 1; i < trans.size(); i++ ) {
	// 	if (trans.get(i).getTransAcc() == accNum)
	// 		theseTrans.add(trans.get(i));
	// }

//		transaction = trans.get(index);
		return trans ;
	}


	public void addTransaction(BankAccount bankAcc, String type, double amount) {
		int index = bankAcc.getAccNum();
		Transaction transaction = new Transaction (bankAcc.getAccNum(), type, amount);
		trans.add( transaction);
		//				System.out.println("SIZE IS NOW" + trans.size());
	}
	
	public void addTransaction(BankAccount bankAcc, String type) {
		int index = bankAcc.getAccNum();
		Transaction transaction = new Transaction (bankAcc.getAccNum(), type);
		trans.add( transaction);
		//				System.out.println("SIZE IS NOW" + trans.size());
	}

	//Method for setting data member accDet,
	//which is of Depositor-object type
	public  void setAccDet(String first, String last, String social)
	{
		accDet.setNameOnAcc(first, last);
		accDet.setSocSec(social);
	}



	public  boolean closeAcct(int index) {

		//				 index = bank.findAcct(bank.findAcct(index));
		// Checks that account not in use
		if(index != -1) {
			status  = "Closed";

			return true;
		}
		return false;
	}

	public  void reOpenAcct(BankAccount bankAcc) {

		//				 int index = bankAcc.getAccNum();
		//				// Checks that account not in use
		//				if(index != -1) {
		status  = "Open";		//				return true;
	}

	//Setters and getters for rest of data members
	public void setAccNum(int n)
	{
		accNum = n;
	}

	public void setAccType(String type)
	{
		accType = type;
	}

	public void setAccBal(double bal)
	{
		accBal = bal;
	}

	public double getAccBal()
	{

		return accBal;
	}


	public String getAccType()
	{
		return accType;
	}

	public int getAccNum()
	{
		return accNum;
	}
	//Gets account deopositor
	public Depositor getAccDet()
	{
		return accDet;
	}

	public int getNumTrans() {
		return trans.size();
	}
	public String getStatus() {
		return status;
	}

}

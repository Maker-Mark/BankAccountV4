/**
 * @author Mark Goldstein
 */
import java.util.ArrayList;

public class BankAccount {
	//data members of BankAccount object
	private Depositor accDet = new Depositor();
	private int accNum;
	private String accType;
	private boolean closed = false;
	private double accBal;
	private ArrayList<Transaction> trans = new ArrayList<Transaction>()  ; 

	//Default constructor
	public BankAccount()
	{
		accDet = new Depositor();
		accNum = 0;
		accType = "none";
		accBal = 0.00;
		closed = false;
		
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
		closed = false;
		Transaction transaction = new Transaction (accountNum, "Open Account", bal);

		trans.add(transaction);
			
		}
		
	
	
	//return array
	public  ArrayList<Transaction>  getTransactions(int index, BankAccount bankAcc) 
	{
		
		return trans;
	}


	public void addTransaction(BankAccount bankAcc, String type, double amount) {
				int index = bankAcc.getAccNum();
				Transaction transaction = new Transaction (bankAcc.getAccNum(), type, amount);
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
	
	public void makeDeposit(int accNum, int index, double amount) {
		accBal += amount;
		Transaction transaction = new Transaction( accNum, "deposit", amount);
		trans.add( transaction);//Adding trans with associated index
		System.out.println("SIZE IS NOW" + trans.size());
		
		
		
	}

	public boolean makeWithdrawal(int index, double amt) {
		if( amt >= 0) {
			accBal -= amt;
			
			
			Transaction transaction = new Transaction( accNum, "withdrawal", amt);
			trans.add( transaction);
			
			return true;
		}else {
			return false; // message for less than 
		}
	}
	
	

	public  boolean closeAcct(int index) {

		//				 index = bank.findAcct(bank.findAcct(index)); 
		// Checks that account not in use
		if(index != -1) {
			closed = true;
			

			return true;
		}
		return false;
	}

	public  void reOpenAcct(BankAccount bankAcc) {

		//				 int index = bankAcc.getAccNum(); 
		//				// Checks that account not in use
		//				if(index != -1) {
		closed = false;
		//				return true;
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

	public Depositor getAccDet() 
	{
		return accDet;
	}


}

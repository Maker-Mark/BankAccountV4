
public class Transaction {
	private int accNum;
		private String type;
		private double amount;
		

	public Transaction() {
		type = "one";
		amount = 0.00;
	}
	public Transaction(int accountNum, String typeGiven, double amt) {
		accNum = accountNum;
		type = typeGiven;
		amount = amt;
	}
	
	
	
	public void setTransType(String givenType) {
		type = givenType;
	}
	public String getTransType() {
		
		return type;
	}
	
	public void setTransAmt(double transAmt) {
		amount = transAmt;
	}
	public double getTransAmt() 
	{
	return amount;
	}
	
	
}

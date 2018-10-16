
public class Transaction {
		private String type;
		private double amount;
		

	public Transaction() {
		type = "one";
		amount = 0.00;
	}
	public Transaction(String typeGiven, double amt) {
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

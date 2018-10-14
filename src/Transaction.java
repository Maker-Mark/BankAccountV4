
public class Transaction {
		private String type;
		private double amount;
		
	Transaction transaction = new Transaction();
	
	
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


public class SavingsAccount {

	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double balance) {
		this.savingsBalance = balance;
	} 
	
	public void calculateMonthlyInterest() {
		this.savingsBalance += this.savingsBalance*(double)this.annualInterestRate/(double)12;		
	}
	
	public void modifyInterestRate(double rate) {
		this.annualInterestRate = rate/100;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}

}

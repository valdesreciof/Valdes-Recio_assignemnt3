import java.text.DecimalFormat;

public class SavingsAccountTest {

	public static void main(String[] args) {
		
		SavingsAccount saver1= new SavingsAccount(2000);
		SavingsAccount saver2= new SavingsAccount(3000);
		saver1.modifyInterestRate(4);
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("\tMonth\t\tSaver1\t\t\tBalance");
		for(int i = 1; i <= 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.println("\t"+i+"\t\t$"+df.format(saver1.getSavingsBalance())+"\t\t$"+df.format(saver2.getSavingsBalance()));
		}
		
		saver1.modifyInterestRate(5);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.println("\t13"+"\t\t$"+df.format(saver1.getSavingsBalance())+"\t\t$"+df.format(saver2.getSavingsBalance()));
	}

}

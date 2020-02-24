import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		int answer = askQuestion();
		int response = readResponse();
		while(!isAnswerCorrect(response, answer)) {
			displayInorrectResponse();	
			response = readResponse();
		}
		displayCorrectResponse();					
	}

	private static int askQuestion(){
		SecureRandom random = new SecureRandom();
		int firstInt = random.nextInt(10);
		int secondInt = random.nextInt(10);
		System.out.println("How much is " + firstInt + " times " + secondInt + " ?");
		return firstInt*secondInt;
		
	}
	private static int readResponse(){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		return input;		
	}
	
	private static boolean isAnswerCorrect(int response, int answer) {
		if(response==answer) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	private static void displayInorrectResponse() {	
		SecureRandom random = new SecureRandom();
		int response = random.nextInt(4)+1;
		switch(response){
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don’t give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}		
	}

	private static void displayCorrectResponse() {
		SecureRandom random = new SecureRandom();
		int response = random.nextInt(4)+1;
		switch(response){
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}		
	}
}

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

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
		System.out.println("No. Please try again.");
	}

	private static void displayCorrectResponse() {
		System.out.println("Very good!");		
	}
	
}

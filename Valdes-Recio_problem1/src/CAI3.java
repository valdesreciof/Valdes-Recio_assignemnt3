import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {	
		int answer, response;
		double grade;
		do{
			grade = 0;
			for(int i = 0; i < 10; i++) {
				answer = askQuestion();
				response = readResponse();
				if(!isAnswerCorrect(response, answer)) {
					grade += displayInorrectResponse();	
				}
				else {
					grade += displayCorrectResponse();	
				}
			}
			displayCompleteResponse(grade);
		}while(newQuiz()==1);
	}
	
	private static int newQuiz(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to start a new quiz? Enter 1 for yes and 2 for no.");
		int input = scan.nextInt();
		return input;		
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
	
	private static int displayInorrectResponse() {	
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
		return 0;
	}

	private static int displayCorrectResponse() {
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
		return 1;
	}
	
	private static void displayCompleteResponse(double grade) {
		grade = grade/((double)10)*100;
		System.out.println("you scored a " + grade +"%");
		if(grade< ( (double)7.5 / (double)10 ) * 100 ) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!");
			
		}
	}
}

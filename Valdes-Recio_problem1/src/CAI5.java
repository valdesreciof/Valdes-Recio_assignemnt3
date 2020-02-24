import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {	
		int answer,response,dificulty,type;
		double grade;
		do {
			grade = 0;
			dificulty = readDifficulty();
			type = readProblemType();
			for(int i = 0; i < 10; i++) {
				answer = askQuestion(dificulty,type);
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
	
	private static int readDifficulty(){
		Scanner scan1 = new Scanner(System.in);
		int dificulty = 1;
		System.out.println("Enter a difficulty level of 1, 2, 3, or 4.");		
		dificulty = scan1.nextInt();
		return dificulty;
	}

	private static int readProblemType(){
		Scanner scan2 = new Scanner(System.in);
		int type = 1;
		System.out.println("Enter 1 for additon, 2 for multiplication, 3 for subtraction, or 4 for random.");		
		type = scan2.nextInt();
		return type;	
	}

	private static int askQuestion(int dificulty, int type){
		int _type;		
		SecureRandom random = new SecureRandom();
		int firstInt = random.nextInt((int)Math.pow(10,dificulty));
		int secondInt = random.nextInt((int)Math.pow(10,dificulty));
		if (type != 4) {
			_type = type;
		}
		else {
			_type = random.nextInt(3)+1;
		}
		switch(_type) {
		case 1:
			System.out.println("How much is " + firstInt + " plus " + secondInt + " ?");
			return firstInt+secondInt;
		case 2:
			System.out.println("How much is " + firstInt + " times " + secondInt + " ?");
			return firstInt*secondInt;
		case 3:
			System.out.println("How much is " + firstInt + " minus " + secondInt + " ?");
			return firstInt-secondInt;
		case 4:
			System.out.println("How much is " + firstInt + " divided by " + secondInt + " ?");
			return firstInt/secondInt;
		}
		return -1;		
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
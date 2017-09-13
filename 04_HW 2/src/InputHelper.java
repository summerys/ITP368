
import java.util.Scanner;

public class InputHelper {
	public String readString(String promptToPrint) {
		Scanner sc = new Scanner(System.in);
		System.out.println(promptToPrint);
		String s = sc.nextLine();
		return s;
	}
	
	public int readPositiveInt(String prompt, int max) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		
		while(!isValid){
			if(sc.hasNextInt()){
				num = sc.nextInt();
				if(num > 0 && num <= max){
					isValid = true;
				}
				else{
					System.out.println("Invalid command. Please enter an integer between 1 and " + max +".");
					isValid = false;
				}
			}
			else{
				String garbage = sc.nextLine(); 
				System.out.println("Invalid command. Please enter an integer between 1 and " + max +".");
			}
		}
	
		return num;
	}
}

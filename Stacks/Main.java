package Stacks;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Create new stack
		Stack s = new Stack(100);
		String test = "((asdghashdjalsdh(asldjifaf)jlksafaskh(klhsuifh))";
		Scanner sc = new Scanner(System.in);
		String input = "";
		do {
			try {
				System.out.println("Bitte geben sie ein");
				input = sc.nextLine();
			}catch(java.util.InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			for(int i = 0; i < input.length(); i++) {
				s.push(input.charAt(i));
			}
			System.out.println(s.checkInput());
		}while(true);
		
		
	}
}

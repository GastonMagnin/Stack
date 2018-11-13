package Stacks;

public class Stack {
	private int size = 1000;
	private static char[] elements;
	public Stack(int size) {
		elements = new char[size];
	}
	private int stackPointer = 0;
	private void setPush(char c) {
		elements[stackPointer++] = c;
	}
	public void push(char c) {
		setPush(c);
	}
	public void push(String s) {
		for(int i = 0; i < s.length(); i++) {
			setPush(s.charAt(i));
		}
	}
	public char pop() {
		
		return (stackPointer > 0) ? elements[--stackPointer] : '\u0000';
	}
	public int getlength() {
		return stackPointer;
	}
	public String checkInput() {
		String brackets = "";
		int position = stackPointer;
		String error;
		char currentChar;
		char nextOpen = '\u0000';
		char[] brackOpen = new char[] {'(',  '[',  '{', '<' };
		char[] brackClose = new char[] {')', ']', '}', '>'};
		while((currentChar = pop()) != '\u0000') {
			System.out.println(position + " " + currentChar);
			position--;
			for(int i = 0; i < brackOpen.length; i++) {
				if(currentChar == brackClose[i]) {
					brackets += brackOpen[i];
					nextOpen = brackOpen[i]; 
					
					i = brackOpen.length;
				}else if(currentChar == brackOpen[i]) {
					System.out.println(currentChar);
					if(currentChar == nextOpen) {
						
						brackets = brackets.substring(0, brackets.length()-1);
						
						
						nextOpen = (brackets.length() > 0) ? brackets.charAt(brackets.length() - 1) : '\u0000';
						
					}else {
						if(nextOpen != '\u0000') {
							error = "Error on '" + currentChar + "' at " + position + " expected '" + nextOpen +"'";
						}else {
							error = "Error on '" + currentChar + "' at " + position;
						}
						
						return error;
					}
				i = brackOpen.length;
				}
			}
		}
		
		return "no error";
	}
		
	
}

package Stacks;
/**
 * 
 * @author GastonMagnin
 *
 */
public class Stack {
	private static char[] elements;
	public Stack(int size) {
		elements = new char[size];
	}
	private int stackPointer = 0;
	private void setPush(char c) {
		elements[stackPointer++] = c;
	}
	//overloaded public version of push
	public void push(char c) {
		setPush(c);
	}
	//overloaded public version of push
	public void push(String s) {
		for(int i = 0; i < s.length(); i++) {
			setPush(s.charAt(i));
		}
	}
	//get stack top element by decrementing stack pointer and return it
	public char pop() {
		return (stackPointer > 0) ? elements[--stackPointer] : '\u0000';
	}
	//get current length
	public int getlength() {
		return stackPointer;
	}
	//Check if brackets are correct
	public String checkInput() {
		// save all closed brackets that haven't been opened yet
		String brackets = "";
		//Initialize position variable with current position
		int position = stackPointer;
		/**
		 * @param error container for error message if needed
		 * @param currentChar the character that is currently being checked
		 * @param nextOpen  the type of bracket that has to be opened next according to the last bracket closed
		 * @param brackOpen all types of opening brackets
		 * @param brackClose all types of closing brackets
		 */
		String error;
		char currentChar;
		char nextOpen = '\u0000';
		char[] brackOpen = new char[] {'(',  '[',  '{', '<' };
		char[] brackClose = new char[] {')', ']', '}', '>'};
		//repeat while there are elements left in the stack
		while((currentChar = pop()) != '\u0000') {
			//decrement position to represent current position
			position--;
			//check if the current character is a bracket by comparing to all types of brackets
			for(int i = 0; i < brackOpen.length; i++) {
				//if the bracket is a closing bracket 
				if(currentChar == brackClose[i]) {
					//add the corresponding opening bracket to the bracktes string
					brackets += brackOpen[i];
					//update the next Open 
					nextOpen = brackOpen[i]; 
					//stop loop
					i = brackOpen.length;
				//if the current char is a opening bracket
				}else if(currentChar == brackOpen[i]) {
					//check if the current char is the corresponding opening bracket for the last closed bracket
					if(currentChar == nextOpen) {
						//update the remaining closed brackets String 
						brackets = brackets.substring(0, brackets.length()-1);
						//update the next Open
						nextOpen = (brackets.length() > 0) ? brackets.charAt(brackets.length() - 1) : '\u0000';
					
					}else {
						//if the current char is a different bracket than the last closed bracket return error
						if(nextOpen != '\u0000') {
							//if there is a closed bracket that should have been opened before return corresponding error
							error = "Error on '" + currentChar + "' at " + position + " expected '" + nextOpen +"'";
						}else {
							//if there is no closed bracket for this opening bracket return corresponding error
							error = "Error on '" + currentChar + "' at " + position + " '" + currentChar + "' is opened but never closed";
						}
						
						return error;
					}
				//stop loop
				i = brackOpen.length;
				}
			}
		}
		//if a bracket is closed but never opened return error
		if(brackets.length() > 0) {
			error = "Error : Missing " + nextOpen;
			return error;
		}
		//if there is no error return no error
		return "no error";
	}
		
	
}

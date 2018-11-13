package Stacks;

public class Main {
	public static void main(String[] args) {
		Stack s = new Stack(100);
		String test = "ᕙ(˵ ಠ ਊ ಠ ˵)ᕗ";
		for(int i = 0; i < test.length(); i++) {
			s.push(test.charAt(i));
		}
		System.out.println(s.checkInput());
	}
}

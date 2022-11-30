import java.util.List;
import java.util.Stack;

public class Bracket {

	public static boolean check(String input) {
		int size = input.length();
		Stack<Character> stack = new Stack<Character>();

		boolean endFlag = true; // 모든 문자 검사 여부
		boolean result = false; // 짝 검사 결과

		for (int i = 0; i < size; i++) {
			char c = input.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (!stack.isEmpty() && c == ')') {
				stack.pop();
			} else {
				endFlag = false;
				break;
			}
		}
		if (endFlag && stack.empty()) {
			result = true;
		}

		return result;
	}

	public static void main(String[] args) {

		String input1 = "()()((()))";
		String input2 = "((()((((()()((()())((())))))";

		System.out.println(check(input1));
		System.out.println(check(input2));

	}

}

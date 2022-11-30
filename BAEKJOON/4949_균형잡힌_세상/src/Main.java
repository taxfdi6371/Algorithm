import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		while (true) {
			String str = br.readLine();

			// 입력 받은 문자열이 "." 이라면 종료
			if (str.equals(".")) {
				break;
			}

			// 괄호를 검사할 스택
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				// 여는 괄호는 무조건 스택에 담는다.
				if (c == '(' || c == '[') {
					stack.push(c);
					// 닫는 괄호는 스택의 top이 같은 모양의 여는 괄호여야지만 pop한다.
				} else if (c == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						// 스택의 top과 짝을 이루지 못하면 임의의 값인 . 을 넣어주고 검사를 종료한다.
						stack.push('.');
						break;
					}
				} else if (c == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push('.');
						break;
					}
				}
			}

			// 스택이 비어 있다면 (= 모든 괄호가 짝을 이루거나 괄호가 나오지 않았다면 ) yes 출력
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		System.out.println("( : " + ('(' + 0));
		System.out.println(") : " + (')' + 0));
		System.out.println("[ : " + ('[' + 0));
		System.out.println(" : " + (char)92);
		System.out.println("] : " + (']' + 0));

		br.close();
	}

}

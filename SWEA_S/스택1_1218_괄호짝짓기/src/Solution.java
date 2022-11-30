import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int size = sc.nextInt();

			String str = sc.next();

			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < size; i++) {
				char c = str.charAt(i);
				if (c == '[' || c == '{' || c == '(' || c == '<') {
					stack.push(c);
				} else if (!stack.isEmpty() && c == ']' || c == '}' || c == ')' || c == '>') {
					if (stack.peek() / 10 == c / 10) {
						stack.pop();
					} else {
						break;
					}
				}
			}
			if(stack.empty()) {
				System.out.println(1);
			} else {
				System.out.println(0);				
			}

		}
	}

}
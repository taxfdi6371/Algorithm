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
			int n = sc.nextInt(); // 문자의 총 수
			String pw = sc.next();

			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < n; i++) {
				char c = pw.charAt(i);
				if (stack.isEmpty()) {
					stack.push(c);
				} else if (!stack.isEmpty() && stack.peek() != c) {
					stack.push(c);
				} else if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				}
			}

			StringBuilder sb = new StringBuilder();

			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println(sb);

		}
	}

}
import java.util.LinkedList;
import java.util.Queue;
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
			int n = sc.nextInt(); // 길이
			String formula = sc.next();

			Stack<Character> stack = new Stack<Character>();

			Queue<Character> post = new LinkedList<>();

			// 후위식 변환
			for (int i = 0; i < n; i++) {
				char c = formula.charAt(i);
				switch (c) {
				case '+':
					if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() == '(')) {
						stack.push(c);
					} else {
						while (!stack.isEmpty() && stack.peek() != '(') {
							post.add(stack.pop());
						}
						stack.push(c);
					}
					break;
				case '*':
					if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != '*')) {
						stack.push(c);
					} else {
						while (!stack.isEmpty() && stack.peek() != '*') {
							post.add(stack.pop());
						}
						stack.push(c);
					}
					break;
				case '(':
					stack.push(c);
					break;
				case ')':
					while (!stack.isEmpty() && stack.peek() != '(') {
						post.add(stack.pop());
					}
					stack.pop();
					break;
				default:
					post.add(c);
					break;
				}
			}
			while (!stack.isEmpty()) {
				post.add(stack.pop());
			}

			Stack<Integer> stack2 = new Stack<Integer>();
			
			// 후위식 연산
			while (!post.isEmpty()) {
				if (post.peek() != '+' && post.peek() != '*') {
					stack2.push(post.poll() - '0');
				} else {
					int c1 = stack2.pop();
					int c2 = stack2.pop();
					int result = 0;
					if (post.peek() == '+') {
						result = c1 + c2;
					} else if (post.peek() == '*') {
						result = c1 * c2;
					}
					stack2.push(result);
					post.remove();
				}
			}
			System.out.println(stack2.pop());
		}
	}

}
import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	static int N; // 사용가능한 숫자 개수
	static int O; // 연산자 개수
	static int M; // 최대 연산 횟수
	static int W; // 원하는 숫자
	static boolean[] num;
	static boolean[] op;

	static int resultM; // 결과 연산 횟수

	static boolean touchNum() {
		boolean result = true;

		int len = Integer.toString(W).length();
		int[] WArr = new int[len];

		WArr[0] = W % 10;

		for (int i = 1; i < len; i++) {
			WArr[i] = W / (int) Math.pow(10, i);
		}

		for (int i = 0; i < len; i++) {
			if (!num[WArr[i]]) {
				result = false;
			}
		}

		if (result) {
			resultM = len;
		}

		return result;
	}

	static void touchExpr() {
		
	}

	static int calc(int num1, int num2, int op) {
		int result = 0;

		switch (op) {
		case 1:
			result = num1 + num2;
			break;
		case 2:
			result = num1 - num2;
			break;
		case 3:
			result = num1 * num2;
			break;
		case 4:
			result = num1 / num2;
			break;
		default:
			break;
		}
		
		return result;
	}

	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			num = new boolean[10]; // 0 ~ 9;
			op = new boolean[5]; // 빈 값, + , - , * , /

			N = sc.nextInt();
			O = sc.nextInt();
			M = sc.nextInt();

			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				num[n] = true;
			}
			for (int i = 0; i < O; i++) {
				int n = sc.nextInt();
				op[n] = true;
			}

			W = sc.nextInt();

			resultM = 0;

			// 직접 터치 불가능한 경우
			if (!touchNum()) {
				calc();
			}

			System.out.println("#" + test_case + " " + resultM);
		}
	}
}
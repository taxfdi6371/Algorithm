import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int sum = 0;

			// 증가하는 부분
			for (int i = 0; i < N - (N / 2); i++) {
				String s = sc.next();
				for (int j = N / 2 - i; j < N / 2 + i + 1; j++) {
					sum += s.charAt(j) - '0';
				}
			}

			// 감소하는 부분
			for (int i = N / 2 - 1; i >= 0; i--) {
				String s = sc.next();
				for (int j = N / 2 - i; j < N / 2 + i + 1; j++) {
					sum += s.charAt(j) - '0';
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}

}
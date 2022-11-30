import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int max;

	public static void func(int A) {
		String s = Integer.toString(A);

		boolean flag = true;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			max = Math.max(max, A);
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int A = arr[i] * arr[j];
					func(A);
				}
			}

			if (max == Integer.MIN_VALUE) {
				System.out.println("#" + test_case + " -1");
			} else {
				System.out.println("#" + test_case + " " + max);
			}
		}
	}

}
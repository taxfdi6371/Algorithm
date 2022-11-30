import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int[] busCnt = new int[5001];
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				for (int j = A; j < B + 1; j++) {
					busCnt[j]++;
				}
			}

			int P = sc.nextInt();

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < P; i++) {
				int C = sc.nextInt();
				System.out.print(busCnt[C] + " ");
			}
			System.out.println();

		}
	}

}
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
			int M = sc.nextInt();

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int fly = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							fly += map[i + k][j + l];
						}
					}
					max = Math.max(max, fly);
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

}
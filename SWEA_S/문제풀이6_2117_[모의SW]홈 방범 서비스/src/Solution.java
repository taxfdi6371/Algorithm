import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int N; // 도시의 크기
	public static int[][] home;
	public static int size; // 집 개수
	public static int M; // 하나의 집이 지불할 수 있는 비용

	public static int maxCnt;

	public static void func(int y, int x, int k) {
		// 수익
		int income = 0;
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			// 집이 운영 범위 내에 있을 때
			if (check(i, y, x, k)) {
				income += M;
				cnt++;
			}
		}

		// 수익에서 운영비용을 뺀다.
		income -= k * k + (k - 1) * (k - 1);

		if (income >= 0 && cnt > maxCnt) {
			maxCnt = cnt;
		}
	}

	public static boolean check(int idx, int y, int x, int k) {
		boolean result = false;
		int d = Math.abs(y - home[idx][0]) + Math.abs(x - home[idx][1]);
		if (d < k) {
			result = true;
		}
		return result;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			home = new int[N * N][2];
			size = 0;

			M = sc.nextInt();

			maxCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int a = sc.nextInt();
					// 집 좌표 저장
					if (a == 1) {
						home[size][0] = i;
						home[size][1] = j;
						size++;
					}
				}
			}

			for (int k = 1; k <= N + 1; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						func(i, j, k);
					}
				}
			}

			System.out.println("#" + test_case + " " + maxCnt);
		}
	}

}
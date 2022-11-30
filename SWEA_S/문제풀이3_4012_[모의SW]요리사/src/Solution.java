import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[][] grid;
	public static boolean[] visited;
	public static int N;

	public static int best;

	public static void func(int cnt, int idx) {
		if (cnt == N / 2) {
			int a = 0;
			int b = 0;

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) { // 선택 집합
						a += grid[i][j] + grid[j][i];
					} else if (!visited[i] && !visited[j]) { // 비선택 집합
						b += grid[i][j] + grid[j][i];
					}
				}
			}
			best = Math.min(best, Math.abs(a - b));
		} else {
			for (int i = idx; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					func(cnt + 1, i + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();

			grid = new int[N][N];
			visited = new boolean[N];

			best = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}

			func(0, 0);

			System.out.println("#" + test_case + " " + best);
		}
	}

}
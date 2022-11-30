import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int[][] map;
	public static int N;

	public static int[][] core;
	public static int size;

	public static int maxCore;
	public static int min;

	public static void func(int idx, int coreCnt, int sum) {
		if (idx == N && coreCnt >= maxCore) {

			return;
		}
		for (int i = idx; i < size; i++) {
			for (int j = 0; j < 4; j++) {
				int nY = core[size][0];
				int nX = core[size][1];
				boolean flag = false;

				// core에서 가장자리까지 검사
				while (nY != 0 && nY != N - 1 && nX != 0 && nX != N - 1) {
					nY += dy[i];
					nX += dx[i];
					if (map[nY][nX] == 1 || map[nY][nX] == 0) {
						flag = true;
						break;
					}
				}
				// 경로에 전선이나 core가 없었을 때
				if (!flag) {
					int cnt = 0;
					nY = core[size][0];
					nX = core[size][1];
					while (nY != 0 || nY != N - 1 || nX != 0 && nX != N - 1) {
						nY += dy[i];
						nX += dx[i];
						map[nY][nX] = 2;
						cnt++;
					}

					func(i + 1, coreCnt + 1, sum + cnt);
				}
			}
		}
	}

	public static boolean checkIdx(int y, int x) {

	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			map = new int[N][N];
			core = new int[12][2];
			size = 0;

			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						core[size][0] = i;
						core[size][1] = j;
						size++;
					}
				}
			}

			System.out.println("#" + test_case + " ");
		}
	}

}
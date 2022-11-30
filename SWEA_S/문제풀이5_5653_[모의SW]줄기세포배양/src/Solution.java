import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int[][] map; // 배양 상태
	public static int[][] cellInfo; // 세포 정보
	public static int[][] state; // 활성 상태
	public static boolean[][] fix;
	public static int N; // 세로 크기
	public static int M; // 가로 크기
	public static int K; // 배양 시간

	// 활성 상태 세포 배양
	public static void add(int y, int x, int k) {
		for (int i = 0; i < 4; i++) {
			int nY = y + dy[i];
			int nX = x + dx[i];
			// 다음 칸이 비어있거나, 세포로 채워져 있는데 자기보다 생명력 수치가 낮다면
			if (map[nY][nX] == 0 || (!fix[nY][nX] && map[nY][nX] > 0 && cellInfo[nY][nX] < cellInfo[y][x])) {
				map[nY][nX] = cellInfo[y][x] + k;
				cellInfo[nY][nX] = cellInfo[y][x];
			}
		}
	}

	// 배양된 세포 위치 고정
	public static void setFix() {
		fix = new boolean[500][500];
		for (int i = 250 - (N + K) / 2; i < 250 + (N + K) / 2; i++) {
			for (int j = 250 - (M + K) / 2; j < 250 + (M + K) / 2; j++) {
				if (map[i][j] > 0) {
					fix[i][j] = true;
				}
			}
		}
	}

	// 활성 상태 변경
	public static void setState(int k) {
		for (int i = 250 - (N + K) / 2; i < 250 + (N + K) / 2; i++) {
			for (int j = 250 - (M + K) / 2; j < 250 + (M + K) / 2; j++) {
				if (map[i][j] == k) {
					state[i][j] = cellInfo[i][j];
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

			map = new int[500][500];
			cellInfo = new int[500][500];
			state = new int[500][500];
			fix = new boolean[500][500];

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			for (int i = 250 - N / 2; i < 250 + N / 2 + (N % 2); i++) {
				for (int j = 250 - M / 2; j < 250 + M / 2 + (M % 2); j++) {
					map[i][j] = sc.nextInt();
					cellInfo[i][j] = map[i][j];
					fix[i][j] = true;
				}
			}
			// K = 5;
			for (int k = 1; k <= K; k++) {

				for (int i = 250 - (N + K) / 2; i < 250 + (N + K) / 2; i++) {
					for (int j = 250 - (M + K) / 2; j < 250 + (M + K) / 2; j++) {
						// 활성 상태 세포가 있으면
						if (state[i][j] > 0) {
							add(i, j, k);
							state[i][j]--;
						}
					}
				}

				setFix();
				setState(k);
			}
			/*
			 * System.out.println("------------map-------------"); for (int i = 250 - (N +
			 * K) / 2; i < 250 + (N + K) / 2; i++) { for (int j = 250 - (M + K) / 2; j < 250
			 * + (M + K) / 2; j++) { System.out.printf("%d", map[i][j]); }
			 * System.out.println(); } System.out.println("------------fix-------------");
			 * for (int i = 250 - (N + K) / 2; i < 250 + (N + K) / 2; i++) { for (int j =
			 * 250 - (M + K) / 2; j < 250 + (M + K) / 2; j++) { if(fix[i][j]) {
			 * System.out.print("T"); } else { System.out.print("F"); } }
			 * System.out.println(); }
			 * System.out.println("------------cellInfo-------------"); for (int i = 250 -
			 * (N + K) / 2; i < 250 + (N + K) / 2; i++) { for (int j = 250 - (M + K) / 2; j
			 * < 250 + (M + K) / 2; j++) { System.out.printf("%d", cellInfo[i][j]); }
			 * System.out.println(); } System.out.println("------------state-------------");
			 * for (int i = 250 - (N + K) / 2; i < 250 + (N + K) / 2; i++) { for (int j =
			 * 250 - (M + K) / 2; j < 250 + (M + K) / 2; j++) {
			 * 
			 * System.out.print(state[i][j]); } System.out.println(); }
			 */

			int cnt = 0;

			for (int i = 0; i < 500; i++) {
				for (int j = 0; j < 500; j++) {
					if (map[i][j] >= K || state[i][j] > 0) {
						cnt++;
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
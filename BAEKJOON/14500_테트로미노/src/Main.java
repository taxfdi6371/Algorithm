import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	public static int[][] block1_1 = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } };
//	public static int[][] block1_2 = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } };
//	public static int[][] block2 = { { 0, 0, 1, 1 }, { 0, 1, 0, 1 } };
//	public static int[][] block3_1 = { { 0, 1, 2, 2 }, { 0, 0, 0, 1 } };
//	public static int[][] block3_2 = { { 0, 0, 0, -1 }, { 0, 1, 2, 2 } };
//	public static int[][] block3_3 = { { 0, -1, -2, -2 }, { 0, 0, 0, -1 } };
//	public static int[][] block3_4 = { { 0, -1, -1, -1 }, { 0, 0, 1, 2 } };
//	public static int[][] block3_5 = { { 0, 0, -1, -2 }, { 0, 1, 1, 1 } };
//	public static int[][] block3_6 = { { 0, 0, 0, 1 }, { 0, 1, 2, 2 } };
//	public static int[][] block3_7 = { { 0, -1, -2, -2 }, { 0, 0, 0, 1 } };
//	public static int[][] block3_8 = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 } };
//	public static int[][] block4_1 = { { 0, 1, 1, 2 }, { 0, 0, 1, 1 } };
//	public static int[][] block4_2 = { { 0, 0, -1, -1 }, { 0, 1, 1, 2 } };
//	public static int[][] block4_3 = { { 0, -1, -1, -2 }, { 0, 0, 1, 1 } };
//	public static int[][] block4_4 = { { 0, 0, 1, 1 }, { 0, 1, 1, 2 } };
//	public static int[][] block5_1 = { { 0, 0, 0, 1 }, { 0, 1, 2, 1 } };
//	public static int[][] block5_2 = { { 0, 1, 2, 1 }, { 0, 0, 0, 1 } };
//	public static int[][] block5_3 = { { 0, 0, 0, -1 }, { 0, 1, 2, 1 } };
//	public static int[][] block5_4 = { { 0, 1, 2, 1 }, { 0, 0, 0, -1 } };
	
	// block[나올수 있는 종류][y,x][값]
	public static int[][][] block1 = { { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } } };
	public static int[][][] block2 = { { { 0, 0, 1, 1 }, { 0, 1, 0, 1 } } };
	public static int[][][] block3 = { { { 0, 1, 2, 2 }, { 0, 0, 0, 1 } }, { { 0, 0, 0, -1 }, { 0, 1, 2, 2 } },
			{ { 0, -1, -2, -2 }, { 0, 0, 0, -1 } }, { { 0, -1, -1, -1 }, { 0, 0, 1, 2 } },
			{ { 0, 0, -1, -2 }, { 0, 1, 1, 1 } }, { { 0, 0, 0, 1 }, { 0, 1, 2, 2 } },
			{ { 0, -1, -2, -2 }, { 0, 0, 0, 1 } }, { { 0, 1, 1, 1 }, { 0, 0, 1, 2 } } };
	public static int[][][] block4 = { { { 0, 1, 1, 2 }, { 0, 0, 1, 1 } }, { { 0, 0, -1, -1 }, { 0, 1, 1, 2 } },
			{ { 0, -1, -1, -2 }, { 0, 0, 1, 1 } }, { { 0, 0, 1, 1 }, { 0, 1, 1, 2 } } };
	public static int[][][] block5 = { { { 0, 0, 0, 1 }, { 0, 1, 2, 1 } }, { { 0, 1, 2, 1 }, { 0, 0, 0, 1 } },
			{ { 0, 0, 0, -1 }, { 0, 1, 2, 1 } }, { { 0, 1, 2, 1 }, { 0, 0, 0, -1 } } };

	public static int N; // 세로
	public static int M; // 가로
	public static int[][] map;
	public static int max;

	public static void run(int y, int x) {
		int j = 0;
		int sum = 0;
		for (int i = 0; i < block1.length; i++) {
			sum = 0; // 합을 0으로 초기화
			for (j = 0; j < 4; j++) {
				// 다음 좌표
				int nY = y + block1[i][0][j];
				int nX = x + block1[i][1][j];

				if (checkIdx(nY, nX)) {
					sum += map[nY][nX];
				} else {
					break;
				}
			}
			if (j == 4) {
				isMax(sum);
			}
		}

		for (int i = 0; i < block2.length; i++) {
			sum = 0; // 합을 0으로 초기화
			for (j = 0; j < 4; j++) {
				// 다음 좌표
				int nY = y + block2[i][0][j];
				int nX = x + block2[i][1][j];

				if (checkIdx(nY, nX)) {
					sum += map[nY][nX];
				} else {
					break;
				}
			}
			if (j == 4) {
				isMax(sum);
			}
		}

		for (int i = 0; i < block3.length; i++) {
			sum = 0; // 합을 0으로 초기화
			for (j = 0; j < 4; j++) {
				// 다음 좌표
				int nY = y + block3[i][0][j];
				int nX = x + block3[i][1][j];

				if (checkIdx(nY, nX)) {
					sum += map[nY][nX];
				} else {
					break;
				}
			}
			if (j == 4) {
				isMax(sum);
			}
		}

		for (int i = 0; i < block4.length; i++) {
			sum = 0; // 합을 0으로 초기화
			for (j = 0; j < 4; j++) {
				// 다음 좌표
				int nY = y + block4[i][0][j];
				int nX = x + block4[i][1][j];

				if (checkIdx(nY, nX)) {
					sum += map[nY][nX];
				} else {
					break;
				}
			}
			if (j == 4) {
				isMax(sum);
			}
		}

		for (int i = 0; i < block5.length; i++) {
			sum = 0; // 합을 0으로 초기화
			for (j = 0; j < 4; j++) {
				// 다음 좌표
				int nY = y + block5[i][0][j];
				int nX = x + block5[i][1][j];

				if (checkIdx(nY, nX)) {
					sum += map[nY][nX];
				} else {
					break;
				}
			}
			if (j == 4) {
				isMax(sum);
			}
		}
	}

	public static boolean checkIdx(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M) {
			return false;
		} else {
			return true;
		}
	}

	public static void isMax(int sum) {
		max = Math.max(max, sum);

	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				run(i, j);
			}
		}

		System.out.println(max);

		br.close();
	}

}

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int N; // 벌통들의 크기
	public static int M; // 선택할 수 있는 벌통의 개수
	public static int C; // 꿀을 채취할 수 있는 최대 양
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] selected; // 첫번째로 선택된 시작 좌표
	public static int[] result; // 최대 수익

	public static void func(int y, int x, int idx) {
		// 1개부터 M개까지 선택했을때 얻을 수 있는 최대 수익 계산
		for (int i = 1; i < (1 << M); i++) {
			int tempC = 0; // 선택된 양
			int tempR = 0; // 선택된 수익
			for (int j = 0; j < M; j++) {
				// 선택된 원소가 1이라면
				if ((i & (1 << j)) > 0) {
					tempC += map[y][x + j];
					// 선택된 양이 채취할 수 있는 양보다 많아지면
					if (tempC > C) {
						break;
					}
					tempR += map[y][x + j] * map[y][x + j];
				}
			}
			if (tempC <= C && tempR > result[idx]) {
				result[idx] = tempR;
				selected[0] = y;
				selected[1] = x;
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
			M = sc.nextInt();
			C = sc.nextInt();

			map = new int[N][N];
			visited = new boolean[N][N];

			selected = new int[2];
			result = new int[2];

			// 벌통 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 첫번째 벌통 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					func(i, j, 0);
				}
			}

			// 첫번째 벌통 방문 표시
			for (int i = 0; i < M; i++) {
				visited[selected[0]][selected[1] + i] = true;
			}

			// 두번째 벌통 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					if (!visited[i][j] && !visited[i][j + M - 1]) {
						func(i, j, 1);
					}
				}
			}

			System.out.println("#" + test_case + " " + (result[0] + result[1]));
		}
	}

}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dY = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 8방 탐색
	public static int[] dX = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int N;
	public static int[][] board;

	public static void check(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int nY = y + dY[i];
			int nX = x + dX[i];
			// 주변에 있는 상대 돌 탐색
			if (boundCheck(nY, nX) && board[nY][nX] != 0 && board[nY][nX] != board[y][x]) {
				int cnt = 0;
				boolean flag = false;
				while (boundCheck(nY, nX) && board[nY][nX] != 0) {
					cnt++;
					nY += dY[i];
					nX += dX[i];
					// 범위를 넘지 않으며, 자신의 돌을 찾았을 때
					if (boundCheck(nY, nX) && board[nY][nX] == board[y][x]) {
						flag = true;
						break;
					}
				}
				if (flag) {
					// 되돌아가며 바꿔줌
					while (cnt-- > 0) {
						nY -= dY[i];
						nX -= dX[i];
						board[nY][nX] = board[y][x];
					}
				}
			}
		}
	}

	public static boolean boundCheck(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			board = new int[N][N];

			board[N / 2 - 1][N / 2] = 1; // 흑돌 초기화
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2 - 1][N / 2 - 1] = 2; // 백돌 초기화
			board[N / 2][N / 2] = 2;

			int M = sc.nextInt();

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				board[y][x] = sc.nextInt(); // 돌 놓기
				check(y, x);
			}

			int bCnt = 0;
			int wCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						bCnt++;
					} else if (board[i][j] == 2) {
						wCnt++;
					}
				}
			}

			System.out.println("#" + test_case + " " + bCnt + " " + wCnt);
		}
	}

}
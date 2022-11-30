
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int N;
	public static int M;
	public static int L;

	public static int[][] map;
	public static boolean[][] visited;

	public static int cnt;

	static class Pos {
		int y;
		int x;
		int d;

		public Pos(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void bfs(int y, int x) {
		Pos pos = new Pos(y, x, 1);
		cnt++;
		visited[y][x] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(pos);

		while (!q.isEmpty()) {
			Pos cPos = q.poll();
			if (cPos.d == L) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nY = cPos.y + dy[i];
				int nX = cPos.x + dx[i];
				if (checkIdx(nY, nX) && !visited[nY][nX] && go(map[cPos.y][cPos.x], map[nY][nX], i)) {
					cnt++;
					visited[nY][nX] = true;
					Pos nPos = new Pos(nY, nX, cPos.d + 1);
					q.add(nPos);
				}

			}
		}
	}

	public static boolean checkIdx(int y, int x) {
		boolean result = false;
		if (y >= 0 && y < N && x >= 0 && x < M) {
			result = true;
		}
		return result;
	}

	// 현재 구조물 타입이 다음 좌표로 이동 가능한지 검사
	public static boolean go(int type, int next, int dIdx) {
		boolean result = false;

		switch (type) {
		case 1:
			if (dIdx == 0) {
				result = up(next);
			} else if (dIdx == 1) {
				result = right(next);
			} else if (dIdx == 2) {
				result = down(next);
			} else if (dIdx == 3) {
				result = left(next);
			}
			break;
		case 2:
			if (dIdx == 0) {
				result = up(next);
			} else if (dIdx == 2) {
				result = down(next);
			}
			break;
		case 3:
			if (dIdx == 1) {
				result = right(next);
			} else if (dIdx == 3) {
				result = left(next);
			}
			break;
		case 4:
			if (dIdx == 0) {
				result = up(next);
			} else if (dIdx == 1) {
				result = right(next);
			}
			break;
		case 5:
			if (dIdx == 1) {
				result = right(next);
			} else if (dIdx == 2) {
				result = down(next);
			}
			break;
		case 6:
			if (dIdx == 2) {
				result = down(next);
			} else if (dIdx == 3) {
				result = left(next);
			}
			break;
		case 7:
			if (dIdx == 0) {
				result = up(next);
			} else if (dIdx == 3) {
				result = left(next);
			}
			break;
		}
		return result;
	}

	// 다음 구조물이 연결 가능한지 검사
	public static boolean up(int next) {
		boolean result = false;
		if (next == 1 || next == 2 || next == 5 || next == 6) {
			result = true;
		}
		return result;
	}

	public static boolean right(int next) {
		boolean result = false;
		if (next == 1 || next == 3 || next == 6 || next == 7) {
			result = true;
		}
		return result;
	}

	public static boolean down(int next) {
		boolean result = false;
		if (next == 1 || next == 2 || next == 4 || next == 7) {
			result = true;
		}
		return result;
	}

	public static boolean left(int next) {
		boolean result = false;
		if (next == 1 || next == 3 || next == 4 || next == 5) {
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
			M = sc.nextInt();

			map = new int[N][M];
			visited = new boolean[N][M];

			int sY = sc.nextInt();
			int sX = sc.nextInt();
			L = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			cnt = 0;
			bfs(sY, sX);

			System.out.println("#" + test_case + " " + cnt);
		}
	}

}
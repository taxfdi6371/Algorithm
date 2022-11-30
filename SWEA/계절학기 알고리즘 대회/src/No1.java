import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int N; // 바다의 크기
	static int M; // 그물의 개수
	static int K; // 아기상어 체력

	static int[] posBaby;
	static int[] posMom;
	static int[][] net; // y, x, d, 강도

	static int result;

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		posBaby = new int[2];
		posMom = new int[2];
		net = new int[M][4];

		posBaby[0] = sc.nextInt();
		posBaby[1] = sc.nextInt();
		posMom[0] = sc.nextInt();
		posMom[1] = sc.nextInt();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				net[i][j] = sc.nextInt();
			}
		}

		result = -1;
	}

	static class Pos {
		int y;
		int x;
		int d; // 이동거리
		boolean[] rmNet;

		Pos(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	// 부분집합
	static boolean[][] makeSubset() {
		boolean[][] subset = new boolean[1 << M][M];

		for (int i = 0; i < (1 << M); i++) {
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) >= 1) {
					subset[i][j] = true;
				}
			}
		}

		return subset;
	}

	static void bfs(boolean[] subset) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][N + 1];

		// 시작과 동시에 그물에 걸렸는지 검사
		boolean flag = true;
		for (int j = 0; j < M; j++) {
			// 그물을 제거하지 않았고, 범위 내로 이동한다면,
			if (!subset[j] && (getDistance(posBaby[0], posBaby[1], net[j][0], net[j][1]) <= net[j][2])) {
				flag = false;
			}
		}
		if (flag) {
			q.add(new Pos(posBaby[0], posBaby[1], 0));
			visited[posBaby[0]][posBaby[1]] = true;
		}

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			int y = pos.y;
			int x = pos.x;
			int d = pos.d;

			if (result != -1 && d > result) {
				continue;
			}

			if (y == posMom[0] && x == posMom[1]) {
				if (result == -1) {
					result = d;
				} else {
					result = Math.min(result, d);
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nY = y + dy[i];
				int nX = x + dx[i];

				// 방문하지 않은 곳일 때
				if (checkIdx(nY, nX) && !visited[nY][nX]) {
					// 그물은 미리 제거했기 때문에 그물이 없어야 이동한다.
					flag = true;
					for (int j = 0; j < M; j++) {
						// 그물을 제거하지 않았고, 범위 내로 이동한다면,
						if (!subset[j] && (getDistance(nY, nX, net[j][0], net[j][1]) <= net[j][2])) {
							flag = false;
						}
					}
					if (flag) {
						q.add(new Pos(nY, nX, d + 1));
						visited[nY][nX] = true;
					}
				}
			}
		}
	}

	static boolean checkIdx(int y, int x) {
		if (y >= 1 && y <= N && x >= 1 && x <= N) {
			return true;
		}
		return false;
	}

	static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			init(sc);

			boolean[][] subset = makeSubset();

			for (int i = 0; i < (1 << M); i++) {
				int t = 0;
				for (int j = 0; j < M; j++) {
					if (subset[i][j]) {
						t += net[j][3];
					}
				}
				if (t <= K) {
					bfs(subset[i]);
				}
			}

			System.out.println("#" + tc + " " + result);
		}

	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, 1, 1 }; // 가로, 세로, 대각
	static int[] dx = { 1, 0, 1 };

	static int N;
	static int[][] map;
	static int result;

	static class Pos {
		int y;
		int x;
		int d;

		Pos(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(1, 2, 0));

		while (!q.isEmpty()) {
			Pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int d = p.d;
			if(x == 6 && y == 2) {
				int a = 0;
			}
			if (y == N && x == N) {
				result++;
				continue;
			}

			for (int i = 0; i < 3; i++) {
				// 현재 파이프가 가로 상태이고, 세로로 이동하려 할때
				if (d == 0 && i == 1) {
					continue;
				}
				// 현재 파이프가 세로 상태이고, 가로로 이동하려 할때
				else if (d == 1 && i == 0) {
					continue;
				}

				int nY = y + dy[i];
				int nX = x + dx[i];

				// 다음 방향이 배열범위를 벗어나지 않았고, 벽이 없을 때
				if (checkIdx(nY, nX) && map[nY][nX] != 1) {
					// 대각선으로 이동하려 할 때
					if (i == 2 && (map[nY - 1][nX] == 1 || map[nY][nX - 1] == 1)) {
						continue;
					}
					q.add(new Pos(nY, nX, i));
				}
			}
		}
	}

	static boolean checkIdx(int y, int x) {
		if (y <= 0 || y > N || x <= 0 || x > N) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		result = 0;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(map[N][N] != 1) {
			bfs();
		}		

		System.out.println(result);

		br.close();
	}
}

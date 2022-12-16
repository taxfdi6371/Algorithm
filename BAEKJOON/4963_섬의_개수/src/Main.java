import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int w;
	static int h;

	static int[][] map;

	static boolean[][] visited;

	static int result;

	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();

		q.add(new Pos(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			for (int i = 0; i < 8; i++) {
				int nY = pos.y + dy[i];
				int nX = pos.x + dx[i];

				if (idxCheck(nY, nX) && map[nY][nX] == 1 && !visited[nY][nX]) {
					q.add(new Pos(nY, nX));
					visited[nY][nX] = true;
				}
			}
		}

		result++;
	}

	static boolean idxCheck(int y, int x) {
		if (y >= 0 && y < h && x >= 0 && x < w)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[h][w];

			result = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1)
						bfs(i, j);
				}
			}

			System.out.println(result);
		}

		br.close();
	}

}

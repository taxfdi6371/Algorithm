import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int high;
	public static int safeZone;

	public static void dfs(int y, int x, int height) {
		for (int i = 0; i < 4; i++) {
			int nY = y + dy[i];
			int nX = x + dx[i];
			if (checkIdx(nY, nX) && map[nY][nX] > height && !visited[nY][nX]) {
				visited[nY][nX] = true;
				dfs(nY, nX, height);
			}
		}
	}

	public static boolean checkIdx(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		high = 0;
		safeZone = 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 가장 높은 지역 찾기
				if (map[i][j] > high) {
					high = map[i][j];
				}
			}
		}

		for (int h = 1; h < high; h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문하지 않았고, 잠기는 높이보다 높으면
					if (!visited[i][j] && map[i][j] > h) {
						visited[i][j] = true;
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			safeZone = Math.max(safeZone, cnt);
		}

		System.out.print(safeZone);

		br.close();
	}

}

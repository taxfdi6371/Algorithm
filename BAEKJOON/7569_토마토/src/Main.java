import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	public static int[] dz = { -1, 1, 0, 0, 0, 0 };
	public static int[] dy = { 0, 0, 0, 0, 1, -1 };
	public static int[] dx = { 0, 0, -1, 1, 0, 0 };

	public static int H; // z
	public static int N; // y
	public static int M; // x

	public static int[][][] map; // 토마토 상자
	public static Queue<Pos> q; // bfs 탐색 큐

	public static int result; // 모두 익는데 걸리는 날

	static class Pos {
		int z;
		int y;
		int x;

		public Pos(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pos pos = q.poll();

			for (int i = 0; i < 6; i++) {
				int nZ = pos.z + dz[i];
				int nY = pos.y + dy[i];
				int nX = pos.x + dx[i];

				// 범위를 벗어나지 않고, 안익은 토마토가 있다면
				if (checkIdx(nZ, nY, nX) && map[nZ][nY][nX] == 0) {
					q.add(new Pos(nZ, nY, nX));
					map[nZ][nY][nX] = map[pos.z][pos.y][pos.x] + 1;
				}
			}
		}
	}

	public static boolean checkIdx(int z, int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H) {
			return true;
		} else {
			return false;
		}
	}

	public static void check() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					// 하나라도 안익은 토마토가 있을 때
					if (map[i][j][k] == 0) {
						result = 0;
						return;
					} else {
						result = Math.max(result, map[i][j][k]);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		
		q = new LinkedList<>();
		result = Integer.MIN_VALUE;
		
		// 토마토 정보 저장
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.add(new Pos(i, j, k));
					}
				}
			}
		}

		bfs();

		check();

		System.out.println(result - 1);

		br.close();
	}

}

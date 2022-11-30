import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dy = { 0, 1, 0, -1 }; // 북, 서, 남, 동을 바라보고 있을 때
	public static int[] dx = { -1, 0, 1, 0 };

	public static int N; // 세로
	public static int M; // 가로

	public static int[][] map;
	public static boolean[][] visited;
	public static int y;
	public static int x;
	public static int d;

	public static int cnt;

	public static void func() {
		while (true) {
			boolean cFlag = true;

			for (int i = 0; i < 4; i++) {
				int nD = (d + i) % 4; // 바라보는 방향 왼쪽 검사
				int nY = y + dy[nD];
				int nX = x + dx[nD];

				// 벽이 아니고 청소하지 않은 공간이라면
				if (checkIdx(nY, nX) && !visited[nY][nX] && map[nY][nX] == 0) {
					visited[nY][nX] = true;
					cnt++;
					y = nY;
					x = nX;
					d = nD + 1;
					cFlag = false;
					break;
				}
			}

			// 청소할 방향이 없는 경우
			if (cFlag) {
				int nY = y + dy[(d + 1) % 4];
				int nX = x + dx[(d + 1) % 4];
				if (checkIdx(nY, nX) && map[nY][nX] == 0) {
					y = nY;
					x = nX;
					// 뒤쪽 방향이 벽이라 후진 할 수 없는 경우
				} else if (!checkIdx(nY, nX) || map[nY][nX] == 1) {
					break;
				}
			}
		}
	}

	public static boolean checkIdx(int y, int x) {
		if (y != 0 && y != N - 1 && x != 0 && x != M - 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		if (d == 1) {
			d = 3;
		} else if (d == 3) {
			d = 1;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[y][x] = true;
		cnt = 1;

		func();

		System.out.print(cnt);

		br.close();
	}

}

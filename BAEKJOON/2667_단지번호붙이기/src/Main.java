import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int[][] map;
	public static int N;
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void bfs(int y, int x) {
		int cnt = 0;
		Queue<Integer> qY = new LinkedList<>();
		Queue<Integer> qX = new LinkedList<>();

		qY.offer(y);
		qX.offer(x);
		map[y][x] = 0;
		cnt++;

		while (!qY.isEmpty()) {
			int cY = qY.poll();
			int cX = qX.poll();

			for (int i = 0; i < 4; i++) {
				int nY = cY + dy[i];
				int nX = cX + dx[i];
				if (checkIdx(nY, nX) && map[nY][nX] == 1) {
					qY.offer(nY);
					qX.offer(nX);
					map[nY][nX] = 0;
					cnt++;
				}
			}
		}
		pq.offer(cnt);
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

		// 지도 초기화
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}

		// bfs 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}

		int size = pq.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll());
		}

		br.close();
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };
	static final int UP = 1;
	static final int RIGHT = 2;
	static final int LEFT = 3;
	static final int DOWN = 4;
	static final int APPLE = 5;

	static int N; // 보드의 크기
	static int K; // 사과의 개수
	static int[][] map; // 0: 빈공간, 1 2 3 4 : 상 우 하 좌, 5: 사과

	static int L;
	static int[][] q;
	static int qIdx;

	static int[] head;
	static int[] tail;
	static int d;
	static int t;

	static void run() {
		while (true) {
			t++; // 시간 증가
			
			int nHeadY = head[0] + dy[d]; // 이동할 머리 위치
			int nHeadX = head[1] + dx[d];

			// 벽 체크
			if (idxCheck(nHeadY, nHeadX)) {
				if (map[nHeadY][nHeadX] == APPLE) { // 사과를 만났을 때
					// 꼬리는 움직이지 않음
				} else if (map[nHeadY][nHeadX] == 0) { // 사과를 만나지 않았을 때
					int nTailY = tail[0] + dy[map[tail[0]][tail[1]]];
					int nTailX = tail[1] + dx[map[tail[0]][tail[1]]];

					map[tail[0]][tail[1]] = 0; // 기존 꼬리 제거

					tail[0] = nTailY; // 꼬리 좌표 이동
					tail[1] = nTailX;
				} else {// 자기 몸에 부딪히면 종료
					return;
				}

				head[0] = nHeadY;
				head[1] = nHeadX;

			} else { // 벽에 부딪히면 종료
				return;
			}

			// 방향 전환
			if (qIdx < L && q[qIdx][0] == t) {
				d = d + q[qIdx][1];
				if(d == 0) d = 4;
				if(d == 5) d = 1;
				qIdx++;
			}
			
			map[head[0]][head[1]] = d;
		}
	}

	static boolean idxCheck(int y, int x) {
		if (y >= 1 && y <= N && x >= 1 && x <= N)
			return true;

		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = APPLE;
		}

		L = Integer.parseInt(br.readLine());
		q = new int[L][2];
		qIdx = 0;

		for (int j = 0; j < L; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);

			q[j][0] = X;

			if (C == 'L') {
				q[j][1] = -1; // 왼쪽
			} else {
				q[j][1] = 1; // 오른쪽
			}
		}
		map[1][1] = 2;

		head = new int[2];
		tail = new int[2];

		head[0] = 1;
		head[1] = 1;
		tail[0] = 1;
		tail[1] = 1;

		d = RIGHT;
		t = 0;

		run();

		System.out.print(t);

		br.close();
	}
}

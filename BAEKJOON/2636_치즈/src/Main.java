import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int h;
	static int w;
	static int[][] map;

	static int time;

	static Queue<Pos> q;
	static boolean[][] visited;
	static boolean[][] temp;

	static boolean flag;
	static int result;
	
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void bfs() {
		q = new LinkedList<Pos>();
		visited = new boolean[h][w];
		
		q.add(new Pos(0, 0));

		temp = new boolean[h][w]; // 공기와 닿은 치즈 위치

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nY = pos.y + dy[i];
				int nX = pos.x + dx[i];

				if (idxCheck(nY, nX) && !visited[nY][nX]) {
					if (map[nY][nX] == 1) {
						temp[nY][nX] = true;
					} else {
						visited[nY][nX] = true;
						q.add(new Pos(nY, nX));
					}
				}
			}
		}
	}

	static boolean idxCheck(int y, int x) {
		if (y >= 0 && y < h && x >= 0 && x < w)
			return true;
		return false;
	}

	static void cheese() {
		int cheeseCnt = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (temp[i][j]) {
					flag = true;
					map[i][j] = 0;
					cheeseCnt++;
				}
			}
		}
		
		if(flag) {
			result = cheeseCnt;
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken()); // 세로
		w = Integer.parseInt(st.nextToken()); // 가로

		map = new int[h][w]; // 치즈 판

		time = 0; // 시간

		flag = false; // 남아있는 치즈가 있는지 알려주는 Flag
		result = 0; // 녹기 한 시간전 남은 치즈
		
		// 초기화
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			bfs(); // 공기중에 닿아있는 치즈 체크

			cheese(); // 치즈를 녹이고 개수 세기
			
			// 남아 있는 치즈가 있을 때
			if(flag) {
				time++; // 시간 증가
				flag = false; // Flag 초기화
			} else {
				break; // 남아 있는 치즈가 없으면 종료
			}
		}
		
		System.out.println(time);
		System.out.println(result);
		
		br.close();
	}

}

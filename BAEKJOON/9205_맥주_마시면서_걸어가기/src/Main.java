import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] matrix;
	static ArrayList<Pos> al;
	static boolean[] visited;
	static boolean flag;

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 2];

		q.add(0); // matrix의 0번
		visited[0] = true;

		while (!q.isEmpty()) {
			int cPos = q.poll();

			if (cPos == n + 1) {
				flag = true;
				return;
			}

			for (int i = 0; i < matrix[cPos].size(); i++) {
				int nPos = matrix[cPos].get(i);

				if (!visited[nPos]) {
					visited[nPos] = true;
					q.add(nPos);
				}
			}
		}
	}

	static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수

			al = new ArrayList<>();

			// 모든 좌표 저장
			// 0 : 집
			// 1 ~ n : 편의점
			// n+1 : 페스티벌
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				al.add(new Pos(y, x));
			}

			matrix = new ArrayList[n + 2];
			for (int i = 0; i < matrix.length; i++) {
				matrix[i] = new ArrayList<>();
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					Pos p1 = al.get(i);
					Pos p2 = al.get(j);

					if (getDistance(p1.y, p1.x, p2.y, p2.x) <= 1000) {
						matrix[i].add(j);
						matrix[j].add(i);
					}
				}
			}

			flag = false;

			bfs();

			if (flag) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}

		br.close();
	}

}

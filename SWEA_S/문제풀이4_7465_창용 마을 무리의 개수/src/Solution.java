import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] matrix = new int[N + 1][N + 1];
			boolean[] visited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				matrix[s][0]++;
				matrix[e][0]++;
				matrix[s][matrix[s][0]] = e;
				matrix[e][matrix[e][0]] = s;
			}

			int cnt = 0;
			Queue<Integer> q = new LinkedList<>();

			// 1번부터 탐색
			for (int i = 1; i < N + 1; i++) {
				// 방문하지 않은 정점이라면,
				if (!visited[i]) {
					cnt++;
					visited[i] = true;
					q.offer(i);
					while (!q.isEmpty()) {
						int v = q.poll();
						for (int j = 1; j < matrix[v][0] + 1; j++) {
							if (!visited[matrix[v][j]]) {
								q.offer(matrix[v][j]);
								visited[matrix[v][j]] = true;
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}

}
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[][] matrix;
	static boolean[] visited; // 방문처리

	public static void dfs(int from) {
		for (int to = 1; to <= matrix[from][0]; to++) { // 연결된 경로의 개수만큼 반복
			if (!visited[matrix[from][to]]) { // 연결된 정점에 방문한 적이 없다면
				dfs(matrix[from][to]); // 탐색
			}
		}

		visited[from] = true;
		sb.append(" " + from);
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case);
			int v = sc.nextInt();
			int e = sc.nextInt();

			matrix = new int[v + 1][v + 1]; // 인접행렬
			visited = new boolean[v + 1]; // 방문

			for (int i = 0; i < e; i++) {
				int end = sc.nextInt();
				int begin = sc.nextInt();

				matrix[begin][++matrix[begin][0]] = end;
			}
			for (int i = 1; i <= v; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
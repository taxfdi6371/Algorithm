package 큐_ex03;

import java.util.StringTokenizer;

public class BFSTest {

	public static void main(String[] args) {
		int v = 7;
		int e = 8;
		String s = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";

		int[][] arr = new int[v + 1][v + 1];
		boolean[] visited = new boolean[v + 1];
		int[] q = new int[100];
		int f = -1;
		int r = -1;
		StringTokenizer st = new StringTokenizer(s);

		for (int i = 0; i < e; i++) {
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start][0]++;
			arr[start][arr[start][0]] = end;
			arr[end][0]++;
			arr[end][arr[end][0]] = start;
		}

		q[++r] = 1;
		visited[1] = true;
		System.out.print(q[r] + " ");

		while (f != r) {
			int x = q[++f];
			for (int i = 1; i <= arr[x][0]; i++) {
				if (!visited[arr[x][i]]) {
					q[++r] = arr[x][i];
					visited[q[r]] = true;
					System.out.print(q[r] + " ");
				}
			}
		}
	}

}

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = sc.nextInt();
			int start = sc.nextInt();

			int[][] arr = new int[101][101];
			boolean[] visited = new boolean[101];
			int[] depth = new int[101];

			int[] q = new int[200];
			int f = -1;
			int r = -1;

			int result = 0;

			for (int i = 0; i < n / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				arr[from][0]++;
				arr[from][arr[from][0]] = to;
			}

			q[++r] = start;
			visited[start] = true;

			result = start;

			while (f != r) {
				int v = q[++f];
				for (int i = 1; i <= arr[v][0]; i++) {
					if (!visited[arr[v][i]]) {
						q[++r] = arr[v][i];
						visited[arr[v][i]] = true;
						depth[arr[v][i]] = depth[v] + 1;
					}
				}
			}
			for (int i = 1; i < 101; i++) {
				if(depth[i] >= depth[result]) {
					result = i;
				}
			}
			
			System.out.println(result);
		}
	}

}
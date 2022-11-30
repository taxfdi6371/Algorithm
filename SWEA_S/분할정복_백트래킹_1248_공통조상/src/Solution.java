import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int v = sc.nextInt();
			int e = sc.nextInt();

			int[][] arr = new int[v + 1][3];
			boolean[] visited = new boolean[v + 1];

			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			for (int i = 0; i < e; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();

				arr[c][0] = p;

				if (arr[p][1] == 0) {
					arr[p][1] = c;
				} else {
					arr[p][2] = c;
				}
			}

			int rv = -1;

			while (v1 != 1 || v2 != 1) {
				if (visited[v1] && v1 != 0) { // 방문한 적 있는 노드라면
					rv = v1;
					break;
				} else if (visited[v1] == false) {
					visited[v1] = true;
					v1 = arr[v1][0]; // 부모로 이동
				}

				if (visited[v2] && v2 != 0) { // 방문한 적 있는 노드라면
					rv = v2;
					break;
				} else if (visited[v2] == false) {
					visited[v2] = true;
					v2 = arr[v2][0]; // 부모로 이동
				}
			}

			int count = 0;
			visited = new boolean[v + 1];
			int[] q = new int[10001];
			int front = 0;
			int rear = 0;

			q[rear++] = rv;
			visited[rv] = true;
			count++;

			while (front != rear) {
				int cv = q[front++];
				if (visited[arr[cv][1]] == false && arr[cv][1] != 0) {
					visited[arr[cv][1]] = true;
					count++;
					q[rear++] = arr[cv][1];
				}
				if (visited[arr[cv][2]] == false && arr[cv][2] != 0) {
					visited[arr[cv][2]] = true;
					count++;
					q[rear++] = arr[cv][2];
				}
			}

			System.out.println("#" + test_case + " " + rv + " " + count);
		}
	}

}
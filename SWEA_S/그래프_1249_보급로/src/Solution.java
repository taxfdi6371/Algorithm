import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dy = { 1, -1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };

	public static int[][] arr;
	public static int n;
	public static int[][] d; // 해당 정점까지 최소 경로
	public static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			n = sc.nextInt();
			arr = new int[n][n];

			visited = new boolean[n][n];
			d = new int[n][n];

			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
					d[i][j] = Integer.MAX_VALUE; // 최대값으로 초기화
				}
			}

			d[0][0] = 0;

			for (int k = 0; k < n * n - 2; k++) {
				int min = Integer.MAX_VALUE;
				int cY = -1;
				int cX = -1;

				// 최소값을 가진 정점 찾기
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (visited[i][j] == false && d[i][j] != Integer.MAX_VALUE) {
							if (min > d[i][j]) {
								min = d[i][j];
								cY = i;
								cX = j;
							}
						}
					}
				}

				visited[cY][cX] = true;

				// 인접한 모든 정점
				for (int i = 0; i < 4; i++) {
					int nY = cY + dy[i];
					int nX = cX + dx[i];
					// 인덱스가 범위 내이며, 방문하지 않았다면
					if (nX >= 0 && nX < n && nY >= 0 && nY < n && visited[nY][nX] == false) {
						d[nY][nX] = Math.min(d[nY][nX], d[cY][cX] + arr[nY][nX]);
					}
				}
			}
			System.out.println("#" + test_case + " " + d[n - 1][n - 1]);
		}
	}
}

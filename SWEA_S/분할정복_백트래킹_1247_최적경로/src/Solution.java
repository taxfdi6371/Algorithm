import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[][] arr; // 고객 좌표
	public static int[][] ch; // 회사, 집 좌표
	public static boolean[] visited;
	public static int n;
	public static int shortest; // 최단 경로 길이

	public static void find(int x, int y, int d, int sum) {
		if (d == n) {
			// 마지막 고객에서 집까지 거리
			sum += calcD(x, y, ch[0][1], ch[1][1]);
			shortest = Math.min(shortest, sum);
		} else {
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					if (sum + calcD(x, y, arr[0][i], arr[1][i]) > shortest) {
						continue;
					}
					visited[i] = true;
					sum += calcD(x, y, arr[0][i], arr[1][i]);
					find(arr[0][i], arr[1][i], d + 1, sum);
					visited[i] = false;
					sum -= calcD(x, y, arr[0][i], arr[1][i]);
				}
			}
		}
	}

	public static int calcD(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int test_case = 1; test_case <= t; test_case++) {
			n = sc.nextInt(); // 고객의 수
			arr = new int[2][n];
			ch = new int[2][2];
			visited = new boolean[n];

			shortest = Integer.MAX_VALUE;

			for (int i = 0; i < 2; i++) {
				ch[0][i] = sc.nextInt(); // 회사,집의 x좌표
				ch[1][i] = sc.nextInt(); // 회사,집의 y좌표
			}

			for (int i = 0; i < n; i++) {
				arr[0][i] = sc.nextInt(); // 고객의 x좌표
				arr[1][i] = sc.nextInt(); // 고객의 y좌표
			}

			for (int i = 0; i < n; i++) {
				int sum = 0;
				// 회사에서 첫번째 정점까지 거리
				sum += calcD(ch[0][0], ch[1][0], arr[0][i], arr[1][i]);
				visited[i] = true;
				find(arr[0][i], arr[1][i], 1, sum);
				visited[i] = false;
			}

			System.out.println("#" + test_case + " " + shortest);
		}
	}

}
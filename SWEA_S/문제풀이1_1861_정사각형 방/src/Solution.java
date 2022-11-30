import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[][] arr;
	public static int n = 0;
	public static int result = Integer.MAX_VALUE; // 방의 숫자
	public static int resultCnt = 1; // 이동횟수
	public static int[] dy = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	public static int[] dx = { 1, 0, -1, 0 }; // 우, 하, 좌, 상

	// y좌표, x좌표, 이동횟수
	public static void find(int startNum, int y, int x, int cnt) {
		for (int i = 0; i < 4; i++) { // 4방향 탐색
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (nextX < 0 || nextX > n - 1 || nextY < 0 || nextY > n - 1) { // 배열의 범위를 벗어나면
				continue;
			}
			if (arr[nextY][nextX] - arr[y][x] == 1) { // 다음 방이 1보다 크다면
				find(startNum, nextY, nextX, cnt + 1);
				return;
			}
		}
		// 더이상 이동할 방이 없을 때
		// 이동 횟수가 크거나 이동 횟수는 같은데 시작한 방의 숫자가 더 작으면
		if (cnt > resultCnt || (cnt == resultCnt && startNum < result)) {
			resultCnt = cnt;
			result = startNum;
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			System.out.print("#" + test_case + " ");

			n = sc.nextInt();
			arr = new int[n][n];

			result = Integer.MAX_VALUE; // 방의 숫자
			resultCnt = 1; // 이동횟수

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					find(arr[i][j], i, j, 1);
				}
			}

			System.out.printf("%d %d\n", result, resultCnt);
		}
	}

}
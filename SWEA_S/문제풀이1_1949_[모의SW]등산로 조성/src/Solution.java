import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	public static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	public static int[] dx = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static int[][] arr; // 부지
	public static boolean[][] visited;
	public static int high = 0; // 가장 높은 봉우리의 높이
	public static int[][] highYX = new int[5][2]; // 좌표.
	public static int hIdx = 0; //

	public static int l = 0;

	public static int n = 0;
	public static int k = 0;

	/*
	 * 
	 * cnt : 이동 횟수
	 */
	public static void find(int cnt, int y, int x) {
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			// 방문한적 있거나, 배열의 범위를 벗어나는 경우
			if (nextY < 0 || nextY > n - 1 || nextX < 0 || nextX > n - 1 || visited[nextY][nextX]) {
				continue;
			}
			if (arr[nextY][nextX] < arr[y][x]) { // 다음 위치가 더 낮은 경우
				visited[y][x] = true; // 현재 위치 방문 표시
				find(cnt + 1, nextY, nextX);
				visited[y][x] = false;
				// 다음 위치가 높거나 같고, 두 높이의 차가 k보다 낮은 경우
			} else if ((arr[nextY][nextX] >= arr[y][x]) && (arr[nextY][nextX] - arr[y][x] < k)) {
				int tempNum = arr[nextY][nextX];
				int temp = k;
				arr[nextY][nextX] = arr[y][x] - 1; // 현재 위치보다 한칸 낮게 설정
				k = 0; // k를 0으로 변경
				visited[y][x] = true;
				find(cnt + 1, nextY, nextX);
				arr[nextY][nextX] = tempNum;
				k = temp;
				visited[y][x] = false;
			}
		}
		l = Math.max(l, cnt);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine()); // 총 테스트 케이스

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()); // 지도 한변의 길이
			k = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

			arr = new int[n][n];
			visited = new boolean[n][n];

			high = 0;
			hIdx = 0;
			l = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > high) { // 새로 가장 큰 높이가 나온다면
						high = arr[i][j];
						highYX[0][0] = i;
						highYX[0][1] = j;
						hIdx = 1;
					} else if (arr[i][j] == high) {
						highYX[hIdx][0] = i;
						highYX[hIdx][1] = j;
						hIdx++;
					}
				}
			}

			for (int i = 0; i < hIdx; i++) { // 모든 봉우리 모두 검사
				find(1, highYX[i][0], highYX[i][1]);
			}

			bw.write("#" + test_case + " " + l + "\n");
		}

		br.close();
		bw.close();
	}

}
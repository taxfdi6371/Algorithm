import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int n;
	public static int[][] arr;
	public static boolean[][] visited;

	public static void up() {
		boolean flag = true; // 이동이 발생하는지 검사
		while (flag) {
			flag = false;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 합쳐진적 없고, 다음 좌표와 값이 같다면
					if (!visited[i - 1][j] && !visited[i][j] && arr[i][j] > 0 && arr[i][j] == arr[i - 1][j]) {
						flag = true;
						arr[i - 1][j] *= 2;
						visited[i - 1][j] = true;
						arr[i][j] = 0;
						visited[i][j] = false;
					} else if (arr[i][j] > 0 && arr[i - 1][j] == 0) {
						flag = true;
						if (visited[i][j]) { // 현재 위치가 합쳐진적 있다면,
							visited[i - 1][j] = true;
						}
						arr[i - 1][j] = arr[i][j];
						arr[i][j] = 0;
						visited[i][j] = false;
					}
				}
			}
		}
	}

	public static void down() {
		boolean flag = true; // 이동이 발생하는지 검사
		while (flag) {
			flag = false;
			for (int i = n - 2; i > -1; i--) {
				for (int j = 0; j < n; j++) {
					// 합쳐진적 없고, 다음 좌표와 값이 같다면
					if (!visited[i + 1][j] && !visited[i][j] && arr[i][j] > 0 && arr[i][j] == arr[i + 1][j]) {
						flag = true;
						arr[i + 1][j] *= 2;
						visited[i + 1][j] = true;
						arr[i][j] = 0;
						visited[i][j] = false;
					} else if (arr[i][j] > 0 && arr[i + 1][j] == 0) {
						flag = true;
						if (visited[i][j]) { // 현재 위치가 합쳐진적 있다면,
							visited[i + 1][j] = true;
						}
						arr[i + 1][j] = arr[i][j];
						arr[i][j] = 0;
						visited[i][j] = false;
					}
				}
			}
		}
	}

	public static void left() {
		boolean flag = true; // 이동이 발생하는지 검사
		while (flag) {
			flag = false;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 합쳐진적 없고, 다음 좌표와 값이 같다면
					if (!visited[j][i - 1] && !visited[j][i] && arr[j][i] > 0 && arr[j][i] == arr[j][i - 1]) {
						flag = true;
						arr[j][i - 1] *= 2;
						visited[j][i - 1] = true;
						arr[j][i] = 0;
						visited[j][i] = false;
					} else if (arr[j][i] > 0 && arr[j][i - 1] == 0) {
						flag = true;
						if (visited[j][i]) { // 현재 위치가 합쳐진적 있다면,
							visited[j][i - 1] = true;
						}
						arr[j][i - 1] = arr[j][i];
						arr[j][i] = 0;
						visited[j][i] = false;
					}
				}
			}
		}
	}

	public static void right() {
		boolean flag = true; // 이동이 발생하는지 검사
		while (flag) {
			flag = false;
			for (int i = n - 2; i > -1; i--) {
				for (int j = 0; j < n; j++) {
					// 합쳐진적 없고, 다음 좌표와 값이 같다면
					if (!visited[j][i + 1] && !visited[j][i] && arr[j][i] > 0 && arr[j][i] == arr[j][i + 1]) {
						flag = true;
						arr[j][i + 1] *= 2;
						visited[j][i + 1] = true;
						arr[j][i] = 0;
						visited[j][i] = false;
					} else if (arr[j][i] > 0 && arr[j][i + 1] == 0) {
						flag = true;
						if (visited[j][i]) { // 현재 위치가 합쳐진적 있다면,
							visited[j][i + 1] = true;
						}
						arr[j][i + 1] = arr[j][i];
						arr[j][i] = 0;
						visited[j][i] = false;
					}
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			System.out.println("#" + test_case + " ");

			n = sc.nextInt();
			String s = sc.next();

			arr = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) { // 배열 초기화
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			switch (s) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "left":
				left();
				break;
			case "right":
				right();
				break;
			default:
				break;
			}

			for (int i = 0; i < n; i++) { // 출력
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
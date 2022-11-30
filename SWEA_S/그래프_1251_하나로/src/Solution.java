import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int n;
	public static int[][] arr;
	public static boolean[] visited;
	public static long[][] tax;
	public static long[] d;
	public static double E;

	public static long calcTax(int y1, int x1, int y2, int x2) {
		long temp = (long) (Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2));
		return temp;
	}

	public static void prim() {
		for (int k = 0; k < n - 1; k++) { // 모든 정점 검사
			long min = Long.MAX_VALUE;
			int minIdx = -1;

			// 최소인 정점 선택
			for (int i = 0; i < n; i++) {
				if (!visited[i] && d[i] < min) {
					min = d[i];
					minIdx = i;
				}
			}
			// 인근 정점
			for (int i = 0; i < n; i++) {
				if (!visited[i] && tax[i][minIdx] != 0 && d[i] > tax[i][minIdx]) {
					d[i] = tax[i][minIdx];
				}
			}
			visited[minIdx] = true;
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			n = sc.nextInt();
			arr = new int[2][n]; // y,x좌표
			visited = new boolean[n]; // 방문
			tax = new long[n][n]; // 모든 정점사이 길이
			d = new long[n];

			for (int i = 0; i < n; i++) {
				d[i] = Long.MAX_VALUE; //
				arr[1][i] = sc.nextInt(); // x좌표 초기화
			}
			for (int i = 0; i < n; i++) {
				arr[0][i] = sc.nextInt(); // y좌표 초기화
			}
			E = sc.nextDouble();

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					tax[i][j] = calcTax(arr[0][i], arr[1][i], arr[0][j], arr[1][j]); // 모든 정점사이 세금 계산하여 입력
					tax[j][i] = tax[i][j];
				}
			}

			d[0] = 0;
			prim();

			long result = 0;
			for (int i = 0; i < n; i++) {
				result += d[i];
			}

			System.out.println("#" + test_case + " " + Math.round(result * E));
		}
	}

}
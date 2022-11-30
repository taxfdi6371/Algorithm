import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[][] matrix;
	public static int n;
	public static int[][] size;
	public static int sizeIdx;

	public static void func(int y, int x) {
		int yCnt = 0;
		int xCnt = 0;
		int yIdx = y;
		int xIdx = x;

		// 행의 끝 찾기
		while (yIdx != n - 1 && matrix[yIdx + 1][x] != 0) {
			yIdx++;
		}
		yCnt = yIdx - y + 1;
		// 열의 끝 찾기
		while (xIdx != n - 1 && matrix[y][xIdx + 1] != 0) {
			xIdx++;
		}
		xCnt = xIdx - x + 1;

		// 모두 0으로 바꾸기
		for (int i = y; i < yIdx + 1; i++) {
			for (int j = x; j < xIdx + 1; j++) {
				matrix[i][j] = 0;
			}
		}

		size[0][sizeIdx] = yCnt * xCnt;
		size[1][sizeIdx] = yCnt;
		size[2][sizeIdx] = xCnt;
		sizeIdx++;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			size = new int[3][20];
			sizeIdx = 0;
			n = sc.nextInt();
			matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] != 0) {
						int yIdx = i;
						int xIdx = j;
						func(yIdx, xIdx);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(sizeIdx).append(" ");
			int idx = -1;
			for (int i = 0; i < sizeIdx; i++) {
				int min = Integer.MAX_VALUE - 1;
				for (int j = 0; j < sizeIdx; j++) {
					if (size[0][j] < min) {
						min = size[0][j];
						idx = j;
					} else if (size[0][j] == min && size[1][j] < size[1][idx]) {
						min = size[0][j];
						idx = j;
					}
				}
				sb.append(size[1][idx]).append(" ").append(size[2][idx]).append(" ");
				size[0][idx] = Integer.MAX_VALUE;
			}

			System.out.println("#" + test_case + " " + sb);
		}
	}

}
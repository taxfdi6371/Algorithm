import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int R;
	static int[][] A;
	static int[][] res;

	// 상하 반전
	static void one() {
		int n = A.length;
		int m = A[0].length;

		res = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = A[n - 1 - i][j];
			}
		}
	}

	// 좌우 반전
	static void two() {
		int n = A.length;
		int m = A[0].length;

		res = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = A[i][m - 1 - j];
			}
		}
	}

	// 오른쪽 90
	static void three() {
		int n = A[0].length;
		int m = A.length;

		res = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = A[m - 1 - j][i];
			}
		}
	}

	// 왼쪽 90
	static void four() {
		int n = A[0].length;
		int m = A.length;

		res = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = A[j][n - 1 - i];
			}
		}

	}

	static void five() {
		int n = A.length;
		int m = A[0].length;

		res = new int[n][m];

		// 4->1
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				res[i][j] = A[n / 2 + i][j];
			}
		}
		// 1->2
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				res[i][j] = A[i][j - m / 2];
			}
		}
		// 2->3
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				res[i][j] = A[i - n / 2][j];
			}
		}
		// 3->4
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				res[i][j] = A[i][j + m / 2];
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(res[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static void six() {
		int n = A.length;
		int m = A[0].length;

		res = new int[n][m];

		// 2->1
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				res[i][j] = A[i][j + m / 2];
			}
		}

		// 3->2
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				res[i][j] = A[i + n / 2][j];
			}
		}

		// 4->3
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				res[i][j] = A[i][j - m / 2];
			}
		}
		// 1->4
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				res[i][j] = A[i - n / 2][j];
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(res[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 연산 수
		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			switch (r) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				break;
			}
			A = res;
		}
		for (int j = 0; j < A.length; j++) {
			for (int k = 0; k < A[0].length; k++) {
				System.out.print(A[j][k] + " ");
			}
			System.out.println();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
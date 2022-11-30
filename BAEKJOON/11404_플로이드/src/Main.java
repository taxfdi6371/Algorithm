import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int n = Integer.parseInt(br.readLine()); // 도시의 수
		int m = Integer.parseInt(br.readLine()); // 버스의 수

		int[][] arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 필요한 비용

			// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
			arr[a][b] = Math.min(arr[a][b], c);
		}

		for (int i = 1; i <= n; i++) { // 중간 도시
			for (int j = 1; j <= n; j++) { // 시작 도시
				for (int k = 1; k <= n; k++) { // 도착 도시
					if (arr[j][i] != Integer.MAX_VALUE && arr[i][k] != Integer.MAX_VALUE) {
						arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(arr[i][j] != Integer.MAX_VALUE) {
					System.out.print(arr[i][j] + " ");					
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}

		br.close();
	}

}

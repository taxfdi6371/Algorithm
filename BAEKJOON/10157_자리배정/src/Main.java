import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int[] dy = { 1, 0, -1, 0 };// 상, 우, 하, 좌
		int[] dx = { 0, 1, 0, -1 };

		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken()); // 가로
		int r = Integer.parseInt(st.nextToken()); // 세로

		int[][] arr = new int[r][c];

		int k = Integer.parseInt(br.readLine());

		if (k > c * r || r < 1) {
			System.out.print(0);
		} else {
			int dIdx = 0;
			int cY = -1;
			int cX = 0;
			for (int i = 0; i < k; i++) {
				int nY = cY + dy[dIdx % 4];
				int nX = cX + dx[dIdx % 4];
				// 배열의 범위를 벗어나거나, 이미 예약된 자리라면,
				if (nY >= 0 && nY < r && nX >= 0 && nX < c && arr[nY][nX] == 0) {
					arr[nY][nX] = 1;
				} else {
					dIdx++;
					nY = cY + dy[dIdx % 4];
					nX = cX + dx[dIdx % 4];
					arr[nY][nX] = 1;
				}
				cY = nY;
				cX = nX;
			}
			System.out.print((cX + 1) + " " + (cY + 1));
		}

		br.close();
	}

}

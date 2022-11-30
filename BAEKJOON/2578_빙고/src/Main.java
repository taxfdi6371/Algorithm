import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] bingo = new int[5][5];
	public static int[] yIdx = new int[26];
	public static int[] xIdx = new int[26];
	public static int count = 0;

	public static boolean check() {
		int bingoCnt = 0;

		int n = 0;
		for (int i = 0; i < 5; i++) { // 가로 검사
			n = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == -1) {
					n++;
				}
			}
			if (n == 5) {
				bingoCnt++;
			}
		}
		if (bingoCnt >= 3) {
			return true;
		}
		for (int i = 0; i < 5; i++) { // 세로 검사
			n = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == -1) {
					n++;
				}
			}
			if (n == 5) {
				bingoCnt++;
			}
		}
		if (bingoCnt >= 3) {
			return true;
		}

		n = 0;
		for (int i = 0; i < 5; i++) { // 오른쪽 방향 대각선
			if (bingo[i][i] == -1) {
				n++;
			}
		}
		if (n == 5) {
			bingoCnt++;
		}

		n = 0;
		int y = 0;
		for (int i = 4; i >= 0; i--) { // 왼쪽 방향 대각선
			if (bingo[i][y++] == -1) {
				n++;
			}
		}

		if (n == 5) {
			bingoCnt++;
		}
		if (bingoCnt >= 3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
				yIdx[bingo[i][j]] = i;
				xIdx[bingo[i][j]] = j;
			}
		}

		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				count++;
				int n = Integer.parseInt(st.nextToken());
				bingo[yIdx[n]][xIdx[n]] = -1;
				if (i > 1 && check()) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println(count);
		br.close();
	}

}

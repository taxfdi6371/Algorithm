import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int[][] arr = new int[1001][1001];

		int n = Integer.parseInt(br.readLine());
		int[] r = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = y; j < y + h; j++) {
				for (int k = x; k < x + w; k++) {
					// 다른 색종이가 채워져 있다면
					if (arr[j][k] != 0) {
						r[arr[j][k]]--; // 원래 있던 색종이 수 감소
					}
					arr[j][k] = i;
					r[i]++;
				}
			}
		}
		for (int i = 1; i < r.length; i++) {
			System.out.println(r[i]);
		}

		br.close();
	}

}

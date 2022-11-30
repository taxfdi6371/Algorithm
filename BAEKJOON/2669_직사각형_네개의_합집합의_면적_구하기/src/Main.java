import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[101][101];

		int area = 0;

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y2; j > y1; j--) {
				for (int k = x1; k < x2; k++) {
					if (arr[j][k] != 1) {
						arr[j][k] = 1;
						area++;
					}
				}
			}

		}
		System.out.println(area);

		br.close();
	}
}

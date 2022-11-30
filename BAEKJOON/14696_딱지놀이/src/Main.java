import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int[][] card = new int[2][5];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					card[j][num]++;
				}
			}

			for (int j = 4; j >= 0; j--) {
				if (j == 0) {
					sb.append("D\n");
					break;
				}

				if (card[0][j] > card[1][j]) {
					sb.append("A\n");
					break;
				} else if ((card[0][j] < card[1][j])) {
					sb.append("B\n");
					break;
				}
			}
		}

		System.out.print(sb.toString());

		br.close();
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int n = Integer.parseInt(br.readLine()); // 배추의 수

		int[] arr = new int[6];
		int[][] d = new int[5][2];

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 방향
			int l = Integer.parseInt(st.nextToken()); // 길이

			d[v][0]++;
			d[v][1] = i;
			arr[i] = l;
		}
		int idx1 = -1;
		int idx2 = -1;

		for (int i = 1; i < 5; i++) {
			if (d[i][0] == 1) {
				if (idx1 == -1) {
					idx1 = d[i][1];
				} else {
					idx2 = d[i][1];
				}
			}
		}
		int sum = (arr[idx1] * arr[idx2] - (arr[(idx1 + 3) % 6] * arr[(idx2 + 3) % 6])) * n;
		System.out.println(sum);

		br.close();
	}

}

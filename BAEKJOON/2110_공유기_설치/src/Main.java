import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] house;
	public static int C;
	public static int N;

	public static boolean check(int num) {

		int start = house[0];
		int count = 0;

		for (int i = 1; i < N; i++) {
			if (house[i] - start >= num) {
				start = house[i];
				count++;
			}

		}

		if (count < C - 1) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		int s = 1;
		int e = house[N - 1] - house[0];
		int result = 0;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (check(mid)) {
				s = mid + 1;
				result = mid;
			} else {
				e = mid - 1;
			}
		}

		sb.append(result);
		System.out.print(sb);
		br.close();

	}

}

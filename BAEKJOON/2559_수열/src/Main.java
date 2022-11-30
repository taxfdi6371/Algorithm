import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int sum = 0;
		int result = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i < c) {
				sum += arr[i];
			}
		}
		if (sum > result) {
			result = sum;
		}
		int idx = 0;
		for (int i = c; i < n; i++) {
			sum -= arr[idx++];
			sum += arr[i];
			if (sum > result) {
				result = sum;
			}
		}
		System.out.println(result);
		br.close();
	}

}

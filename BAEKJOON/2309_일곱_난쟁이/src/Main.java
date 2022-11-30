import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] d = new int[9];
	public static boolean[] visited = new boolean[9];

	public static int[] result = new int[7];

	public static void func(int sum, int idx, int k) {
		if (sum == 100 && k == 7) {
			int n = 0;
			for (int i = 0; i < 9; i++) {
				if (visited[i]) {
					result[n++] = d[i];
				}
			}
		} else if (sum > 100) {
			return;
		} else {
			for (int i = idx; i < 9; i++) {
				visited[i] = true;
				func(sum + d[i], i + 1, k + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		for (int i = 0; i < 9; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		func(0, 0, 0);

		Arrays.sort(result);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(result[i]);
		}

		br.close();
	}

}

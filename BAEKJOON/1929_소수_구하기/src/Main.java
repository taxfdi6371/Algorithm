import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] prime;

	// 에라토스테네스의 체
	public static void getPrime() {
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (!prime[i]) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		prime = new boolean[n + 1];
		getPrime();

		// 소수 출력
		for (int i = m; i <= n; i++) {
			if (!prime[i]) {
				System.out.println(i);
			}
		}

		br.close();
	}

}

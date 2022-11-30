import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// gcd(a, b) = gcd(b,r) r = a%b
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < t; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int gcdResult = gcd(a, b); // Greatest Common Divisor
			int icmResult = a * b / gcdResult; // Least Common Multiple

			System.out.println(icmResult);

		}
		br.close();

	}

}

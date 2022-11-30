import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int N = Integer.parseInt(br.readLine());
		int count = 0;

		while (N >= 5) {
			count += N / 5;
			N /= 5;
		}
		System.out.println(count);

		br.close();
	}

}

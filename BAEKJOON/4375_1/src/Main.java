import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		String s = null;

		while ((s = br.readLine()) != null) {
			int n = Integer.parseInt(s);
			int cnt = 1;
			int num = 1;

			while (true) {
				if (num % n == 0) {
					break;
				}

				cnt++;

				num = (num * 10 + 1) % n;
			}

			System.out.println(cnt);
		}

		br.close();
	}

}

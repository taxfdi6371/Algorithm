import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int count = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean flag = false;
			if (num == 1 || num == 0) {
				flag = true;
				continue;
			}
			for (int j = 2; j < num - 1; j++) {
				if (num % j == 0) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				count++;
			}

		}

		System.out.println(count);
		br.close();
	}

}

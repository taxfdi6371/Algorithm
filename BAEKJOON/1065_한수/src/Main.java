import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int N = Integer.parseInt(br.readLine());

		// 100 보다 작으면 한수는 그 숫자이다.
		if (N < 100) {
			System.out.print(N);
		} else {
			int cnt = 99;
			// 1000은 한수가 아니고 3자리수 계산만을 위해 1000은 999로 바꾼다.
			if (N == 1000) {
				N = 999;
			}
			for (int i = 100; i <= N; i++) {
				int hun = i / 100; // 백의 자리
				int ten = (i / 10) % 10; // 십의 자리
				int one = i % 10; // 일의 자리

				if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
					cnt++;
				}
			}
			System.out.print(cnt);
		}

		br.close();
	}

}

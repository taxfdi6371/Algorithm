import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	static int N;

	static StringBuilder sb;

	static void func() {
		if (sb.length() > N) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			sb.append(i);

			// 좋은 수열인지 검사
			if (check())
				break;
			else
				sb.deleteCharAt(sb.length() - 1);
		}
	}

	static boolean check() {

		// j칸 씩 검사
		if (sb.length() < 2)
			return true;
		for (int j = 1; j <= sb.length() / 2; j++) {
			boolean flag = false;
			for (int k = 0; k < j; k++) {
				if (sb.charAt(sb.length() - 1 - k) != sb.charAt(sb.length() - 1 - j - k)) {
					// 부분 수열이 다름을 알림
					flag = true;
					break;
				}
			}
			// 검사하는 동안 모두 같았다면
			if (!flag) {
				return false;
			}
		}

		return true;
	}
 
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		System.out.print(sb.toString());

		br.close();
	}

}
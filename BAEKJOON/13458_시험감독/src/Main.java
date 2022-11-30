import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());

		long result = 0;

		for (int i = 0; i < N; i++) {
			int A = Integer.parseInt(st1.nextToken());

			// 총감독관 한명 투입
			A -= B;
			int cnt = 1;

			// 응시자가 남았을 때, 부감독관 투입
			if (A > 0) {
				cnt += (A / C);
				if (A % C > 0) {
					cnt++;
				}
			}

			// 모든 응시자를 감시할 수 있으면 종료
			result += cnt;
		}

		System.out.print(result);

		br.close();
	}

}

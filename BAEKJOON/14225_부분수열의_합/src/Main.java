import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수열 초기화
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		// 방문 가능한 숫자는 모든 숫자를 선택하여 합한 수 까지이다.
		boolean[] visited = new boolean[sum + 2];

		for (int i = 1; i < 1 << n; i++) {
			int temp = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					temp += arr[j];
				}
			}
			visited[temp] = true;
		}
		int num = 1;
		while (true) {
			// 수열로 나올 수 없는 수가 있는경우
			if(!visited[num]) {
				break;
			}
			num++;
		}

		System.out.print(num);
		br.close();
	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성하세요.
			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken().toString());
			int K = Integer.parseInt(st.nextToken().toString());

			int[] arr = new int[12];
			int[] index = new int[N];

			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = 1;
				index[i] = i + 1;
				sum += i;
			}
			int curIndex = N - 1;
			while (true) {
				if (sum > K) {
					break;
				} else if (sum == K) {
					count++;
					continue;
				} else {
					arr[curIndex] = 0;
					curIndex++;
					if(curIndex > 11) {
						
					}
					arr[curIndex] = 1;
				}
			}
			System.out.println(count);
			// 0 1 2 3 4 5 6 7 8 9 10 11
			// 1 1 1 1 1 0 0 0 0 0 0  0 
			// 0 1 2 3 4
			// 4
		}
	}
}

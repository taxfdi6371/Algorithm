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
			int N = Integer.parseInt(st.nextToken().toString()); // 배열 크기
			int M = Integer.parseInt(st.nextToken().toString()); // 이웃한 M개

			int[] arr = new int[N];
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken().toString());
			}
			int sum = 0;

			for (int i = 0; i < M; i++) { // 0부터 M-1까지 초기화
				sum += arr[i];
			}
			int min = sum;
			int max = sum;
			
			int begin = 0;
			int end = M;

			for (int i = 0; i < N - M; i++) {
				sum -= arr[begin++]; // 제일 앞의 항 제거
				sum += arr[end++]; // 제일 뒤 다음 항 추가
				if (min > sum) {
					min = sum;
				}
				if (max < sum) {
					max = sum;
				}
			}
			System.out.println(max - min);
		}
	}
}

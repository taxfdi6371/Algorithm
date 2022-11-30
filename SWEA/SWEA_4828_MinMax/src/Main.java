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
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int min = 1000000;
			int max = 1;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken().toString());
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}
			}
			System.out.println(max - min);
		}
	}
}
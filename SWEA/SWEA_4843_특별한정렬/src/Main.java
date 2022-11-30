import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken().toString());
			}
			Arrays.sort(arr);
			int start = 0;
			int end = n-1;
			for (int i = 0; i < 5; i++) {
				System.out.print(arr[end--] + " " + arr[start++] + " ");
			}
			System.out.println();
		}
	}
}

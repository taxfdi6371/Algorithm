import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HelloSSAFY {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			
			// 여기서부터 알고리즘 작성하세요.
			
			
		}
	}
}
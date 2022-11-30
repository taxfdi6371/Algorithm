import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			
			// 여기서부터 알고리즘 작성하세요.
			int N = Integer.parseInt(in.readLine()); // 카드 장 수
			int[] arr = new int[10];
			String cards = in.readLine();
			
			int max = 0;
			int maxNum = 9;
			
			for (int i = 0; i < N; i++) {
				int card = cards.charAt(i) - '0';
				arr[card]++;
			}
			
			for (int i = 0; i < 10; i++) {
				if(arr[i] > max) {
					max = arr[i];
					maxNum = i;
				} else if(arr[i] == max) {
					if(i > maxNum) {
						maxNum = i;
					}
				}
			}
			System.out.println(maxNum + " " + max);
		}
	}
}

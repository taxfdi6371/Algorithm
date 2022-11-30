import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int[] w = { 4, 2, 1 }; // 가중치

		String n = br.readLine();
		int size = n.length();

		int e = 0; // 뒤에서부터 3칸씩 값 저장
		int wIdx = 2;

		StringBuilder sb = new StringBuilder();

		for (int i = size - 1; i >= 0; i--) {
			if (n.charAt(i) == '1') {
				e += w[wIdx];
			}
			
			wIdx--;
			
			// 3칸마다 8진수로 저장
			if (wIdx == -1) {
				sb.append(e);
				wIdx = 2;
				e = 0;
			}
		}

		// 앞에 남은 수가 있다면
		if (wIdx != 2) {
			sb.append(e);
		}

		System.out.print(sb.reverse().toString());

		br.close();
	}

}

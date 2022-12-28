import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int N = Integer.parseInt(br.readLine());

		int[] tower = new int[N + 1]; // 탑 높이
		int[] result = new int[N + 1]; // 어느 탑에서 수신하는지 저장할 배열

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		// 마지막 탑에서 부터 검사
		for (int i = N; i > 0; i--) {

			while (!stack.isEmpty()) {
				// 현재 선택된 탑의 높이 보다 스택에 담긴 탑의 높이가 같거나 작다면
				if (tower[i] >= tower[stack.peek()]) {
					// 스택에서 뽑고 송신된 탑의 번호 입력
					result[stack.pop()] = i;
				} else {
					break;
				}
			}

			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);

		br.close();
	}

}

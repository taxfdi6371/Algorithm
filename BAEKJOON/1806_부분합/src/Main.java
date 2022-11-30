import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>(); // 수열 숫자들을 저장
		int sum = 0; // 누적 합 
		int count = 0; // 누적 합 수열의 개수
		int result = Integer.MAX_VALUE; // 최소의 길이

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			q.add(n); // 수열 숫자 저장

			sum += n; // 누적 합
			count++; 

			// 누적 합에서 수열 앞에서부터 S와 크거나 같을 때 까지 뺌
			while (!q.isEmpty() && sum - q.peek() >= S) {
				sum -= q.poll();
				count--;
			}

			// 누적 합이 S 이상이고, 최소의 길이라면 갱신
			if (sum >= S && result > count) {
				result = count;
			}
		}

		// 모두 더해도 S와 크거나 같지 못할 경우
		if (result == Integer.MAX_VALUE) {
			System.out.print(0);
		} else {
			System.out.print(result);
		}

		br.close();
	}

}

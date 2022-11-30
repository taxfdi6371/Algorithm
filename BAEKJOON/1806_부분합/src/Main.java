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

		Queue<Integer> q = new LinkedList<>(); // ���� ���ڵ��� ����
		int sum = 0; // ���� �� 
		int count = 0; // ���� �� ������ ����
		int result = Integer.MAX_VALUE; // �ּ��� ����

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			q.add(n); // ���� ���� ����

			sum += n; // ���� ��
			count++; 

			// ���� �տ��� ���� �տ������� S�� ũ�ų� ���� �� ���� ��
			while (!q.isEmpty() && sum - q.peek() >= S) {
				sum -= q.poll();
				count--;
			}

			// ���� ���� S �̻��̰�, �ּ��� ���̶�� ����
			if (sum >= S && result > count) {
				result = count;
			}
		}

		// ��� ���ص� S�� ũ�ų� ���� ���� ���
		if (result == Integer.MAX_VALUE) {
			System.out.print(0);
		} else {
			System.out.print(result);
		}

		br.close();
	}

}

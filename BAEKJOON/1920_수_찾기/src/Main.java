import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static final int MAX_SIZE = 205311;
	static Node[] table;

	static class Node {
		long value;
		Node next;

		public Node(long value) {
			this.value = value;
		}
	}

	static int getIdx(long value) {
		if (value < 0) {
//			return (int) ((value + 1) * (-1)) % MAX_SIZE;
			value *= -1;
			int temp = (int) (value % MAX_SIZE); 
			return temp;
		}
		return (int) value % MAX_SIZE;
	}

	static void set(long value) {
		int idx = getIdx(value);

		if (table[idx] == null) {
			table[idx] = new Node(value);
		} else {
			Node node = new Node(value); // 새 노드 생성

			node.next = table[idx]; // 새 노드의 다음 노드는 기존 테이블에 있던 노드

			table[idx] = node; // 테이블에는 새 노드 삽입
		}
	}

	static boolean get(long value) {
		int idx = getIdx(value);

		Node node = table[idx];

		while (node != null) {

			if (node.value == value) {
				return true;
			}

			node = node.next;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		table = new Node[MAX_SIZE];

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			long n = Long.parseLong(st.nextToken());
			set(n);
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			long n = Long.parseLong(st.nextToken());

			if (get(n)) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}

		System.out.print(sb);

		br.close();
	}

}

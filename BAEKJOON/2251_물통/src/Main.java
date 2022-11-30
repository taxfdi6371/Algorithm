import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	static int C;

	static boolean visited[][][];

	static boolean[] result;

	static class State {
		int a;
		int b;
		int c;

		public State(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void bfs() {
		visited = new boolean[A + 1][B + 1][C + 1];
		Queue<State> q = new LinkedList<State>();
		q.add(new State(0, 0, C));

		while (!q.isEmpty()) {
			State state = q.poll();
			int a = state.a;
			int b = state.b;
			int c = state.c;

			if (visited[a][b][c]) {
				continue;
			} else {
				visited[a][b][c] = true;
			}

			if (a == 0) {
				result[c] = true;
			}

			// a -> b
			if (a + b < B) { // A에서 B로 이동하는데 둘을 합친 것이 B보다 작다면
				q.add(new State(0, a + b, c));
			} else {
				q.add(new State(a + b - B, B, c));
			}

			if (a + c < C) {
				q.add(new State(0, b, a + c));
			} else {
				q.add(new State(a + c - C, b, C));
			}

			if (b + a < A) {
				q.add(new State(b + a, 0, c));
			} else {
				q.add(new State(A, b + a - A, c));
			}

			if (b + c < C) {
				q.add(new State(a, 0, b + c));
			} else {
				q.add(new State(a, b + c - C, C));
			}

			if (c + a < A) {
				q.add(new State(c + a, b, 0));
			} else {
				q.add(new State(A, b, c + a - A));
			}

			if (c + b < B) {
				q.add(new State(a, c + b, 0));
			} else {
				q.add(new State(a, B, c + b - B));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		result = new boolean[C + 1];

		bfs();

		for (int i = 0; i < C + 1; i++) {
			if (result[i]) {
				System.out.print(i + " ");
			}
		}

		br.close();
	}

}

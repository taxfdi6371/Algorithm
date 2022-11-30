import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;

	static boolean[] visited;
	static int[] d;

	static boolean idxCheck(int n) {
		if (n >= 0 && n < 200001)
			return true;
		return false;
	}

	static void dijkstra() {
		visited = new boolean[200001];
		d = new int[200001];
		Arrays.fill(d, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();

		d[N] = 0;
		
		if (idxCheck(N - 1)) {
			q.add(N - 1);
			d[N - 1] = 1;
		}

		if (idxCheck(N + 1)) {
			q.add(N + 1);
			d[N + 1] = 1;
		}

		if (idxCheck(N * 2)) {
			q.add(N * 2);
			d[N * 2] = 0;
		}

		visited[N] = true;

		while (!q.isEmpty()) {
			int n = q.poll();

			if (visited[n])
				continue;

			if (idxCheck(n - 1)) {
				q.add(n - 1);
				d[n - 1] = Math.min(d[n - 1], d[n] + 1);
			}

			if (idxCheck(n + 1)) {
				q.add(n + 1);
				d[n + 1] = Math.min(d[n + 1], d[n] + 1);
			}

			if (idxCheck(n * 2)) {
				q.add(n * 2);
				d[n * 2] = Math.min(d[n * 2], d[n]);
			}

			visited[n] = true;
		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dijkstra();

		System.out.print(d[K]);

		br.close();
	}
}

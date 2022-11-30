import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static PriorityQueue<Road>[] matrix;
	public static PriorityQueue<Road> pq;
	public static int d[];
	public static int result;

	static class Road implements Comparable<Road> {
		int e;
		int c;

		public Road(int e, int c) {
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Road o) {
			return c - o.c;
		}
	}

	public static void prim(int start) {
		d = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		pq = new PriorityQueue<>();
		int cnt = 0;

		int v = start;
		d[v] = 0;
		pq.add(matrix[v].poll());

		while (!pq.isEmpty()) {
			Road road = pq.poll();
			
			if (road.c < d[road.e]) {
				d[road.e] = road.c;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new PriorityQueue[N + 1];

		for (int i = 0; i <= N; i++) {
			matrix[i] = new PriorityQueue<>();
		}

		int minS = 0; // 시작정점
		int minC = 1001;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (c < minC) {
				minS = v1;
				minC = c;
			}

			matrix[v1].add(new Road(v2, c));
			matrix[v2].add(new Road(v1, c));
		}

		prim(minS);

		System.out.println(result);

		br.close();
	}

}

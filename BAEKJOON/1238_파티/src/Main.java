import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int X;

	static ArrayList<Village>[] map;
	static int[] distVtoP;
	static int[] distPtoV;

	static class Village implements Comparable<Village> {
		int n;
		int t;

		public Village(int n, int t) {
			this.n = n;
			this.t = t;
		}

		@Override
		public int compareTo(Village o) {
			return this.t - o.t;
		}

	}

	// �������� ��Ƽ���� �ּҰŸ�
	static void djikstra(int start) {
		int[] d = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);

		PriorityQueue<Village> pq = new PriorityQueue<>();

		d[start] = 0;

		for (int i = 0; i < map[start].size(); i++) {
			Village v = map[start].get(i);

			d[v.n] = v.t;
			pq.add(new Village(v.n, v.t));
		}

		while (!pq.isEmpty()) {
			Village v = pq.poll();

			if (d[v.n] < v.t)
				continue;

			for (int i = 0; i < map[v.n].size(); i++) {
				Village nextV = map[v.n].get(i); // pq���� �̾Ƴ� v���� ����� Ư�� ���� ����

				// ���� ���������� ���̰� ���ŵǴ� ���
				if (d[nextV.n] > d[v.n] + nextV.t) {
					d[nextV.n] = d[v.n] + nextV.t;
					pq.add(new Village(nextV.n, d[v.n] + nextV.t));
				}
			}
		}

		distVtoP[start] = d[X];
	}

	// ��Ƽ���� ����(X)���� �ּ� �Ÿ�
	static void djikstra() {
		int[] d = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);

		PriorityQueue<Village> pq = new PriorityQueue<>();

		d[X] = 0;

		for (int i = 0; i < map[X].size(); i++) {
			Village v = map[X].get(i);

			d[v.n] = v.t;
			pq.add(new Village(v.n, v.t));
		}

		while (!pq.isEmpty()) {
			Village v = pq.poll();
			
			if (d[v.n] < v.t)
				continue;

			for (int i = 0; i < map[v.n].size(); i++) {
				Village nextV = map[v.n].get(i);

				// ���� ���������� ���̰� ���ŵǴ� ���
				if (d[nextV.n] > d[v.n] + nextV.t) {
					d[nextV.n] = d[v.n] + nextV.t;
					pq.add(new Village(nextV.n, d[v.n] + nextV.t));
				}
			}
		}

		distPtoV = d;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		distVtoP = new int[N + 1];
		distPtoV = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			map[start].add(new Village(end, t));
		}
		
		// Ư�� �������� ��Ƽ���� �Ÿ� ���ϱ�
		for (int i = 1; i <= N; i++) {
			djikstra(i);
		}
		djikstra(); // ��Ƽ���� ��� �������� �Ÿ� ���ϱ�

		int result = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			if(distVtoP[i] + distPtoV[i] > result) {
				result = distVtoP[i] + distPtoV[i];
			}
		}
		
		System.out.println(result);
		
		br.close();
	}

}

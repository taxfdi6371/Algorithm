import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n; // 노드의 개수
	static boolean[] tNode; // 단말 노드 배열
	static ArrayList<Node>[] tree; // 트리
	static boolean[] visited;
	static int result;

	static class Node {
		int num; // 연결된 노드 번호
		int w; // 가중치

		Node(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}

	static void dfs(int num, int sum) {
		result = Math.max(result, sum);

		
		for (int i = 0; i < tree[num].size(); i++) {
			// 연결된 노드 하나를 가지고 온다.
			Node node = tree[num].get(i);

			// 방문한 적이 없으면 계속
			if (!visited[node.num]) {
				visited[node.num] = true;
				dfs(node.num, sum + node.w);
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		n = Integer.parseInt(br.readLine());
		tNode = new boolean[n + 1];
		tree = new ArrayList[n + 1];
		result = 0;

		Arrays.fill(tNode, true);

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		tNode[1] = false;
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 자식이 있는 노드는 단말 노드가 아니다.
			tNode[p] = false;

			tree[p].add(new Node(c, w));
			tree[c].add(new Node(p, w));
		}

		for (int i = 1; i <= n; i++) {
			// 단말 노드일 경우
			if (tNode[i]) {
				visited = new boolean[n + 1];
				visited[i] = true; // 자기 자신 
				
				Node node = tree[i].get(0);
				
				visited[node.num] = true;
				dfs(node.num, node.w);
			}
		}

		System.out.print(result);
		
		br.close();
	}

}
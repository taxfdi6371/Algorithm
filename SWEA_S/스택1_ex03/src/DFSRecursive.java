import java.util.StringTokenizer;

public class DFSRecursive {

	public static boolean[] visited = new boolean[8];
	
	public static void dfs_recursive(int[][] graph, int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= 7; i++) {
			if(graph[v][i] == 1 && visited[i] == false) {
				dfs_recursive(graph, i);
			}
		}
	}
	
	public static void main(String[] args) {
		String input = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
		
		int[][] graph = new int[8][8];
		
		StringTokenizer st = new StringTokenizer(input);
		while(st.hasMoreTokens()) {
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[w][v] = 1;
			graph[v][w] = 1;
		}
		
		dfs_recursive(graph, 1);
	}

}

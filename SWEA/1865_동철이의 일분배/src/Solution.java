import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	static int N;
	static boolean[] visited;
	static double[][] p;
	static double maxP;
	
	static void dfs(double curP, int d) {
		if(curP <= maxP) {
			return;
		}
		if(d == N) {
			maxP = curP;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(curP * p[i][d], d + 1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			
			visited = new boolean[N];
			p = new double[N][N];
			maxP = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					p[i][j] = sc.nextInt() * 0.01;
				}
			}
			
			dfs(1, 0);
			
			System.out.printf("#%d %.6f\n", test_case, maxP*100);
		}
	}
}
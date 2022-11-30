package 트리_ex01;

import java.util.StringTokenizer;

public class TreePreorder {
	public static int[][] tree;
	public static StringBuilder sb;
	
	public static void preorder(int v) {
		if(v != 0) {
			sb.append(v).append(" ");
			preorder(tree[v][0]);
			preorder(tree[v][1]);
		}
	}
	
	public static void main(String[] args) {
		int n = 13;
		String str = "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
		
		tree = new int[n+1][2];
		StringTokenizer st = new StringTokenizer(str);
		sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			int v = Integer.parseInt(st.nextToken());
			if(tree[v][0] == 0) {
				tree[v][0] = Integer.parseInt(st.nextToken());
			} else {
				tree[v][1] = Integer.parseInt(st.nextToken());				
			}
		}
		
		preorder(1);
		
		System.out.println(sb);
		
	}

}

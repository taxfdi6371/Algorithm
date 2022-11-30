package com.ssafy.day5;

import java.util.Scanner;

//
//public class day5_1267_작업순서 {
//	public static int G[][] = new int [1001][1002]; //G[x][0] input degree G[x][1] output degree
//	public static int q[] = new int[2001];
//	public static int f, r;
//
//	public static void init(int V)
//	{
//		f = r = -1;
//
//		for (int i = 1; i <= V; i++)
//			G[i][0] = G[i][1] = 0;
//	}
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        for(int tc = 1; tc <= 10; tc++) {
//    		int V, E;
//    		V = sc.nextInt();  
//    		E = sc.nextInt();
//
//    		init(V);
//
//    		for (int i = 0; i < E; i++)
//    		{
//    			int u, v;
//    			u = sc.nextInt(); 
//				v = sc.nextInt();
//    			G[u][++G[u][1] + 1] = v;
//    			G[v][0]++;
//    		}
//
//    		for (int i = 1; i <= V; i++)
//    			if (G[i][0] == 0) q[++r] = i;
//    		
//    		System.out.printf("#%d ", tc);    		
//    		
//    		int x;
//    		while (f != r)
//    		{
//    			System.out.printf("%d ", x = q[++f]);
//    			for (int i = 0; i < G[x][1]; i++)
//    				if (--G[G[x][2 + i]][0] == 0) q[++r] = G[x][2 + i];
//    		}
//
//    		System.out.println();
//	    }
//        sc.close();
//    }
//}




public class day5_1267_작업순서 {
	public static int G[][] = new int [1001][1002]; //G[x][0] input degree G[x][1] output degree
	public static boolean visited[] = new boolean[1001];
	public static int V, E;	
	
	public static void dfs(int v)
	{
		for (int i = 0; i < G[v][1]; i++)
		{
			if (!visited[G[v][2 + i]]) dfs(G[v][2 + i]);
		}

		visited[v] = true;
		System.out.printf("%d ", v);
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
    		int V, E;
    		V = sc.nextInt();  
    		E = sc.nextInt();

    		for (int i = 1; i <= V; i++) {
    			visited[i] = false;
    			G[i][0] = G[i][1] = 0;
    		}

    		for (int i = 0; i < E; i++)
    		{
    			int u, v;
    			u = sc.nextInt(); 
				v = sc.nextInt();
    			G[v][++G[v][1] + 1] = u;
    			G[u][0]++;
    		}
    		
    		System.out.printf("#%d ", tc);    		
    		
    		for (int i = 1; i <= V; i++)
    		{
    			if (!visited[i]) dfs(i);
    		}

    		System.out.println();
	    }
        sc.close();
    }
}








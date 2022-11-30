package com.ssafy.day4;

import java.util.Scanner;

public class day4_1219_길찾기 {
	
	public static boolean [] visited = new boolean [100];
	public static int [][] G = new int [100][2];
	public static int [] stack = new int [100];
	public static int top;
	
	public static void init()
	{
		top = -1;

		for (int i = 0; i < 100; i++) {
			G[i][0] = G[i][1] = 0;
			visited[i] = false;
		}
	}
	
	public static int DFSr(int v)
	{
		if (v == 99) return 1;
		
		visited[v] = true;

		if (!visited[G[v][0]] && DFSr(G[v][0]) == 1)	return 1;
		if (!visited[G[v][1]] && DFSr(G[v][1]) == 1)	return 1;

		return 0;
	}
	
	
	
	public static int DFS(int v)
	{
	
		stack[++top] = v;
	
		while (top != -1)
		{
			v = stack[top--];
	
			if (!visited[v])
			{
				visited[v] = true;
				if (G[v][0] == 99 || G[v][1] == 99) return 1;
				if (G[v][0] > 0 && !visited[G[v][0]]) stack[++top] = G[v][0];
				if (G[v][1] > 0 && !visited[G[v][1]]) stack[++top] = G[v][1];
			}
		}
	
		return 0;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
        	int n;
        	sc.nextInt();
	        n = sc.nextInt();
	        init();

	        for (int i = 0, s, t; i < n; i++)
	        {
	        	s = sc.nextInt();
	        	t = sc.nextInt();

	        	if (G[s][0] == 0) G[s][0] = t;
	        	else G[s][1] = t;
	        }
	         
	        System.out.println("#" + tc + " " + DFS(0));
	    }
    }
}








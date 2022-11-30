package com.ssafy.day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day10_1861_정사각형방 {
     
    static int N;
    static int K;
    static int[][] mat;
    static boolean[] visited;
    static int start, ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    

    public static int solve(int x, int y)
    {
    	visited[mat[x][y]] = true;

    	for (int i = 0; i < 4; i++)
    	{
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
    		if (mat[xx][yy] - mat[x][y] == 1)
    		{
    			return solve(xx, yy) + 1;
    		}
    	}

    	return 1;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("day10_1861_���簢����.txt"));
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
         
        for (int tc = 1; tc <= TC; tc++) {
             
            N = sc.nextInt();
            mat = new int[N][N];
            visited = new boolean[N*N + 1];
             
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < N; j++)
    				mat[i][j] = sc.nextInt();
            
    		start = ans = 0;
    		for (int i = 0; i < N; i++)
    		{
    			for (int j = 0; j < N; j++)
    			{
    				int cnt = 0;
    				if (!visited[mat[i][j]])
    					cnt = solve(i, j);
    				if (cnt == ans)
    					start = start > mat[i][j] ? mat[i][j] : start;
    				else if (cnt > ans) {
    					ans = cnt;
    					start = mat[i][j];
    				}
    			}
    		}
            

            System.out.printf("#%d %d %d\n", tc, start, ans);
        }
        sc.close();
    }
}



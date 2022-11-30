package com.ssafy.day18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Solution {
public class 탈주범검거1953 {

	public static int N, M, R, C, L;
	public static int mat[][];
	public static int visited[][];
	public static int ans;
	public static boolean tunnel[][] = 
		{ { false, false, false, false },	// 상, 하, 좌, 우
		  { true,  true,  true,  true },  	//1번 터널
	      { true,  true,  false, false }, 	//2
	      { false, false, true,  true },  	//3
	      { true,  false, false, true },  	//4
	      { false, true,  false, true },	//5
	      { false, true,  true,  false },	//6
	      { true,  false, true,  false } };	//7

	public static int dx[] = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	public static int dy[] = { 0, 0, -1, 1 };

	public static int q[][] = new int [2500][2];
	public static int f, r;
	
	public static void solve(int x, int y)
	{
		q[++r][0] = x;
		q[r][1] = y;

		visited[x][y] = 1;
		ans++;

		while (f != r)
		{
			x = q[++f][0];
			y = q[f][1];

			if (visited[x][y] == L) return;

			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i];
				int yy = y + dy[i];

				if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				if (visited[xx][yy] > 0 || mat[xx][yy] == 0) continue;

				if ((i == 0 && tunnel[mat[x][y]][0] && tunnel[mat[xx][yy]][1]) || 
					(i == 1 && tunnel[mat[x][y]][1] && tunnel[mat[xx][yy]][0]) || 
					(i == 2 && tunnel[mat[x][y]][2] && tunnel[mat[xx][yy]][3] ) || 
					(i == 3 && tunnel[mat[x][y]][3] && tunnel[mat[xx][yy]][2]))
				{
					q[++r][0] = xx;
					q[r][1] = yy;
					ans++;
					visited[xx][yy] = visited[x][y] + 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//long start = System.currentTimeMillis();
		
		//System.setIn(new FileInputStream("탈주범검거1953input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

        	N = sc.nextInt();
        	M = sc.nextInt();
        	R = sc.nextInt();
        	C = sc.nextInt();
        	L = sc.nextInt();
        	
        	mat = new int [N][M];
        	visited = new int [N][M];
        			 
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < M; j++)
    				mat[i][j] = sc.nextInt();
            
            f = r = -1;
        	ans = 0;
        	
    		solve(R, C);
  		
    		System.out.printf("#%d %d\n", tc, ans);
	    }
        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}




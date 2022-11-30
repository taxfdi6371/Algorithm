package com.ssafy.day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Solution {
public class 요리사4012 {

	public static int mat[][] = new int [16][16];
	public static int tA[] = new int [8];
	public static int tB[] = new int [8];
	public static int ans;
	public static int N, R;
	
	public static void solve(int k, int sel)
	{
		if (k == R)
		{
			int foodA = 0, foodB = 0;
			int selected = 0;

			for (int i = 0; i < R; i++)
				selected ^= (1 << tA[i]);

			int tcnt = 0;
			for (int i = 0; i < N; i++)
				if ((selected & (1 << i)) == 0)
					tB[tcnt++] = i;

			for (int i = 0; i < R - 1; i++)
				for (int j = i + 1; j < R; j++)
					foodA += (mat[tA[i]][tA[j]] + mat[tA[j]][tA[i]]);

			for (int i = 0; i < R - 1; i++)
				for (int j = i + 1; j < R; j++)
					foodB += (mat[tB[i]][tB[j]] + mat[tB[j]][tB[i]]);

			ans = Math.min(ans, Math.abs(foodA - foodB));
		}
		else
		{
			for (int i = sel; i < N + (k - R) + 1; i++)
			{
				tA[k] = i;
				solve(k + 1, i + 1);
			}
		}
	}

	

	public static void main(String[] args) throws FileNotFoundException {
		
		//long start = System.currentTimeMillis();
		
		//System.setIn(new FileInputStream("요리사4012input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

        	N = sc.nextInt();
        	
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < N; j++)
    				mat[i][j] = sc.nextInt();
    		 
			R = N / 2;
			ans = Integer.MAX_VALUE;
			solve(0, 0);
    		
    		System.out.printf("#%d %d\n", tc, ans);
	    }
        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}



package com.ssafy.day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day10_6109_추억의2048게임 {

	public static int[][] arr;
	public static int[][] ans;
	public static int[] Q;
	public static int f, r;
	public static int N;
	public static String dir;
	
	public static void UP()
	{
		for(int y = 0; y < N; y++) 
		{
			f = r = -1;
			for(int x = 0; x < N; x++)
				if(arr[x][y] != 0)
					Q[++r] = arr[x][y];
			
			if(r == -1) continue;
			
			for(int i = 0; i < r; i++) {
				if(Q[i] == Q[i+1]) {
					Q[i] *= 2;
					Q[i+1] = 0;
				}
			}
			
			int ansI = 0;
			for(int i = 0; i <= r; i++) 
				if(Q[i] != 0)
					ans[ansI++][y] = Q[i];
			
		}
	}
	
	public static void DOWN()
	{
		for(int y = 0; y < N; y++) 
		{
			f = r = -1;
			for(int x = N - 1; x > -1; x--)
				if(arr[x][y] != 0)
					Q[++r] = arr[x][y];
			
			if(r == -1) continue;
			
			for(int i = 0; i < r; i++) {
				if(Q[i] == Q[i+1]) {
					Q[i] *= 2;
					Q[i+1] = 0;
				}
			}
			
			int ansI = N - 1;
			for(int i = 0; i <= r; i++) 
				if(Q[i] != 0)
					ans[ansI--][y] = Q[i];
			
		}
	}
	
	public static void RIGHT()
	{
		for(int x = 0; x < N; x++) 
		{
			f = r = -1;
			for(int y = N - 1; y > -1; y--)
				if(arr[x][y] != 0)
					Q[++r] = arr[x][y];
			
			if(r == -1) continue;
			
			for(int i = 0; i < r; i++) {
				if(Q[i] == Q[i+1]) {
					Q[i] *= 2;
					Q[i+1] = 0;
				}
			}
			
			int ansI = N - 1;
			for(int i = 0; i <= r; i++) 
				if(Q[i] != 0)
					ans[x][ansI--] = Q[i];
			
		}
	}
	
	public static void LEFT()
	{
		for(int x = 0; x < N; x++) 
		{
			f = r = -1;
			for(int y = 0; y < N; y++)
				if(arr[x][y] != 0)
					Q[++r] = arr[x][y];
			
			if(r == -1) continue;
			
			for(int i = 0; i < r; i++) {
				if(Q[i] == Q[i+1]) {
					Q[i] *= 2;
					Q[i+1] = 0;
				}
			}
			
			int ansI = 0;
			for(int i = 0; i <= r; i++) 
				if(Q[i] != 0)
					ans[x][ansI++] = Q[i];
			
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		System.setIn(new FileInputStream("day10_6109_input.txt"));
        Scanner sc = new Scanner(System.in);

    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
        	
        	N = sc.nextInt();
        	dir = sc.next();
        	
        	arr = new int [N][N];
        	ans = new int [N][N];
        	Q = new int [N];
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextInt();
        	
        	if(dir.equals("up")) UP();
        	else if(dir.equals("down")) DOWN();
        	else if(dir.equals("right")) RIGHT();
        	else 
        		LEFT();
 
			System.out.printf("#%d\n", tc);
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++)
        			System.out.printf("%d ", ans[i][j]);
        		System.out.println();
        	}
			
    		
	    }
        sc.close();
    }
}














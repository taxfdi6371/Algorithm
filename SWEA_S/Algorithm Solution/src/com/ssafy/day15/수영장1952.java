package com.ssafy.day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Solution {
public class 수영장1952 {

	public static int D_f, M_f, M3_f, Y_f;
	public static int arr[] = new int [12];
	public static int ans;
	
	
	public static int solveDP() {
	    int DP[] = new int [13];

	    DP[1] = Math.min(D_f * arr[0], M_f);
	    DP[2] = DP[1] + Math.min(D_f * arr[1], M_f);
	    
	    for (int i = 3; i <= 12; i++)
	    	DP[i] = Math.min((DP[i-1] + Math.min(D_f * arr[i-1], M_f)), DP[i-3] + M3_f);

	    return Math.min(DP[12], Y_f);
	}
	
	
	public static void solve(int c, int s)
	{
		if (s >= ans) return;
		
		if (c >= 12) {
			ans = s;
		}
		else {
			solve(c + 1, s + D_f * arr[c]);
			solve(c + 1, s + M_f);
			solve(c + 3, s + M3_f);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("수영장1952input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

        	D_f = sc.nextInt();
        	M_f = sc.nextInt();
        	M3_f = sc.nextInt();
        	Y_f = sc.nextInt();
        	
    		for (int i = 0; i < 12; i++)
    			arr[i] = sc.nextInt();

    		ans = Y_f;
     		solve(0, 0);
    		System.out.printf("#%d %d\n", tc, ans);
    		
//    		System.out.printf("#%d %d\n", tc, solveDP());
    		

	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}


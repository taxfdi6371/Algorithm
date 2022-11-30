package com.ssafy.day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Solution {
public class 숫자만들기4008 {

	public static int N;
	public static int nums[] = new int [12];
	public static int ops[] = new int [4];
	public static int maxans;
	public static int minans;
	public static int CNT;
	
	
	public static void solve(int k, int v ) {
		CNT++;
		
		if (k == N)
		{
			maxans = Math.max(maxans, v);
			minans = Math.min(minans, v);
		}
		 
		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				ops[i]--;
				
				switch (i) {
					case 0 : solve(k + 1, v + nums[k]); break;
					case 1 : solve(k + 1, v - nums[k]); break; 
					case 2 : solve(k + 1, v * nums[k]); break;
					case 3 : solve(k + 1, v / nums[k]); break;
				}
				ops[i]++;
			}
		}
	}
	
//	public static void solve(int k, int v)
//	{
//		if (k == N)
//		{
//			maxans = Math.max(maxans, v);
//			minans = Math.min(minans, v);
//		}
//		else
//		{
//			if (ops[0] != 0)
//			{
//				ops[0]--;
//				solve(k + 1, v + nums[k]);
//				ops[0]++;
//			}
//			if (ops[1] != 0)
//			{
//				ops[1]--;
//				solve(k + 1, v - nums[k]);
//				ops[1]++;
//			}
//			if (ops[2] != 0)
//			{
//				ops[2]--;
//				solve(k + 1, v * nums[k]);
//				ops[2]++;
//			}
//			if (ops[3] != 0)
//			{
//				ops[3]--;
//				solve(k + 1, v / nums[k]);
//				ops[3]++;
//			}
//		}
//	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("숫자만들기4008input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

        	N = sc.nextInt();
    		
        	for (int i = 0; i < 4; i++)
    			ops[i] = sc.nextInt();
    		
    		for (int i = 0; i < N; i++)
    			nums[i] = sc.nextInt();

    		maxans = Integer.MIN_VALUE;
    		minans = Integer.MAX_VALUE;
    		

    		solve(1, nums[0]);
    		
    		System.out.printf("#%d %d %d\n", tc, maxans - minans, CNT);
    		//System.out.printf("#%d %d\n", tc, maxans - minans);
	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}
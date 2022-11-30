package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 정곤이의단조증가하는수6190 {
	
	static boolean solve(int val) {
		int t = val % 10;
		val = val / 10;
		
		while(val > 0) {
			if(val % 10 > t) return false;
			
			t = val % 10;
			val = val / 10;
		}
		return true;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++) 
            	nums[i] = sc.nextInt();
            
            int ans = -1;
            for(int i = 0; i < N - 1; i++) {
            	for(int j = i + 1; j < N; j++) {
            		int tval = nums[i] * nums[j];
            		if(solve(tval) && ans < tval)
            			ans = tval;
            	}
            }
             
            System.out.println("#" + tc + " " + ans);
            //System.out.print("#" + tc + " " + ans);
        }
        sc.close();
    }
}




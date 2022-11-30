package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 두개의숫자열1959 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
            int[] Narr = new int[N];
            int[] Marr = new int[M];
            
            for(int i = 0; i < N; i++)
            	Narr[i] = sc.nextInt();
            
            for(int i = 0; i < M; i++)
            	Marr[i] = sc.nextInt();
            
            int ans = 0;
            int sum = 0;
            
            if (N < M) {
            	for(int i = 0; i < M - N + 1; i++) {
            		sum = 0;
            		for (int j = 0; j < N; j++)
            			sum += (Marr[i + j] * Narr[j]);
            		if (ans < sum) ans = sum;
            	}
            }
            else {
            	for(int i = 0; i < N - M + 1; i++) {
            		sum = 0;
            		for (int j = 0; j < M; j++)
            			sum += (Narr[i + j] * Marr[j]);
            		if (ans < sum) ans = sum;
            	}
            }

             
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }
}

package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 파리퇴치2001 {
	
	static int[][] arr;
	static int M;
	
	static int cal(int x, int y) {
		int sum = 0;
		
        for(int i = x; i < x + M; i++) 
        	for(int j = y; j < y + M; j++) 
        		sum += arr[i][j];
		
		return sum;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	int N = sc.nextInt();
        	M = sc.nextInt();
        	
            arr = new int[N][N];
            
            for(int i = 0; i < N; i++) 
            	for(int j = 0; j < N; j++) 
            		arr[i][j] = sc.nextInt();
            
            int maxans = 0;

            for(int i = 0; i < N - M + 1; i++) {
            	for(int j = 0; j < N - M + 1; j++) {
            		int ret = cal(i, j);
            		if(ret > maxans) maxans = ret;  
            	}
            }
             
            System.out.println("#" + tc + " " + maxans);
        }
        sc.close();
    }
}


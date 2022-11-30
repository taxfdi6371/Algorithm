package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 농작물수확하기2805 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	int N = sc.nextInt();
            int[][] farm = new int[N][N];
            
            for(int i = 0; i < N; i++) {
            	String ttt = sc.next();
            	for(int j = 0; j < N; j++) 
            		farm[i][j] = ttt.charAt(j) - '0';
            }
            int center = N / 2;
            int ans = 0;

            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		if((Math.abs(center - i) + Math.abs(center - j)) <= center)
            			ans = ans + farm[i][j];  
            	}
            }
             
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }
}



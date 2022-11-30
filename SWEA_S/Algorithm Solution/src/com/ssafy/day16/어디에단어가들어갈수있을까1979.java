package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 어디에단어가들어갈수있을까1979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	
            int [][] arr = new int[N][N];
            int [][] arrH = new int[N][N];
            
            for(int i = 0; i < N; i++) 
            	for(int j = 0; j < N; j++) 
            		arrH[i][j] = arr[i][j] = sc.nextInt();
            
            int cnt = 0;
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N - K + 1; j++) {
    	            int jj = j;
    	            while (jj < N && arr[i][jj] == 1) {
    	            	arr[i][jj] = 0;
    	                jj++;
    	            }

    	            if(jj - j == K)
    	            	cnt++;
	            }
        	}
            
            for(int i = 0; i < N - K + 1; i++) {
            	for(int j = 0; j < N; j++) {
    	            int ii = i;
    	            while (ii < N && arrH[ii][j] == 1) {
    	            	arrH[ii][j] = 0;
    	            	ii++;
    	            }

    	            if(ii - i == K)
    	            	cnt++;
	            }
        	}            
            
            System.out.println("#" + tc + " " + cnt);
        }
        sc.close();
    }
}

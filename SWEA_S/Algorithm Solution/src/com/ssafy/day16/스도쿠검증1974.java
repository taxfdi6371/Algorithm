package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 스도쿠검증1974 {
	static int [][] sudoku = new int [9][9];
	static int ans;
	
	static void check(int x, int y) {

		int [] cnt = new int[10]; ////위치
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				if(cnt[sudoku[i][j]] != 0)
	    			ans = 0;
	    		else
	    			cnt[sudoku[i][j]] = 1;
			}
		}
		
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
            
            for(int i = 0; i < 9; i++) 
            	for(int j = 0; j < 9; j++) 
            		sudoku[i][j] = sc.nextInt();

        	ans = 1;
            
            for(int i = 0; i < 9; i++) {
            	int [] cnt = new int[10];
            	for(int j = 0; j < 9; j++) {
            		if(cnt[sudoku[i][j]] != 0)
            			ans = 0;
            		else
            			cnt[sudoku[i][j]] = 1;
            	}
            }
            
            for(int i = 0; i < 9; i++) {
            	int [] cnt = new int[10];
            	for(int j = 0; j < 9; j++) {
            		if(cnt[sudoku[j][i]] != 0)
            			ans = 0;
            		else
            			cnt[sudoku[j][i]] = 1;
            	}
            }

            for(int i = 0; i < 3; i++) 
            	for(int j = 0; j < 3; j++) 
            		check(i*3, j*3);
             
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }

}

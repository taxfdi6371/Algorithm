package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
// 1 : black, 2 : white
public class 재미있는오셀로게임4615 {
	
	static int [][] board;
	static int N;
	
	static int [] dx = { 0,  1, 1, 1, 0, -1, -1, -1};
	static int [] dy = {-1, -1, 0, 1, 1,  1,  0, -1};
	
	static void makeboard(int boardsize) {
		if(boardsize == 4) {
			board = new int [][] 
					{{0, 0, 0, 0}, 
					{0, 2, 1, 0}, 
					{0, 1, 2, 0}, 
					{0, 0, 0, 0}};
		}
		
		if(boardsize == 6) {
			board = new int [][] 
					{{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 2, 1, 0, 0},
					{0, 0, 1, 2, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0}};
		}
		
		if(boardsize == 8) {
			board = new int [][] 
					{{0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 2, 1, 0, 0, 0},
		             {0, 0, 0, 1, 2, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 0, 0},
		             {0, 0, 0, 0, 0, 0, 0, 0}};
		}
	}
	
	static boolean isWall(int x, int y) {
	    if (x < 0 || x >= N || y < 0 || y >= N) return true;
	    return false;
	}
	
	static boolean isFoundmydol(int x, int y, int dir, int dol) {
		int newX = x + dx[dir];
		int newY = y + dy[dir];
		
		while(!isWall(newX, newY) &&
			  board[newX][newY] != 0 && 
			  board[newX][newY] != dol) 
		{
			newX += dx[dir];
			newY += dy[dir];
		}
		
		if(isWall(newX, newY)) return false;
		if(board[newX][newY] != dol) return false;
		
		return true;
	}

	static void updateboard(int x, int y, int dol) {
		
		board[x][y] = dol;
		
		for(int i = 0; i < 8; i++) {
			
			if(!isFoundmydol(x, y, i, dol)) continue;
			
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			while(!isWall(newX, newY) && board[newX][newY] != dol) 
			{
				board[newX][newY] = dol;
				newX += dx[i];
				newY += dy[i];
			}
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	N = sc.nextInt();
        	int roundcnt = sc.nextInt();
        	
        	makeboard(N);
        	
        	for(int i = 0; i < roundcnt; i++) {
        		int x = sc.nextInt();
        		int y = sc.nextInt();
        		int dol = sc.nextInt();
        		
        		updateboard(x - 1, y - 1, dol);
        	}

        	int cnt1 = 0, cnt2 = 0;
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(board[i][j] == 1) cnt1++;
        			if(board[i][j] == 2) cnt2++;
        		}
        	}
             
            System.out.println("#" + tc + " " + cnt1 + " " + cnt2);
        }
        sc.close();
    }
}

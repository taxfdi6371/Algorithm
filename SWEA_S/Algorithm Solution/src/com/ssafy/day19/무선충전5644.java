package com.ssafy.day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


class BC{
	public int x;
	public int y;
	public int distance;
	public int perfomance;
}

class User{
	public int x, y;
}

//public class Solution {
public class 무선충전5644 {
	final static int USERA = 0;
	final static int USERB = 1;
	static int Mtime, BCcnt;
	static User userA = new User();
	static User userB = new User();
	static int [][] move;	// user, direction
	static BC [] bc;
	static int dx[] = { 0, 0, 1, 0, -1 }; // X, 상, 우, 하, 좌
	static int dy[] = { 0, -1, 0, 1, 0 };
	
	static int getDistBC(int x, int y, int ithBC) {
		return Math.abs(x - bc[ithBC].x) + Math.abs(y - bc[ithBC].y);
	}
	
	static int calMaxCharging() {
		int ret = 0;
		
		for(int i = 0; i < BCcnt; i++) {
			for(int j = 0; j < BCcnt; j++) {
				int tsum = 0;
				if(i == j &&
				   getDistBC(userA.x, userA.y, i) <= bc[i].distance &&
				   getDistBC(userB.x, userB.y, i) <= bc[i].distance) 
				{
						tsum = bc[i].perfomance;
					
				}
				else {
					if(getDistBC(userA.x, userA.y, i) <= bc[i].distance)
						tsum += bc[i].perfomance;
					
					if(getDistBC(userB.x, userB.y, j) <= bc[j].distance)
						tsum += bc[j].perfomance;
				}
				
				ret = Math.max(tsum, ret);
			}
		}
		return ret;
	}
	
	static int solve() {
		int ans = 0;
		ans += calMaxCharging();
		
		for(int i = 0; i < Mtime; i++) {
			userA.x += dx[move[USERA][i]];
			userA.y += dy[move[USERA][i]];
			
			userB.x += dx[move[USERB][i]];
			userB.y += dy[move[USERB][i]];
			
			ans += calMaxCharging();
		}
		return ans;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		long start = System.currentTimeMillis();
//		
//		System.setIn(new FileInputStream("무선충전5644input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

        	Mtime = sc.nextInt();	//이동 시간
        	BCcnt = sc.nextInt();	//BC의 개수
        	
        	move = new int [2][Mtime];
        	
        	for(int i = 0; i < 2; i++)
        		for(int j = 0; j < Mtime; j++)
        			move[i][j] = sc.nextInt();
        	
        	bc = new BC [BCcnt]; 
        	
        	for(int i = 0; i < BCcnt; i++) {
        		bc[i] = new BC();
        		bc[i].x = sc.nextInt();
        		bc[i].y = sc.nextInt();
        		bc[i].distance = sc.nextInt();
        		bc[i].perfomance = sc.nextInt();
        	}
    		
        	userA.x = 1;
        	userA.y = 1;

        	userB.x = 10;
        	userB.y = 10;

    		System.out.println("#" + tc + " " + solve());
	    }
//        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}

}

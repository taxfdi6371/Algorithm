package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 새로운불면증치료법1288 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
        	int num = sc.nextInt();
        	int [] check = new int [10];
        	
        	int ith, cnt = 0;
            
        	loop:
        	for(ith = 1; ;ith++) {
        		int tnum = ith * num;

        		while(tnum > 0) {
        			int P = tnum % 10;
        			tnum /= 10;
        			
        			if(check[P] == 0) {
        				check[P] = 1;
        				cnt++;
        			}
        			if(cnt == 10) break loop;
        		}
        	}
        	
            System.out.println("#" + tc + " " + ith * num);
        }
        sc.close();
    }
}

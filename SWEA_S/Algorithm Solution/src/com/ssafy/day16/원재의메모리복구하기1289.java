package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 원재의메모리복구하기1289 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int tc = 1; tc <= TC; tc++) {
            String memory = sc.next();

            int len = memory.length();
            char[] init = new char[len];

            for (int i = 0; i < len; i++) 
            	init[i] = '0';

            int ans = 0;
            for(int i = 0; i < len; i++) {
                if(init[i] == memory.charAt(i)) continue; 

                for(int j = i; j < len; j++) 
                	init[j] = memory.charAt(i);
                ans++;
            }

            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }
}

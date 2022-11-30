package com.ssafy.day16;

import java.util.Scanner;

//public class Solution {
public class 삼성시의버스노선6485 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
            int[] bus_cnt = new int[5001];
            
            int N = sc.nextInt();
            for(int i = 0; i < N; i++) {
            	int Ai = sc.nextInt();
            	int Bi = sc.nextInt();
            	for(int j = Ai; j < Bi + 1; j++)
            		bus_cnt[j]++;
            }
            
            int P = sc.nextInt();
             
            System.out.print("#" + tc + " ");
            for(int i = 0; i < P; i++) {
            	int bus_station = sc.nextInt();
            	System.out.print(bus_cnt[bus_station] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}






package com.ssafy.day1;
import java.util.Scanner;

public class day1_1204_최빈수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int tc = 1; tc <= TC; tc++) {
            int[] count = new int[101];
            
            sc.nextInt();
            for(int j = 0; j < 1000; j++) {
                count[sc.nextInt()]++;
            }
             
            int maxI = 0;
            for(int j = 0; j < 101; j++) {
                if(count[maxI] <= count[j]) {
                	maxI = j;
                }
            }
            
            System.out.println("#" + tc + " " + maxI);

        }
        sc.close();
    }
}
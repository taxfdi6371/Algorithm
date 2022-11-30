package com.ssafy.day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day13_1221_GNS {
	public static int cnt[];
	public static int num[][] = new int [100][100];
	
	public static void setnum()
	{
		num['Z']['R'] = 0;
		num['O']['N'] = 1;
		num['T']['W'] = 2;
		num['T']['H'] = 3;
		num['F']['O'] = 4;
		num['F']['I'] = 5;
		num['S']['I'] = 6;
		num['S']['V'] = 7;
		num['E']['G'] = 8;
		num['N']['I'] = 9;
	}

	public static void main(String[] args) {
		
		//long start = System.currentTimeMillis();
		
		//System.setIn(new FileInputStream("day13_1221_input.txt"));
        Scanner sc = new Scanner(System.in);
        setnum();
        String[] nums={"ZRO","ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};

    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
            sc.next();
            int N = sc.nextInt();
            
            cnt = new int [10];
            
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                cnt[num[tmp.charAt(0)][tmp.charAt(1)]]++;
            }
        	
    		System.out.printf("#%d\n", tc);
          
    		for (int i = 0; i < 10; i++)
    			for (int j = 0; j < cnt[i]; j++)
    			{
    				System.out.print(nums[i]+" ");
    			}
    		System.out.println();

	    }
        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}


















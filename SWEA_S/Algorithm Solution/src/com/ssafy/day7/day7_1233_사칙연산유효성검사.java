package com.ssafy.day7;

import java.util.Scanner;

public class day7_1233_사칙연산유효성검사 {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int i, N, ans;

        for(int tc = 1; tc <= 10; tc++) {
        	N = sc.nextInt();
        	sc.nextLine();
	    	ans = 1;
	
	    	for (i = 1; i < (N + 1) / 2; i++)
	    	{
    			String line = sc.nextLine();
                String[] inputs = line.split(" ");
                char c = inputs[1].charAt(0);
	    		if (c >= '0') ans = 0;
	    	}
    		
	    	if (N % 2 == 0)
	    	{
    			String line = sc.nextLine();
                String[] inputs = line.split(" ");
                char c = inputs[1].charAt(0);
	    		if (c >= '0') ans = 0;
	    		i++;
	    	}
	    	for (; i <= N; i++)
	    	{
    			String line = sc.nextLine();
                String[] inputs = line.split(" ");
                char c = inputs[1].charAt(0);
	    		if (c < '0') ans = 0;
	    	}
    		
            System.out.printf("#%d %d\n", tc, ans);
	    }
        sc.close();
    }
}









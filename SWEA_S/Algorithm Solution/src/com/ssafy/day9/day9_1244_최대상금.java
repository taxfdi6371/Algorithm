package com.ssafy.day9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day9_1244_최대상금 {
	static int ans, num_len, ii, jj, cnt;
	static int [][] state;
	static int t[] = { 1, 10, 100, 1000, 10000, 100000 };
	
	static void findmax(int x, int s)
	{
		cnt++;

//		if (s > 0)
//		{
//			for (int i = 0; i < 720; i++)
//			{
//				if (state[s][i] == 0)
//				{
//					state[s][i] = x;
//					break;
//				}
//				else if (state[s][i] == x) return;
//			}
//		}
		
		if (s == 0)
		{
			if (x > ans) ans = x;
		}
		else
		{
			for (int i = 1; i <= num_len - 1; i++)
				for (int j = i + 1; j <= num_len; j++)
				{
					ii = ((x / t[num_len - i]) % 10);
					jj = ((x / t[num_len - j]) % 10);
					int xx = x - ii * t[num_len - i] - jj * t[num_len - j] + ii * t[num_len - j] + jj * t[num_len - i];
					findmax(xx, s - 1);
				}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("day9_1244_input.txt"));
        Scanner sc = new Scanner(System.in);

    	sc.nextInt();
    	
        for(int tc = 1; tc <= 10; tc++) {
    		int x, s; 
    		
    		state = new int [11][720];

        	x = sc.nextInt();
        	s = sc.nextInt();

        	num_len = (int)(Math.log10(x)+1);

    		cnt = ans = 0;
    		findmax(x, s);
    		
    		System.out.printf("#%d %d %d\n", tc, ans, cnt);
    		
    		if (tc == 9){
    			System.out.println(( System.currentTimeMillis() - start )/1000.0 );
    		}
	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
    }
}














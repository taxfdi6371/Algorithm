package com.ssafy.day3;

import java.util.Scanner;

public class day3_1215_회문1 {
	
	public static int N, ans;
	public static char[][] ary = new char[8][8];

	
	public static boolean is_pal(int r, int c)
	{
		for (int i = 0; i <= N / 2; i++)
			if (ary[r][c + i] != ary[r][c + N - 1 - i])
				return false;

		return true;
	}
	
	public static void calpal()
	{
		for (int i = 0; i < 8; i++)
			for (int j = 0; j <= 8 - N; j++)
				if (is_pal(i, j))
					ans++;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
	        N = sc.nextInt();
	         
	        for (int i = 0; i < 8; i++)
	        {
	            String tmp = sc.next();
	            ary[i] = tmp.toCharArray();
	        }
	         
	        ans = 0;
	         
	        calpal();
	        
	        
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i < j)
					{
						char t = ary[i][j];
						ary[i][j] = ary[j][i];
						ary[j][i] = t;
					}
				}
			}
			
			
			calpal();
			
	        System.out.println("#" + tc + " " + ans);
	    }
        sc.close();
    }
}











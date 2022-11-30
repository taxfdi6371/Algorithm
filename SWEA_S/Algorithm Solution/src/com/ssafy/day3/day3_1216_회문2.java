package com.ssafy.day3;

import java.util.Scanner;

public class day3_1216_회문2 {
	
	public static int N, ans;
	public static char[][] ary = new char[100][100];

	
	public static boolean is_pal(int r, int c, int len)
	{
		for (int i = 0; i < (len + 1) / 2; i++)
			if (ary[r][c + i] != ary[r][c + len - 1 - i])
				return false;

		return true;
	}
	
	public static int calpal()
	{
		int max = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 100 - j; k > max; k--) {
					if (is_pal(i, j, k))
					{
						if (max < k) max = k;
						break;
					}
				}
			}
		}

		return max;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
	        sc.nextInt();
	         
	        for (int i = 0; i < 100; i++)
	        {
	            String tmp = sc.next();
	            ary[i] = tmp.toCharArray();
	        }
	        
	        int ansr = calpal();
	        
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (i < j)
					{
						char t = ary[i][j];
						ary[i][j] = ary[j][i];
						ary[j][i] = t;
					}
				}
			}
			
			int ansc = calpal();
			int ans = ansr < ansc ? ansc : ansr;
			
	        System.out.println("#" + tc + " " + ans);
	    }
        sc.close();
    }
}











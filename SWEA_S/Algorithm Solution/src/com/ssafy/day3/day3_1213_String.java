package com.ssafy.day3;

import java.util.Scanner;

public class day3_1213_String {
	
	public static int ans;
	
	public static void BruteForce(char pattern[], char text[])
	{
	    ans = 0;
	    int i, j;
	    int N = text.length;
	    int M = pattern.length;

	    for (i = 0; i < N - M + 1; i++)
	    {
	        if (text[i] == pattern[0])
	        {
	            for (j = 1; j < M; j++)
	            {
	                if (text[i + j] != pattern[j])
	                    break;
	            }
	            if (j == M)
	            {
	                ans++;
	                i += M;
	            }
	        }
	    }
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
        	sc.nextInt();
        	String p = sc.next();
        	char[] pattern = p.toCharArray();
            String t = sc.next();
            char[] text = t.toCharArray();
            
        	BruteForce(pattern, text);

    		System.out.println("#" + tc + " " + ans);

        }
        sc.close();
    }
}











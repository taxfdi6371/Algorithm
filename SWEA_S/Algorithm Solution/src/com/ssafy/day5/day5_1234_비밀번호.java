package com.ssafy.day5;

import java.util.Scanner;

public class day5_1234_비밀번호 {
	public static char[] s = new char[100];
	public static int top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
    		int n;
    		char[] input = new char [100];
    		
    		n = sc.nextInt();
    		input = sc.next().toCharArray();

    		top = -1;

    		int i = 0;
    		s[++top] = input[i];

    		for (i = 1; i < n; i++)
    		{
    			if (top != -1 && s[top] == input[i]) top--;
    			else s[++top] = input[i];
    		}
    		
    		System.out.printf("#%d ", tc);
    		for(i = 0; i <= top; i++)
    			System.out.printf("%c", s[i]);
	        System.out.println();
	    }
        sc.close();
    }
}










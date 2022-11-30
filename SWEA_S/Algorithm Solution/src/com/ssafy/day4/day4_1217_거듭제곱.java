package com.ssafy.day4;

import java.util.Scanner;

public class day4_1217_거듭제곱 {
	
	public static int power(int x, int n)
	{
		int y;

		if (n == 1) return x;
		if (n % 2 == 1)
		{
			y = power(x, (n - 1) / 2);
			return y * y * x;
		}
		else
		{
			y = power(x, n / 2);
			return y * y;
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, n;

        for(int tc = 1; tc <= 10; tc++) {
	        sc.nextInt();
	        x = sc.nextInt();
	        n = sc.nextInt();
	         
	        System.out.println("#" + tc + " " + power(x, n));
	    }
        sc.close();
    }
}











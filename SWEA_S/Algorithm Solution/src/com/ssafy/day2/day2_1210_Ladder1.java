package com.ssafy.day2;

import java.util.Scanner;

public class day2_1210_Ladder1 {
	
	public static int[][] map = new int [100][100];
	public static boolean check(int x, int y)
	{
		if (x < 0 || x > 99) return false;
		if (y < 0 || y > 99) return false;
		if (map[x][y] == 1)  return true;
		return false;
	}

	public static int solve()
	{
		int s;
	
		for (s = 0; s < 100; s++)
			if (map[99][s] == 2)  break;
	
		int x = 99, y = s;
		int d = 0; // -1(����), 0(��), 1(������)
	
		while (x != 0)
		{
			if      ((d == 0 || d == -1) && check(x, y - 1))  {d = -1; y--;}
			else if ((d == 0 || d == 1) &&  check(x, y + 1))  {d = 1;  y++;}
			else	{d = 0; x--;}
		}
		return y;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
        	sc.nextInt();

    		for (int i = 0; i < 100; i++)
    			for (int j = 0; j < 100; j++)
    				map[i][j] = sc.nextInt();

    		System.out.println("#" + tc + " " + solve());

        }
        sc.close();
    }
}











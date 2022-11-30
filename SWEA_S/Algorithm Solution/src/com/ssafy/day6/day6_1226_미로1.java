package com.ssafy.day6;

import java.util.Scanner;

public class day6_1226_미로1 {

	public static char map[][] = new char[16][16];
	public static int Q[] = new int [2000];
	public static int f, r;
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { 1, -1, 0, 0 };
	
	public static boolean check(int x, int y)
	{
	    if (x < 0 || x > 16) return false;
	    if (y < 0 || y > 16) return false;
	    if (map[x][y] == '1') return false;
	    return true;
	}

	public static int BFS(int x, int y)
	{
		Q[++r] = x;
		Q[++r] = y;
		map[x][y] = '1';

	    while (f != r)
	    {
			x = Q[++f];
			y = Q[++f];

			for (int i = 0; i < 4; i++)
			{
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (map[newX][newY] == '3') return 1;

				if (check(newX, newY))
				{
					map[newX][newY] = '1';
					Q[++r] = newX;
					Q[++r] = newY;
				}
			}
	    }
	    return 0;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
    		sc.nextInt();
            for (int i = 0; i < 16; i++)
            {
	            String tmp = sc.next();
	            map[i] = tmp.toCharArray();
            }

            f = r = -1;
            System.out.println("#" + tc + " " + BFS(1, 1));

	    }
        sc.close();
    }
}

//
//import java.util.Scanner;
//
//public class day6_1226_미로1 {
//
//	public static char map[][] = new char[16][16];
//	public static int aryX[] = new int [1000];
//	public static int aryY[] = new int [1000];
//	public static int top;
//	public static int dx[] = { 0, 0, 1, -1 };
//	public static int dy[] = { 1, -1, 0, 0 };
//	
//	public static boolean check(int x, int y)
//	{
//	    if (x < 0 || x > 16) return false;
//	    if (y < 0 || y > 16) return false;
//	    if (map[x][y] == '1') return false;
//	    return true;
//	}
//
//	public static int DFSr(int x, int y)
//	{
//		if (map[x][y] == '3') return 1;
//
//		map[x][y] = '1';
//		
//		for (int i = 0; i < 4; i++)
//        {
//            int newX = x + dx[i];
//            int newY = y + dy[i];
//
//            if (check(newX, newY))
//            	if (DFSr(newX, newY) == 1)
//            		return 1;
//        }
//		
//		return 0;
//	}
//	
//	public static int DFS(int x, int y)
//	{
//	    aryX[++top] = x;
//	    aryY[top] = y;
//
//	    while (top != -1)
//	    {
//	        x = aryX[top];
//	        y = aryY[top--];
//
//	        if (map[x][y] == '3') return 1;
//
//	        if (map[x][y] != '1')
//	        {
//	            map[x][y] = '1';
//
//	            for (int i = 0; i < 4; i++)
//	            {
//	                int newX = x + dx[i];
//	                int newY = y + dy[i];
//
//	                if (check(newX, newY))
//	                {
//	                    aryX[++top] = newX;
//	                    aryY[top] = newY;
//	                }
//	            }
//	        }
//	    }
//	    return 0;
//	}
//	
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        for(int tc = 1; tc <= 10; tc++) {
//    		sc.nextInt();
//            for (int i = 0; i < 16; i++)
//            {
//	            String tmp = sc.next();
//	            map[i] = tmp.toCharArray();
//            }
//
//            top = -1;
//            System.out.println("#" + tc + " " + DFSr(1, 1));
//
//	    }
//        sc.close();
//    }
//}










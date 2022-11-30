package com.ssafy.day2;

import java.util.Scanner;

public class day2_1220_Magnetic {
	
	public static int[][] arr = new int [100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
        	sc.nextInt();

        	int ans = 0;
        	
    		for (int i = 0; i < 100; i++)
    			for (int j = 0; j < 100; j++)
    				arr[i][j] = sc.nextInt();
    		
    		for (int x = 0; x < 100; x++)
    		{
    			int flag = 0;   
    			for (int y = 0; y < 100; y++)
    			{
    				if (arr[y][x] == 1)  flag = 1;
    				else if (arr[y][x] == 2 && flag == 1)
    				{
    					ans++;  
    					flag = 0; 
    				}
    			}
    		}
    		System.out.println("#" + tc + " " + ans );

        }
        sc.close();
    }
}











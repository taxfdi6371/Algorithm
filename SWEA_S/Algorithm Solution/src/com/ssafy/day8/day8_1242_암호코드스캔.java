package com.ssafy.day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day8_1242_암호코드스캔 {
	static int[][] map = new int [2000][2000];
	static int hcode[][] = {
		{ 0, 0, 0, 0 }, //0
		{ 0, 0, 0, 1 }, //1
		{ 0, 0, 1, 0 }, //2
		{ 0, 0, 1, 1 }, //3
		{ 0, 1, 0, 0 }, //4
		{ 0, 1, 0, 1 }, //5
		{ 0, 1, 1, 0 }, //6
		{ 0, 1, 1, 1 }, //7
		{ 1, 0, 0, 0 }, //8
		{ 1, 0, 0, 1 }, //9
		{ 1, 0, 1, 0 }, //A
		{ 1, 0, 1, 1 }, //B
		{ 1, 1, 0, 0 }, //C
		{ 1, 1, 0, 1 }, //D
		{ 1, 1, 1, 0 }, //E
		{ 1, 1, 1, 1 } //F
	};

	static int [][][] scode = new int [4][3][4];
	
	public static void main(String[] args) throws FileNotFoundException{
		
		System.setIn(new FileInputStream("day8_1242_input.txt"));
        Scanner sc = new Scanner(System.in);

    	int TC = sc.nextInt();
    	
    	scode[1][0][0] = 0;
    	scode[1][1][0] = 1;
    	scode[0][1][1] = 2;
    	scode[3][0][0] = 3;
    	scode[0][2][1] = 4;
    	scode[1][2][0] = 5;
    	scode[0][0][3] = 6;
    	scode[2][0][1] = 7;
    	scode[1][0][2] = 8;
    	scode[0][0][1] = 9;

        for(int tc = 1; tc <= TC; tc++) {
    		int N, M; // 1 <= N <= 2000, 1 <= M <= 500
    		int ans = 0;

        	N = sc.nextInt();
        	M = sc.nextInt();
        	sc.nextLine();
    		
        	for (int i = 0; i < N; i++) 
        	{
    			String line = sc.nextLine();
                
    			for (int j = 0; j < M; j++)
    			{
    				int t = line.charAt(j);
    				
    				if (t <= '9') t = t - '0';
    				else t = t - 'A' + 10;

    				for (int k = 0; k < 4; k++)
    					map[i][j * 4 + k] = hcode[t][k];
    			}
        	}
    		
        	
    		int codei = 7;
    		int [] code = new int [8];
    		
    		for (int i = 1; i < N; i++)
    			for (int j = M * 4 - 1; j >= 0; j--)
    			{
    				if (map[i][j] == 1 && map[i - 1][j] == 0)
    				{
    					int x, y, z;
    					x = y = z = 0;
    					while (map[i][j] == 1) { z++; j--; } 	// 1의 개수
    					while (map[i][j] == 0) { y++; j--; } 	// 0의 개수
    					while (map[i][j] == 1) { x++; j--; } 	// 1의 개수
    					while (map[i][j] == 0) { j--; } 		// 0의 개수
    					j++;

    					int min = Math.min(Math.min(x, y), z);

    					x /= min; y /= min; z /= min;

    					code[codei--] = scode[x - 1][y - 1][z - 1];

    					if (codei == -1)
    					{
    						int t = (code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7];
    						if (t % 10 == 0) ans += code[0] + code[2] + code[4] + code[6] + code[1] + code[3] + code[5] + code[7];
    						codei = 7;
    					}
    				}
    			}

    		System.out.printf("#%d %d\n", tc, ans);

	    }
        sc.close();
    }
}




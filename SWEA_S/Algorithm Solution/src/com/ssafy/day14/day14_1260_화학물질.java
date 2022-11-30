package com.ssafy.day14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day14_1260_화학물질 {
	public static int matrix[][] = new int [101][101]; // 최초 입력 행렬
	public static int submatrix[][] = new int [21][2]; // 최초 입력 행렬로부터 서브 행렬을 추출하여 각 서브 행렬의 크기를 저장할 배열
	public static int M[][] = new int [21][21];   // 행렬 곱을 동적 계획법으로 수행할 배열
	public static int d[] = new int [21];    // 2*3, 3*4, 4*5의 3개의 서브 배열에 대해서 d배열은 2, 3, 4, 5를 저장한다.
	public static int subcnt;    // 서브 행렬의 개수
	public static int msize;    // 최초 입력 행렬의 크기
	
	public static void getsubmatrix(int x, int y)
	{
		int i, j = 0;

		for (i = 0; matrix[x + i][y] != 0; i++)
			for (j = 0; matrix[x + i][y + j] != 0; j++)
				matrix[x + i][y + j] = 0;

		submatrix[subcnt][0] = i;
		submatrix[subcnt][1] = j;

		subcnt++;
	}
	
	public static int solveRDP(int i, int j)
	{
		int min = 0x7fffffff;
		if (M[i][j] >= 0) return M[i][j];
		for (int k = i; k < j; k++)
		{
			int t = solveRDP(i, k) + solveRDP(k + 1, j) + d[i - 1] * d[k] * d[j];
			if (min > t) min = t;
		}
		return M[i][j] = min;
	}
	
	public static int solveIDP(int metrixcnt)
	{
		for (int x = 1; x < metrixcnt; x++)
		{
			for (int i = 1; i <= metrixcnt - x; i++)
			{
				int j = i + x;

				M[i][j] = 0x7fffffff;

				int tmp;
				for (int k = i; k <= j - 1; k++) 
				{
					tmp = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
					if (tmp < M[i][j]) 
						M[i][j] = tmp;
				}
			}
		}

		return M[1][metrixcnt];
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		//System.setIn(new FileInputStream("day14_1260_input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
        	subcnt = 0;
            msize = sc.nextInt();
            
    		for (int i = 0; i < msize; i++)
    			for (int j = 0; j < msize; j++)
    				matrix[i][j] = sc.nextInt();
    		
    		// 서브 행렬 추출
    		for (int i = 0; i < msize; i++)
    			for (int j = 0; j < msize; j++)
    				if (matrix[i][j] != 0)
    					getsubmatrix(i, j);
    		
    		// 연쇄 행렬의 시작 찾기
    		int spos;
    		for (spos = 0; spos < subcnt; spos++)
    		{
    			int j;
    			for (j = 0; j < subcnt; j++)
    				if (submatrix[spos][0] == submatrix[j][1])  break;

    			if (j == subcnt) break;
    		}
    		
    		// 연쇄 행렬로 부터 d값 추출
    		d[0] = submatrix[spos][0];

    		for (int c = 0; c < subcnt; c++)
    			for (int i = 0; i < subcnt; i++)
    				if (submatrix[i][0] == d[c])
    				{
    					d[c + 1] = submatrix[i][1];
    					break;
    				}
    		
    		// 동적 계획법에 사용할 배열 초기화
    		for (int i = 1; i <= subcnt; i++)
    			for (int j = i + 1; j <= subcnt; j++)
    				M[i][j] = -1;

    		for (int i = 0; i < subcnt; i++)
    			M[i][i] = 0;
    		
    		System.out.printf("#%d %d\n", tc, solveRDP(1, subcnt));
    		//System.out.printf("#%d %d\n", tc, solveIDP(subcnt));
	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}


















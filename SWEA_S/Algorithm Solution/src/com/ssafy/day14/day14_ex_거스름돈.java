package com.ssafy.day14;


//public class day14_ex_거스름돈 {
//	
//	public static void main(String[] args) 
//	{
//		int C[][] = new int [5][21];
//		int D[] = {0, 1, 5, 10, 16};
//		
//		for(int j = 0;j < 21;j++)
//			C[0][j] = 100; 
//
//		for(int i = 1;i < 5;i++)
//			for(int j = 1;j < 21;j++)
//				if (j < D[i]) 
//					C[i][j] = C[i-1][j];
//				else
//					C[i][j] = Math.min(C[i][j-D[i]]+1, C[i-1][j]);
//
//
//		for(int i = 1;i < 5;i++)
//		{
//			for(int j = 1;j < 21;j++)
//				System.out.printf("%2d ", C[i][j]);
//			System.out.printf("\n");
//		}
//
//		System.out.printf("%d coins\n", C[4][20]);
//
//	}
//}










public class day14_ex_거스름돈 {
	
	public static int C[] = new int [21];
	public static int D[] = { 1, 5, 10, 16 };
	
	public static int f(int n)
	{
		if (C[n] != 0) return C[n];

		int m = 100000, t;
		for (int i = 0; i < 4; i++)
			if (n - D[i] > 0)
			{
				t = f(n - D[i]);
				if (t < m) m = t;
			}

		return C[n] = m + 1;
	}
	
	public static void main(String[] args) 
	{
		C[1] = C[5] = C[10] = C[16] = 1;

		System.out.printf("%d coins\n", f(17));
		for (int i = 0; i < 21; i++) 
			System.out.printf("C[%2d] : %d \n", i, C[i]);

	}
}


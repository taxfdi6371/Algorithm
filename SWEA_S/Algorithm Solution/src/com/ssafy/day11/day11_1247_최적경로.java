package com.ssafy.day11;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class day11_1247_������� {
//
//		public static boolean[] visited = new boolean [100];
//		public static int[] x;
//		public static int[] y;
//		public static int[] perm = new int [100];
//		public static int ans;
//		public static int cnt;
//		public static int N;
//		
//		public static int getD(int x1, int y1, int x2, int y2)
//		{
//			int dx = x1 - x2;
//			dx = dx < 0 ? dx * -1 : dx;
//			int dy = y1 - y2;
//			dy = dy < 0 ? dy * -1 : dy;
//			
//			return dx + dy;
//		}
//		
//		
//		public static void calc()
//		{
//			int t = 0;
//			
//			for (int i = 1; i < N; i++)
//				t += getD(x[perm[i]], y[perm[i]], x[perm[i + 1]], y[perm[i + 1]]);
//			
//			t += getD(x[0], y[0], x[perm[1]], y[perm[1]]);
//			t += getD(x[perm[N]], y[perm[N]], x[N + 1], y[N + 1]);
//			
//			if (ans > t) ans = t;
//		}
//		
//		public static void solve(int k)
//		{
//			cnt++;
//			
//			if (k == N) calc();
//			else
//			{
//				k++;
//			
//				for (int i = 1; i <= N; i++)
//				{
//					 if (visited[i]) continue;
//					 visited[i] = true;
//					 perm[k] = i;
//					 solve(k);
//					 visited[i] = false;
//				}
//			}
//		}
//		
//		
//		public static void main(String[] args) throws FileNotFoundException {
//			
//			long start = System.currentTimeMillis();
//			
//			System.setIn(new FileInputStream("day11_1247_input.txt"));
//	        Scanner sc = new Scanner(System.in);
//
//	    	int TC = sc.nextInt();
//	    	
//	        for(int tc = 1; tc <= TC; tc++) {
//	        	cnt = 0;
//	        	ans = 0x7FFFFFFF;
//	        	
//	        	N = sc.nextInt();
//	        	x = new int[N + 2];
//	        	y = new int[N + 2];
//	        	
//	        	x[0] = sc.nextInt();
//	        	y[0] = sc.nextInt();
//	        	
//	        	x[N + 1] = sc.nextInt();
//	        	y[N + 1] = sc.nextInt();
//	        	
//	        	for (int i = 1; i <= N; i++)
//	        	{
//	            	x[i] = sc.nextInt();
//	            	y[i] = sc.nextInt();
//	        	}
//	        	
//	        	solve(0);
//	        	
//
//	        	//System.out.printf("#%d %d\n", tc, ans);
//	        	System.out.printf("#%d %d %d\n", tc, ans, cnt);
//
//	        }
//
//	        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
//	        sc.close();
//	    }
//	}







////// ver.2 �Է� ó�� ���� ���� ��Ʈ��ŷ
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class day11_1247_������� {
//	public static boolean[] visited = new boolean [100];
//	public static int[] x;
//	public static int[] y;
//	public static int[] perm = new int [100];
//	public static int[][] D = new int [12][12];
//	public static int ans;
//	public static int cnt;
//	public static int N;
//	
//	
//	public static void solve(int k)
//	{
//		cnt++;
//		
//		if (k == N) {
//			int t = 0;
//			
//			t += D[0][perm[0]];
//			for (int i = 0; i < N; i++)
//			 t += D[perm[i]][perm[i + 1]];
//			
//			t += D[perm[N]][N+1];
//			
//			if (t < ans) ans = t;
//		}
//		else
//		{
//			k++;
//		
//			for (int i = 1; i <= N; i++)
//			{
//				 if (visited[i]) continue;
//				 visited[i] = true;
//				 perm[k] = i;
//				 solve(k);
//				 visited[i] = false;
//			}
//		}
//	}
//	
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		long start = System.currentTimeMillis();
//		
//		System.setIn(new FileInputStream("day11_1247_input.txt"));
//        Scanner sc = new Scanner(System.in);
//
//    	int TC = sc.nextInt();
//    	
//        for(int tc = 1; tc <= TC; tc++) {
//        	cnt = 0;
//        	ans = 0x7FFFFFFF;
//        	
//        	N = sc.nextInt();
//        	x = new int[N + 2];
//        	y = new int[N + 2];
//        	x[0] = sc.nextInt();
//        	y[0] = sc.nextInt();
//        	x[N + 1] = sc.nextInt();
//        	y[N + 1] = sc.nextInt();
//        	
//        	for (int i = 1; i <= N; i++)
//        	{
//            	x[i] = sc.nextInt();
//            	y[i] = sc.nextInt();
//        	}
//        	
//        	for (int i = 0; i < N + 1; i++)
//        		for (int j = i + 1; j < N + 2; j++)
//        			D[i][j] = D[j][i] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
//        	
//        	solve(0);
//        	
//
//        	//System.out.printf("#%d %d\n", tc, ans);
//        	System.out.printf("#%d %d %d\n", tc, ans, cnt);
//
//        }
//        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
//        sc.close();
//    }
//}





//////ver.3 ��Ʈ��ŷ + ����ġ�� + �׸���
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day11_1247_최적경로 {
	public static boolean[] visited = new boolean [100];
	public static int[] x;
	public static int[] y;
	public static int[] perm = new int [100];
	public static int[][] D = new int [12][12];
	public static int ans;
	public static int cnt;
	public static int N;
	
	
	public static void greedy_ans()
	{
		boolean v[] = new boolean [100];
		ans = 0;
	
		int si = 0;
		for (int n = 0; n < N; n++)
		{
			int min = 0x123456, minI = 0;
			for (int i = 1; i <= N; i++)
			{
				if (v[i] || D[si][i] == 0) continue;
				if (D[si][i] < min){ minI = i; min = D[si][i]; }
			}
			
			v[minI] = true;
			ans += D[si][minI];
			si = minI;
		}
		ans += D[si][N + 1];
	}

	
	
	
	public static void solve(int k, int curdist)
	{
		cnt++;
		
		if (k == N) {
			curdist += D[perm[k]][N + 1];
			if (curdist < ans) ans = curdist;
		}
		else
		{
			k++;
		
			for (int i = 1; i <= N; i++)
			{
				 if (visited[i]) continue;
				 visited[i] = true;
				 perm[k] = i;
				 if (curdist + D[perm[k - 1]][perm[k]] < ans) // ����ġ��
					 solve(k, curdist + D[perm[k - 1]][perm[k]]);
				 visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("day11_1247_input.txt"));
        Scanner sc = new Scanner(System.in);

    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
        	cnt = 0;
        	ans = 0x7FFFFFFF;
        	
        	N = sc.nextInt();
        	x = new int[N + 2];
        	y = new int[N + 2];
        	x[0] = sc.nextInt();
        	y[0] = sc.nextInt();
        	x[N + 1] = sc.nextInt();
        	y[N + 1] = sc.nextInt();
        	
        	for (int i = 1; i <= N; i++)
        	{
            	x[i] = sc.nextInt();
            	y[i] = sc.nextInt();
        	}
        	
        	for (int i = 0; i < N + 1; i++)
        		for (int j = i + 1; j < N + 2; j++)
        			D[i][j] = D[j][i] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
        	
        	greedy_ans();
        	solve(0, 0);
        	

        	//System.out.printf("#%d %d\n", tc, ans);
        	System.out.printf("#%d %d %d\n", tc, ans, cnt);

        }

        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
    }
}


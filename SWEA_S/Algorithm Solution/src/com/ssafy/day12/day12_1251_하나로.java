package com.ssafy.day12;

////ver1. ����
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class day12_1251_�ϳ��� {
//	public static int N;
//	public static int X[];
//	public static int Y[];
//	public static double E;
//	public static double D[];
//	public static int V[];
//	public static double ELL[][];
//	
//
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		long start = System.currentTimeMillis();
//		
//		System.setIn(new FileInputStream("day12_1251_input.txt"));
//        Scanner sc = new Scanner(System.in);
//
//    	int TC = sc.nextInt();
//    	
//        for(int tc = 1; tc <= TC; tc++) {
//        	
//        	N = sc.nextInt();
//        	
//        	X = new int [N];
//        	Y = new int [N];
//        	V = new int [N];
//        	D = new double [N];
//        	ELL = new double [N][N];
//        	
//        	for (int i = 0; i < N; i++)  X[i] = sc.nextInt();
//        	for (int i = 0; i < N; i++)  Y[i] = sc.nextInt();
//
//        	E = sc.nextDouble();
//        	
//        	for (int i = 0; i < N - 1; i++)
//        		for (int j = i + 1; j < N; j++)
//        			ELL[j][i] = ELL[i][j] = E * (Math.pow((X[i] - X[j]), 2) + Math.pow((Y[i] - Y[j]), 2));
//        	
//        	for (int i = 0; i < N; i++)
//        	{
//        		D[i] = ELL[0][i];
//        		V[i] = i;
//        	}
//        	
//        	double sumE = 0.0;
//        	int minIdx;
//
//        	for (int i = 1; i < N; i++)
//        	{
//        		minIdx = i ;
//
//        		for (int j = i; j < N; j++)
//        		{
//        			if (ELL[V[i - 1]][V[j]] < D[V[j]])
//        				D[V[j]] = ELL[V[i - 1]][V[j]];
//
//        			if (D[V[minIdx]] > D[V[j]])
//        				minIdx = j;
//        		}
//
//        		sumE += D[V[minIdx]];
//        		int t = V[minIdx]; V[minIdx] = V[i]; V[i] = t;
//        	}
//        	
//    		System.out.printf("#%d %d\n", tc, Math.round(sumE));
//
//	    }
//        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
//        sc.close();
//	}
//}





// ũ�罺Į
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day12_1251_하나로 {
	public static double Ed[];
	public static int uv[][];
	public static int N;
	public static int X[], Y[];
	public static int parent[];
	public static double E, sumE;
	
	
//	public static int FindSet(int u)
//	{
//		if (u == parent[u]) return u;
//		return FindSet(parent[u]);
//	}

	public static int FindSet(int u)
	{
		if (u != parent[u])
			parent[u] = FindSet(parent[u]);

		return parent[u];
	}
	
	public static void swapE(int i, int j)
	{
		double t = Ed[i]; Ed[i] = Ed[j]; Ed[j] = t;
		int t1 = uv[i][0];  uv[i][0] = uv[j][0]; uv[j][0] = t1;
		t1 = uv[i][1];  uv[i][1] = uv[j][1]; uv[j][1] = t1;
	}
	
	public static int partition(int l, int r)
	{
		double p = Ed[l];
		int i = l, j = r;

		while (i < j)
		{
			while (Ed[i] <= p) if (++i == r) break;
			while (Ed[j] >= p) if (--j == l) break;

			if (i < j) swapE(i, j);
		}
		swapE(l, j);

		return j;
	}
	
	public static void sortEdges(int l, int r)
	{
		int pivot;

		if (l < r)
		{
			pivot = partition(l, r);
			sortEdges(l, pivot - 1);
			sortEdges(pivot + 1, r);
		}
	}
	
	public static void solve()
	{
		int edgeNs = 0, nS = 0, u, v;

		for (int i = 0; i < N - 1; ++i)
			for (int j = i + 1; j < N; ++j)
			{
				Ed[edgeNs] = E * (Math.pow((X[i] - X[j]), 2) + Math.pow((Y[i] - Y[j]), 2));
				uv[edgeNs][0] = i;
				uv[edgeNs++][1] = j;
			}

		//sortEdges(0, edgeNs - 1);
		Arrays.sort(Ed);

		for (int i = 0; i < N; ++i)
			parent[i] = i;

		sumE = 0;
		for (int i = 0; i < edgeNs; ++i)
		{
			u = uv[i][0]; v = uv[i][1];

			if (FindSet(u) == FindSet(v)) continue;

			parent[FindSet(u)] = FindSet(v);

			sumE += Ed[i];
			if (nS++ == N - 1) return;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("day12_1251_input.txt"));
        Scanner sc = new Scanner(System.in);

    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
        	
        	N = sc.nextInt();
        	
        	X = new int [N];
        	Y = new int [N];
        	parent = new int [N];
        	Ed = new double [N * (N - 1) / 2];
        	uv = new int [N * (N - 1) / 2][2];
        	
        	for (int i = 0; i < N; i++)  X[i] = sc.nextInt();
        	for (int i = 0; i < N; i++)  Y[i] = sc.nextInt();

        	E = sc.nextDouble();
        	
        	solve();
        	
     		System.out.printf("#%d %d\n", tc, Math.round(sumE));

	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}






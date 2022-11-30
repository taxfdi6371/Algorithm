package com.ssafy.day18;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.Scanner;
//
////public class Solution {
//public class 창용마을무리의개수7465 {
//
//	public static int N, M;
//	public static int G[][] ;
//	public static int ans;
//	public static boolean visited[];
//	
//	public static void dfs(int v)
//	{
//		visited[v] = true;
//
//		for (int i = G[v][0]; i > 0; i--)
//			if (!visited[G[v][i]])
//				dfs(G[v][i]);
//	}
//	
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		//long start = System.currentTimeMillis();
//		
//		//System.setIn(new FileInputStream("창용마을무리의개수7465input.txt"));
//        Scanner sc = new Scanner(System.in);
//        
//    	int TC = sc.nextInt();
//    	
//        for(int tc = 1; tc <= TC; tc++) {
//
//        	N = sc.nextInt();
//        	M = sc.nextInt();
//        	
//        	G = new int [N + 1][N + 1];
//        	visited = new boolean [N + 1]; 
//        	
//    		int u, v;
//    		for (int i = 0; i < M; i++)
//    		{
//    			u = sc.nextInt();
//    			v = sc.nextInt();
//    			G[u][++G[u][0]] = v;
//    			G[v][++G[v][0]] = u;
//    		}
//    		 
//    		ans = 0;
//
//    		for (int i = 1; i <= N; i++)
//    		{
//    			if (!visited[i])
//    			{
//    				dfs(i);
//    				ans++;
//    			}
//    		}
//    		
//    		System.out.printf("#%d %d\n", tc, ans);
//	    }
//        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
//        sc.close();
//	}
//}







//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.Scanner;
//
////public class Solution {
//public class 창용마을무리의개수7465 {
//
//	public static int N, M;
//	public static int ans;
//	public static int P[];
//	
//	public static int find_set(int x)
//	{
//		if (x != P[x])
//			P[x] = find_set(P[x]);
//		
//		return P[x];
//	}
//	
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		//long start = System.currentTimeMillis();
//		
//		//System.setIn(new FileInputStream("창용마을무리의개수7465input.txt"));
//        Scanner sc = new Scanner(System.in);
//        
//    	int TC = sc.nextInt();
//    	
//        for(int tc = 1; tc <= TC; tc++) {
//
//        	N = sc.nextInt();
//        	M = sc.nextInt();
//        	
//        	P = new int [N + 1];
//        	
//        	for (int i = 0; i <= N; i++) 
//        		P[i] = i;
//        	
//    		int u, v;
//    		for (int i = 0; i < M; i++)
//    		{
//    			u = sc.nextInt();
//    			v = sc.nextInt();
//    			P[find_set(u)] = find_set(v);
//    		}
//    		 
//    		ans = 0;
//    		for (int i = 1; i <= N; i++)
//    			if (i == P[i]) ans++;
//  		
//    		System.out.printf("#%d %d\n", tc, ans);
//	    }
//        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
//        sc.close();
//	}
//}



import java.io.*;
import java.util.*;
 
public class 창용마을무리의개수7465 {
    static int[] root;
    static int N;
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("창용마을무리의개수7465input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            root = new int[N + 1];
 
            for (int i = 1; i <= N; i++) {
                root[i] = i;
            }
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
 
                root[find(from)] = find(to);
                //union(from, to);
            }
             
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                hs.add(find(i));
            }
 
            sb.append("#").append(tc).append(" ").append(hs.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
 
    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return find(root[x]);
        }
    }
 
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
 
        if (rootA == rootB) return;
        root[rootB] = rootA;
    }
}






package com.ssafy.day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day11_1248_공통조상 {
     
	public static int vcnt, ecnt, n1, n2, cnt, CA;
	public static int[][] tree;
    
	public static  void traversal(int T)
	{
		if (T != 0)
		{
			cnt++;
			traversal(tree[T][0]);
			traversal(tree[T][1]);
		}
	}

	//public static void main(String[] args) {
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("day11_1248_��������.txt"));
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
         
        for (int tc = 1; tc <= TC; tc++) {
             
        	vcnt = sc.nextInt();
        	ecnt = sc.nextInt();
        	n1 = sc.nextInt();
        	n2 = sc.nextInt();
            tree = new int[vcnt + 1][3];
            
            int p, c;
    		for (int j = 0; j < ecnt; j++)
    		{
    			p = sc.nextInt();
    			c = sc.nextInt();
    			if (tree[p][0] == 0) tree[p][0] = c;
    			else tree[p][1] = c;
    			tree[c][2] = p;
    		}
            
    		// ������ n1, n2
    		int t, A = tree[n1][2];
    		tree[n1][2] = -1;
    		
    		while (A != 0)
    		{
    			A = tree[t = A][2];
    			tree[t][2] = -1;
    		}
    		
    		CA = tree[n2][2];

    		while (tree[CA][2] != -1)
    			CA = tree[CA][2];

    		cnt = 0;
    		traversal(CA);
    		
            System.out.printf("#%d %d %d\n", tc, CA, cnt);
        }
        sc.close();
    }
}



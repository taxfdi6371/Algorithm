package com.ssafy.day6;

import java.util.Scanner;

public class day6_1225_암호생성기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ary[] = new int[8];
        for(int tc = 1; tc <= 10; tc++) {
 		
    		sc.nextInt();
            for (int j = 0; j < 8; j++)
                ary[j] = sc.nextInt();

            int count = 0;
            int t;
            
            while (ary[7] > 0)
            {
                t = ary[0] - (count % 5 + 1);
                if (t < 0)	t = 0;
                count++;
                for (int j = 0; j < 7; j++)
                    ary[j] = ary[j + 1];
                ary[7] = t;
            }
            
            System.out.printf("#%d ", tc);
            for (int j = 0; j < 8; j++)
            	System.out.printf("%d ", ary[j]);
            System.out.println();

	    }
        sc.close();
    }
}










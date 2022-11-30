package com.ssafy.day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day13_1257_k번째문자열 {
	public static int SA[];
	public static int LCP[];
	public static String input;
	public static int sLen;
	
	public static void selectionsort()
	{
		for (int i = 1; i <= sLen; i++)
		{
			int min = i, t;
			for (int j = i; j <= sLen; j++)
			{
				t = input.substring(SA[min] - 1).compareTo(input.substring(SA[j] - 1)); // "BB" "AA" 1

				if (t > 0) min = j;
			}
			
			t = SA[min];
			SA[min] = SA[i];
			SA[i] = t;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//long start = System.currentTimeMillis();
		System.setIn(new FileInputStream("day13_1257_input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
            int k_th = sc.nextInt();
            input = sc.next();
            
            sLen = input.length();
            SA = new int [sLen + 1];
            LCP = new int [sLen + 1];

            for(int i = 0; i <= sLen; i++)
            	SA[i] = i;
            
            selectionsort();
            
    		for (int i = 2; i <= sLen; i++)
    		{
    			int j = SA[i] - 1;
    			int k = SA[i - 1] - 1;

    			while (input.charAt(j) == input.charAt(k))
    			{
    				LCP[i]++;

    				if(++j >= sLen || ++k >= sLen) break;
    			}
    		}
    		
    		int i = 1;
    		while (k_th >= 0)
    		{
    			k_th = k_th - (sLen - SA[i] - LCP[i]) - 1;
    			i++;
    		}

    		int len = sLen - SA[i - 1] + 1 + k_th;
    		
    		System.out.printf("#%d ", tc);
    		System.out.println(input.substring(SA[i - 1] - 1, SA[i - 1] - 1 + len));
        }
        //System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}


















package com.ssafy.day1;
import java.util.Scanner;

public class day1_1206_view {

	static int[] num = new int[1000];
	
	public static int getMax(int idx) {
		int max = num[idx - 2];

		if (max < num[idx - 1])		max = num[idx - 1];
		if (max < num[idx + 1])		max = num[idx + 1];
		if (max < num[idx + 2])		max = num[idx + 2];

		return max;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 1; tc <= 10; tc++) {
    		int sum = 0, max;
    		int n;
    		n = sc.nextInt();;

    		for (int i = 0; i < n; i++)
    			num[i] = sc.nextInt();;
             
    		for (int i = 2; i < n - 2; i++)
    		{
    			max = getMax(i);
    			if(max < num[i]) 
    				sum = sum + (num[i] - max);
    		}
            
            System.out.println("#" + tc + " " + sum);

        }
    }
}
package com.ssafy.day5;

import java.util.Scanner;

public class day5_1224_계산기3 {
	public static int n, top, peidx;
	public static char[] cstack = new char[120];
	public static int[] istack = new int[120];
	public static char[] pe = new char[120];
	public static char[] e = new char[120];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {

    		n = sc.nextInt();
    		e = sc.next().toCharArray();

    		top = -1;
    		peidx = 0;
    		for (int i = 0; i < n; i++)
    		{
    			if (e[i] == '(')  cstack[++top] = '0';
    			else if (e[i] >= '0')  pe[peidx++] = e[i];
    			else if (e[i] == ')')
    			{
    				while (cstack[top] != '0') 
    					pe[peidx++] = cstack[top--];
    				top--;
    			}
    			else
    			{ // '(' ==> 40 '*' ==> 42,  '+' ==> 43 '0' ==> 48
    				while (top != -1 && e[i] >= cstack[top] ) 
    					pe[peidx++] = cstack[top--];
    				cstack[++top] = e[i];
    			}
    		}

    		top = -1;
    		for (int j = 0; j < peidx; j++)
    		{
    			if (pe[j] >= '0')  istack[++top] = pe[j] - '0';
    			else if (pe[j] == '+') 
    			{
    				top--;
    				istack[top] = istack[top] + istack[top + 1];
    			}
    			else
    			{
    				top--;
    				istack[top] = istack[top] * istack[top + 1];
    			}

    		}
   		
	        System.out.println("#" + tc + " " + istack[0]);
	    }
        sc.close();
    }
}










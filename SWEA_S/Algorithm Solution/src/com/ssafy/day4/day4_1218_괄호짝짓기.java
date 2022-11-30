package com.ssafy.day4;

import java.util.Scanner;

public class day4_1218_괄호짝짓기 {
	public static char [] stack = new char [3000];
	public static int top = -1;
	public static int N;
	public static char [] brackets = new char [3000];
	
	
	
	public static int check_matching()
	{
	    top = -1;
	    for (int i = 0; i < N; i++)
	    {
	        switch (brackets[i])
	        {
	        case '(':     case '<':	        case '{':	        case '[':
	            stack[++top] = brackets[i];
	            break;
	
	        // �ݴ� ��ȣ
	        case ')':
	            if (top == -1 || stack[top] != '(')  return 0;
	            top--;
	            break;
	        case ']':
	            if (top == -1 || stack[top] != '[')  return 0;
	            top--;
	            break;
	        case '>':
	            if (top == -1 || stack[top] != '<')  return 0;
	            top--;
	            break;
	        case '}':
	            if (top == -1 || stack[top] != '{')  return 0;
	            top--;
	            break;
	        }
	    }
	
	    if (top != -1) return 0;
	    return 1;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
	        N = sc.nextInt();
	        brackets = sc.next().toCharArray();
	         
	        System.out.println("#" + tc + " " + check_matching());
	    }
    }
}










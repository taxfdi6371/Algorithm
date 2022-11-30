package com.ssafy.day4;

public class day4_ex_스택구현연습 {

	public static int s[] = new int [10];
	public static int top = -1;

	public static void main(String[] args) 
	{

		s[++top] = 1;
		s[++top] = 2;
		s[++top] = 3;
		System.out.println(s[top--]);
		System.out.println(s[top--]);
		System.out.println(s[top--]);
		
	}
}

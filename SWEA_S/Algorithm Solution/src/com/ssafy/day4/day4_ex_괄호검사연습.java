package com.ssafy.day4;

public class day4_ex_괄호검사연습{

	public static char stack[] = new char[100];
	public static int top = -1;

	public static boolean check_matching(char in[])
	{
		for (int i = 0; i < in.length; i++) 
		{
			switch (in[i])
			{
				case '(':
					stack[++top] = in[i];
					break;
				case ')':
					if (top == -1)  return false;
					top--;
					break;
			}
		}

		if (top != -1) return false;
		return true;
	}
	
	
	public static void main(String[] args) 
	{

		char ary[] = "( )( )((( )))".toCharArray();
		if (check_matching(ary))
			System.out.println("��ȣ�˻缺��");
		else
			System.out.println("��ȣ�˻����");
		
	}
}

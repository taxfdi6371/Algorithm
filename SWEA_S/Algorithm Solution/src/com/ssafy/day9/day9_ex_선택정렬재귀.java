package com.ssafy.day9;


public class day9_ex_선택정렬재귀 {

	public static void recselectionsort(int ary[], int s, int e)
	{
		int mini = s;

		if(s == e) return;

		for(int j = s + 1; j < e; j++)
		{
			if(ary[j] < ary[mini])
				mini = j;
		}
		int t;
		t = ary[s];
		ary[s] = ary[mini];
		ary[mini] = t;

		recselectionsort(ary, s + 1, e);
	}
	
	
	public static void main(String[] args) 
	{
		int ary[] = {5, 2, 7, 1, 3, 8, 9, 3, 5, 2};
		
		recselectionsort(ary, 0, 10);
		
		for(int i = 0; i < 10; i++)
			System.out.printf("%d ",ary[i]);
	}
}



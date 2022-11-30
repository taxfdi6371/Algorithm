package com.ssafy.day9;


public class day9_ex_베이비진반복문 {

	public static void main(String[] args) 
	{
		//int ary[] = {1,2,4,7,8,3};
		//int ary[] = {6,6,7,7,6,7};
		//int ary[] = {0,5,4,0,6,0};
		int ary[] = {1,0,1,1,2,3};
		
		for(int x1 = 0; x1 < 6; x1++)
		for(int x2 = 0; x2 < 6; x2++) if(x2 != x1)
		for(int x3 = 0; x3 < 6; x3++) if(x3 != x1 && x3 != x2)
		for(int x4 = 0; x4 < 6; x4++) if(x4 != x1 && x4 != x2 && x4 != x3)
		for(int x5 = 0; x5 < 6; x5++) if(x5 != x1 && x5 != x2 && x5 != x3 && x5 != x4)
		for(int x6 = 0; x6 < 6; x6++) if(x6 != x1 && x6 != x2 && x6 != x3 && x6 != x4 && x6 != x5)
		{
			int check = 0;
			if(ary[x1] == ary[x2] && ary[x2] == ary[x3]) check++;
			if(ary[x4] == ary[x5] && ary[x5] == ary[x6]) check++;
			if(ary[x1] + 1 == ary[x2] && ary[x2] + 1 == ary[x3]) check++;
			if(ary[x4] + 1 == ary[x5] && ary[x5] + 1 == ary[x6]) check++;

			if(check == 2) 
			{
				System.out.println("baby-gin!");
				return;
			}
		}
		System.out.println("not baby-gin!");
	}
}



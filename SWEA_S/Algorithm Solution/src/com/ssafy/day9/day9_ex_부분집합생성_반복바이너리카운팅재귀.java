package com.ssafy.day9;


public class day9_ex_부분집합생성_반복바이너리카운팅재귀{

	static int [] a = new int [21];
	static int N = 3;
	static int cnt = 1;
	
	static void reset()
	{
		System.out.println("----------------------------");
		cnt = 1;
	}

	static void Print()
	{
		System.out.printf("[%d] : {", cnt++);
		for (int i = 1; i <= N; i++)
			if (a[i] == 1) System.out.printf(" %d ", i);
		System.out.printf("}\n");
	}
	
	static void power_set_i()
	{
		for (int x1 = 0; x1 < 2; x1++)
		{
			a[1] = x1;
			for (int x2 = 0; x2 < 2; x2++)
			{
				a[2] = x2;
				for (int x3 = 0; x3 < 2; x3++)
				{
					a[3] = x3;
					Print();
				}
			}
		}
	}

	static void power_set_b()
	{
		for (int i = 0; i < (1 << N); i++)
		{
			System.out.printf("[%d] : {", cnt++);

			for (int j = 0; j < N; j++)
				if (((i >> j) & 1) == 1)
					System.out.printf(" %d ", j + 1);

			System.out.printf("}\n");
		}
	}

	static void power_set_r(int k)
	{
		if (k == N) Print();
		else
		{
			k++;
			a[k] = 1; power_set_r(k);
			a[k] = 0; power_set_r(k);
		}
	}

	
	public static void main(String[] args) 
	{
		System.out.printf("�κ����� �ݺ���\n");
		power_set_i();
		reset();
		System.out.printf("�κ����� ���̳ʸ� ī����\n");
		power_set_b();
		reset();
		System.out.printf("�κ����� ��͹�\n");
		power_set_r(0);
	}
}



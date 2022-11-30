package com.ssafy.day9;


public class day9_ex_중복순열조합중복조합생성알고리즘3개씩 {

	static int [] t = new int [3];
	static int a[] = { 1, 2, 3 };
	static int cnt_r;
	static int N = 3, R = 2;
	
	static void print_arr()
	{
		System.out.printf("[%d] : ", cnt_r++);

		for (int i = 0; i < R; i++)
			System.out.printf("%d ", t[i]);
		System.out.println();
	}

	static void SWAP(int i, int j)
	{
		int t = a[i];  a[i] = a[j]; a[j] = t;
	}

	static void reset()
	{
		System.out.println("----------------------------");
		cnt_r = 1;
	}



	static void comb_i() // �ݺ��� ����
	{
		int cnt = 1;
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}

	static void pi_i()  // �ݺ��� �ߺ� ����
	{
		int cnt = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}

	static void H_i()  // �ݺ��� �ߺ� ����
	{
		int cnt = 1;
		for (int i = 0; i < N; i++)
			for (int j = i; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}




	static void comb_r_1(int n, int r) //  ���� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else if (n < r) return;
		else
		{
			t[r - 1] = a[n - 1];
			comb_r_1(n - 1, r - 1);
			comb_r_1(n - 1, r);
		}
	}

	static void comb_r_2(int k, int s) // ����, ���ۼ��� // ���� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = s; i <= N + (k - R); i++)
			{
				t[k] = a[i];
				comb_r_2(k + 1, i + 1);
			}
		}
	}


	static void pi_r_1(int n, int r) // �ߺ� ���� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else
		{
			for (int i = n - 1; i >= 0; i--)
			{
				SWAP(i, n - 1);
				t[r - 1] = a[n - 1];
				pi_r_1(n, r - 1);
				SWAP(i, n - 1);
			}
		}
	}

	static void pi_r_2(int k) // ����  // �ߺ� ���� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = 0; i < N; i++)
			{
				t[k] = a[i];
				pi_r_2(k + 1);
			}
		}
	}



	static void H_r_1(int n, int r) //  �ߺ����� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else if (n == 0) return; // ����!!!
		else
		{
			t[r - 1] = a[n - 1];
			H_r_1(n, r - 1);
			H_r_1(n - 1, r);
		}
	}


	static void H_r_2(int k, int s) // ����, ���ۼ��� // �ߺ����� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = s; i < N; i++)
			{
				t[k] = a[i];
				H_r_2(k + 1, i);
			}
		}
	}


	
	public static void main(String[] args) 
	{
		System.out.println("����");
		comb_i();  // �ݺ���
		reset();
		comb_r_1(N, R);
		reset();
		comb_r_2(0, 0);


		System.out.println();
		System.out.println("�ߺ� ����");
		pi_i();  // �ݺ���
		reset();
		pi_r_1(N, R);
		reset();
		pi_r_2(0);

		System.out.println();
		System.out.println("�ߺ� ����");
		H_i();  // �ݺ���
		reset();
		H_r_1(N, R);
		reset();
		H_r_2(0, 0);
		

	}
}



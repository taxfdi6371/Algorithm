package com.ssafy.day6;

//////  �ʺ� �켱 Ž�� 
// �Է� ������
// 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7

public class day6_ex_BFS {

	public static int G[][] = {
			 { 0, 0, 0 },
			 { 2, 3, 0 }, // ���� 1�� ��������
			 { 1, 4, 5 }, // ���� 2�� ��������
			 { 1, 7, 0 }, // ���� 3�� ��������
			 { 2, 6, 0 }, // ���� 4�� ��������
			 { 2, 6, 0 }, // ���� 5�� ��������
			 { 4, 5, 7 }, // ���� 6�� ��������
			 { 3, 6, 0 } };  // ���� 7�� ��������

	public static boolean visited[] = new boolean[8];
	public static int q[] = new int [10];
	public static int f, r;

	public static void BFS(int w)
	{
		System.out.printf("%d ", q[++r] = w);
		visited[w] = true;

		while (f != r) 
		{
			w = q[++f];
			for (int i = 0; i < 3; i++) 
			{
				if (G[w][i] > 0 && !visited[G[w][i]]) 
				{
					System.out.printf("%d ", q[++r] = G[w][i]);
					visited[G[w][i]] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		f = r = -1;
		BFS(1);
	}
}



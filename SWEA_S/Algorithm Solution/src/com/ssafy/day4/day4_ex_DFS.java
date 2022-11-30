package com.ssafy.day4;

// 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4_ex_DFS {

	public static int G[][] = new int [8][8];
//	public static int G[][] = {
//			{ 0, 0, 0, 0, 0, 0, 0, 0},
//			{ 2, 2, 3, 0, 0, 0, 0, 0},  // ���� 1�� ���������� ������ ����������
//			{ 3, 1, 4, 5, 0, 0, 0, 0 },  // ���� 2�� ���������� ������ ����������
//			{ 2, 1, 7, 0, 0, 0, 0, 0 },  // ���� 3�� ���������� ������ ����������
//			{ 2, 2, 6, 0, 0, 0, 0, 0 },  // ���� 4�� ���������� ������ ����������
//			{ 2, 2, 6, 0, 0, 0, 0, 0 },  // ���� 5�� ���������� ������ ����������
//			{ 3, 4, 5, 7, 0, 0, 0, 0 },  // ���� 6�� ���������� ������ ����������
//			{ 2, 3, 6, 0, 0, 0, 0, 0 } };  // ���� 7�� ���������� ������ ����������
	
	public static boolean visited[] = new boolean[8];
	public static int stack[] = new int [10];
	public static int top = -1;

	//���
	public static void DFSr(int G[][], int v)
	{
		visited[v] = true;
		System.out.printf("%d ", v);

		for (int i = 1; i <= G[v][0] ; i++)
			if (!visited[G[v][i]])
				DFSr(G, G[v][i]);
	}

	public static void DFS(int G[][], int V)
	{
		stack[++top] = V;

		while (top != -1)
		{
			int v = stack[top--];

			if (!visited[v])
			{
				visited[v] = true;
				System.out.printf("%d ", v);

				for (int i = G[v][0]; i > 0; i--)
					if (!visited[G[v][i]])
						stack[++top] = G[v][i];

			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner sc = new Scanner(new File("day4_ex_DFS_input.txt"));
		int u, v, i;
		
		for (i = 0; i < 8; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();

			G[u][++G[u][0]] = v;
			G[v][++G[v][0]] = u;
		}

		DFSr(G, 1);
		sc.close();
	}
}



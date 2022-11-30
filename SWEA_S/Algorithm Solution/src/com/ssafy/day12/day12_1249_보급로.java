package com.ssafy.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day12_1249_보급로 {
	public static int M[][] ;
	public static int D[][] ;
	public static int N;
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { 1, -1, 0, 0 };
	
	public static void solve()
	{

		 int x, y, min, curx = 0, cury = 0;
	
		 D[1][1] = 0;
	
		 while (true)
		 {
			 min = 0x7FFFFFFF;
			 
			 for (int i = 1; i <= N; i++)
				 for (int j = 1; j <= N; j++)
					 if (M[i][j] != -1 && D[i][j] < min)
					 {
						 	min = D[i][j];
						 	curx = i;
						 	cury = j;
					 }
	
			 if (curx == N && cury == N) return;
			 
			 M[curx][cury] = -1;
	
			 for (int i = 0; i < 4; i++)
			 {
				  x = curx + dx[i];
				  y = cury + dy[i];
				  if (M[x][y] == -1) continue;
				  if (D[x][y] > min + M[x][y]) D[x][y] = min + M[x][y];
			 }
		 }
	}


	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("day12_1249_input.txt"));
        Scanner sc = new Scanner(System.in);

    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {
        	
        	N = sc.nextInt();
        	
        	M = new int [N + 2][N + 2];
        	D = new int [N + 2][N + 2];

        	sc.nextLine();
			for (int i = 1; i <= N; i++)
			{
				String str = sc.nextLine();
        		for (int j = 1; j <= N; j++)
        		{
        			M[i][j] = str.charAt(j - 1) - '0';
        		    D[i][j] = 0x7FFFFFFF;
        		}
			}

        	solve();
        	
     		System.out.printf("#%d %d\n", tc, D[N][N]);

	    }
        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}




//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
// 
//public class day12_1249_���޷� {
//     
//    static int N;
//    static int[][] initBoard;
//    static int[][] finalBoard;
//    static boolean[][] visit;
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, 1, 0, -1};
//    static Queue<Integer> queueX;
//    static Queue<Integer> queueY;
// 
//    public static void main(String[] args) throws FileNotFoundException {
//         
//    	System.setIn(new FileInputStream("day12_1249_input.txt"));
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//         
//        for (int tc = 1; tc <= T; tc++) {
//             
//            // �ʱ�ȭ
//            N = sc.nextInt();
//            initBoard = new int[N][N];
//            finalBoard = new int[N][N];
//            visit = new boolean[N][N];
//            queueX = new LinkedList<>();
//            queueY = new LinkedList<>();
//            for (int i = 0; i < N; i++) {
//                char[] c = sc.next().toCharArray();
//                for (int j = 0; j < N; j++) {
//                    initBoard[i][j] = c[j] - '0';
//                    finalBoard[i][j] = Integer.MAX_VALUE;
//                }
//            }
//             
//            finalBoard[0][0] = 0;
//            queueX.offer(0);
//            queueY.offer(0);
//             
//            int cnt = 0;
//             
//            while (!queueX.isEmpty()) {
//                cnt++;
//                 
//                int x = queueX.poll();
//                int y = queueY.poll();
//                visit[x][y] = true;
//                 
//                if (x == N - 1 && y == N - 1) { // ������ �����̶��
//                	break;
//                }
//                 
//                for (int i = 0; i < 4; i++) {
//                    int nx = x + dx[i];
//                    int ny = y + dy[i];
//                     
//                    if (nx < 0 || N - 1 < nx || ny < 0 || N - 1 < ny || visit[nx][ny]) { // ���带 ����ų� �湮�� ���̶��
//                        continue;
//                    }
//                     
//                    if (finalBoard[x][y] + initBoard[nx][ny] >= finalBoard[nx][ny]) { // x, y���� nx, ny���� ���°� ���� ����ġ���� ������
//                        continue;
//                    }
//                     
//                    finalBoard[nx][ny] = finalBoard[x][y] + initBoard[nx][ny]; // ����ġ �ֱ�
//                     
//                    queueX.offer(nx);
//                    queueY.offer(ny);
//                }
//            }
//             
//            System.out.println("#" + tc + " " + finalBoard[N - 1][N - 1]);
//        }
//    }
//}



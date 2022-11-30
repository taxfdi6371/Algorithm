import java.util.Scanner;

//public class Main {
public class acm_2468_안전영역 {

	static int [][] mat;
	static int [] qx = new int [10000];
	static int [] qy = new int [10000];
	static int f, r;
	static int [][] stack = new int [10000][2];
	static int top;
	static boolean [][] visited ;
	static int N;
	static int [] dx = { -1, 1, 0, 0 };
	static int [] dy = { 0, 0, -1, 1 };
	static int ans = 1;
	
	static void DFS(int x, int y, int k)
	{
		top = -1;
		
		stack[++top][0] = x;
		stack[top][1] = y;
	
		while (top != -1)
		{
			x = stack[top][0]; y = stack[top--][1];
	
			if (!visited[x][y])
			{
				visited[x][y] = true;
				for (int i = 0; i < 4; i++)
				{
					int xx = x + dx[i];
					int yy = y + dy[i];
					if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
					if (!visited[xx][yy] && mat[xx][yy] > k)
					{
						stack[++top][0] = xx;
						stack[top][1] = yy;
					}
				}
			}
		}
	}
	
	static void DFSr(int x, int y, int k)
	{
		visited[x][y] = true;

		for (int i = 0; i < 4; i++)
		{
			int xx = x + dx[i], yy = y + dy[i];
			if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
			if (!visited[xx][yy] && mat[xx][yy] > k)
				DFSr(xx, yy, k);
		}
	}
	
	static void BFS(int x, int y, int k)
	{
		f = r = -1;
		qx[++r] = x; qy[r] = y;
		visited[x][y] = true;
	
		while (f != r)
		{
			x = qx[++f]; y = qy[f];
			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				if (!visited[xx][yy] && mat[xx][yy] > k)
				{
					qx[++r] = xx; qy[r] = yy;
					visited[xx][yy] = true;
				}
			}
		}
	}
	

	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    	N = sc.nextInt();
    	mat = new int [N][N];
    	
    	int tmax = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
            	mat[i][j] = sc.nextInt();
            	if (mat[i][j] > tmax) tmax = mat[i][j];
            }
        }

    	for (int k = 1; k < tmax; k++)
    	{
    		int cnt = 0;
    		visited = new boolean [N][N];

    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < N; j++)
    				if (!visited[i][j] && mat[i][j] > k) {
    					DFS(i, j, k);
    					//BFS(i, j, k);
    					cnt++;
    				}

    		if (ans < cnt) ans = cnt;
    	}

    	System.out.println(ans);
        sc.close();
    }
}



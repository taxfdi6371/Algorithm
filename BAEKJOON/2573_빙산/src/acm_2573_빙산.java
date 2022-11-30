import java.util.Scanner;

//public class Main {
public class acm_2573_빙산 {
	
	static int [][] mat;
	static int [][] mat2;
	static boolean [][] visited;
	static int lastposX, lastposY;
	static int [] qx = new int [100000];
	static int [] qy = new int [100000];
	static int f, r;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int N, M;
	
	static int step1()
	{
		mat2 = new int [N][M];

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if (mat[i][j] == 0)  continue;
				for (int k = 0; k < 4; k++)
				{
					int xx = i + dx[k];
					int yy = j + dy[k];
					if (mat[xx][yy] == 0)
						mat2[i][j] += 1;
				}
			}
		}
		int cnt = 0;
		lastposX = lastposY = 0;

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				mat[i][j] -= mat2[i][j];
				if (mat[i][j] < 0)
					mat[i][j] = 0;
				if (mat[i][j] > 0)
				{
					cnt++;
					lastposX = i;
					lastposY = j;
				}
			}
		}
		return cnt;
	}

	static int BFS(int x, int y)
	{
		visited = new boolean [N][M];

		f = r = -1;
		qx[++r] = x; qy[r] = y;
		visited[x][y] = true;
		int cnt = 1;

		while (f != r) 
		{
			x = qx[++f]; y = qy[f];
			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i]; 
				int yy = y + dy[i];
				if (!visited[xx][yy] && mat[xx][yy] > 0)
				{
					qx[++r] = xx; qy[r] = yy;
					visited[xx][yy] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    	N = sc.nextInt();
    	M = sc.nextInt();
    	mat = new int [N][M];
    	
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
            	mat[i][j] = sc.nextInt();
    	
    	int ans = 1;
    	int cnt = 0;
    	
    	while (true)
    	{
    		cnt = step1();   //녹인다.
    		if (cnt == 0)
    		{
    			ans = 0;
    			break;
    		}
    		int tcnt = BFS(lastposX, lastposY);
    		if (cnt != tcnt) break;
    		ans++;
    	}

    	System.out.println(ans);
    	
        sc.close();
    }
}

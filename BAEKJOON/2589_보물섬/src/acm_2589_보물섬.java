import java.util.Scanner;

//public class Main {
public class acm_2589_보물섬 {
	
	static int [] qx = new int [10000];
	static int [] qy = new int [10000];
	static int f, r;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static char [][] mat = new char [50][50];
	static int N, M;


	static int BFS(int x, int y)
	{
		int [][] dist = new int [N][M];

		f = r = -1;
		qx[++r] = x; qy[r] = y;

		dist[x][y] = 1;

		while (f != r)
		{
			x = qx[++f]; y = qy[f];
			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				if (mat[xx][yy] == 'L' && dist[xx][yy] == 0)
				{
					qx[++r] = xx; qy[r] = yy;
					dist[xx][yy] = dist[x][y] + 1;
				}
			}
		}

		int max = dist[0][0];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (max < dist[i][j])
					max = dist[i][j];

		return max - 1;
	}
	

	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    	N = sc.nextInt();
    	M = sc.nextInt();

        for(int i = 0; i < N; i++){
            String input = sc.next();
            for(int j = 0; j < M; j++){
            	mat[i][j] = input.charAt(j);
            }
        }

    	int ans = 0;
    	for (int i = 0; i < N; i++)
    	{
    		for (int j = 0; j < M; j++)
    		{
    			if (mat[i][j] == 'L')
    			{
    				int t = BFS(i, j);
    				ans = ans < t ? t : ans;
    			}
    		}
    	}

        System.out.println(ans);

        sc.close();
    }
}

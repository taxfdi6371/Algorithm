import java.util.Scanner;

//public class Main {
public class acm_2636_치즈 {
	static int N, M;
	static int [][] mat;
	static int [] qx = new int [10000];
	static int [] qy = new int [10000];
	static int f, r;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	
	// 공기 2로 표시하기
	static void step1(int x, int y)
	{
		f = r = -1;
		qx[++r] = x; qy[r] = y;
		mat[x][y] = 2;

		while (f != r) 
		{
			x = qx[++f]; y = qy[f];
			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i]; 
				int yy = y + dy[i];
				if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				if (mat[xx][yy] == 0) 
				{
					qx[++r] = xx; qy[r] = yy;
					mat[xx][yy] = 2;
				}
			}
		}
	}

	// 치즈의 공기와 접촉된 면을 표시하기 3, 치즈 내부 4
	static void step2(int x, int y)
	{
		f = r = -1;
		qx[++r] = x; qy[r] = y;
		mat[x][y] = 3;


		while (f != r)
		{
			x = qx[++f]; y = qy[f];
			for (int i = 0; i < 4; i++)
			{
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				if (mat[xx][yy] == 1)
				{
					mat[xx][yy] = 4;
					if (mat[xx + 1][yy] == 2 || mat[xx - 1][yy] == 2 || mat[xx][yy + 1] == 2 || mat[xx][yy - 1] == 2)
						mat[xx][yy] = 3;
					qx[++r] = xx; qy[r] = yy;
				}
			}
		}
	}

	// 치즈 녹이기, 자료 재 정리, 치지 개수 반환
	static int step3()
	{
		int cnt = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if (mat[i][j] == 2) mat[i][j] = 0;
				else if (mat[i][j] == 3)
				{
					mat[i][j] = 0;
					cnt++;
				}
				else if (mat[i][j] == 4)
					mat[i][j] = 1;
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
    	
    	int cnt = 0;
    	int last_cheeze = 0;
    	
    	while (true)
    	{
    		cnt++;
    		step1(0, 0);
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < M; j++)
    				if (mat[i][j] == 1)
    					step2(i, j);

    		last_cheeze = step3();

    		int tsum = 0;
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < M; j++)
    				tsum += mat[i][j];

    		if (tsum == 0) break;
    	}

    	System.out.println(cnt);
    	System.out.println(last_cheeze);
        sc.close();
    }
}

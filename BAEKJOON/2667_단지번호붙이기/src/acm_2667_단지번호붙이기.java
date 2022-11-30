import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class acm_2667_단지번호붙이기 {

	static int [][] mat = new int [25][25];
	static int [] res = new int [625];
	static int N;
	static int [] dx = { 0, 0, 1, -1 };
	static int [] dy = { 1, -1, 0, 0 };
	static int [][] stack = new int [625][2];
	static int top = -1;
	
	static int DFS(int x, int y)
	{
		stack[++top][0] = x;
		stack[top][1] = y;

		int ret = 0;

		while (top != -1)
		{
			x = stack[top][0];
			y = stack[top--][1];

			if (mat[x][y] != 0)
			{
				mat[x][y] = 0;
				ret++;
				for (int i = 0; i < 4; i++)
				{
					int xx = x + dx[i];
					int yy = y + dy[i];
					if (xx < 0 || xx >= N || yy < 0 || yy >= N) 
						continue;
					if (mat[xx][yy] == 1)
					{
						stack[++top][0] = xx;
						stack[top][1] = yy;
					}
				}
			}
		}
		return ret;
	}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    	N = sc.nextInt();

        for(int i = 0; i < N; i++){
            String input = sc.next();
            for(int j = 0; j < N; j++){
            	mat[i][j] = input.charAt(j)-'0';
            }
        }

    	int cnt = 0;
    	for (int i = 0; i < N; i++)
    		for (int j = 0; j < N; j++)
    			if (mat[i][j] == 1)
    				res[cnt++] = DFS(i, j);
    	
        int [] t = new int [cnt];
        for (int i = 0; i< cnt; i++)
        	t[i] = res[i];
    	Arrays.sort(t);
        System.out.println(cnt);

        for(int i = 0; i < t.length; i++)
            System.out.println(t[i]);

        sc.close();
    }
}

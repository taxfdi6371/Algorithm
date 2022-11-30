package com.ssafy.day2;

public class day2_ex_회오리순회 {

    public static int ary[][] = 
        { { 9, 20, 2, 18, 11 },
        { 19, 1, 25, 3, 21 },
        { 8, 24, 10, 17, 7 },
        { 15, 4, 16, 5, 6 },
        { 12, 13, 22, 23, 14 } };
	
	public static boolean isWall(int x, int y)
	{
	    if (x < 0 || x >= 5 || y < 0 || y >= 5) return true;
	    return false;
	}
	
	public static int sel_min()
	{
	    int min = 0;
	    int minX = 0, minY = 0;

	    min = ary[0][0];
	    for (int i = 0; i < 5; i++)
	        for (int j = 0; j < 5; j++)
	            if (min > ary[i][j])
	            {
	                min = ary[i][j];
	                minX = i;	minY = j;
	            }

	    ary[minX][minY] = 26;
	    return min;
	}
	
	public static void main(String[] args) {
    
        int [][] sorted_ary = new int [5][5];
        int cur_min = -1;
        int X, Y;
        int newX = 0, newY = 0;

        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        int dir_stat = 0;

        for (int i = 0; i < 25; i++)
        {
            cur_min = sel_min();
            X = newX;
            Y = newY;
            sorted_ary[Y][X] = cur_min;

            newX = X + dx[dir_stat];
            newY = Y + dy[dir_stat];
            if (isWall(newX, newY) || sorted_ary[newY][newX] != 0 )
            {
                dir_stat = (dir_stat + 1) % 4;
                newX = X + dx[dir_stat];
                newY = Y + dy[dir_stat];
            }
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            	System.out.printf("%3d", sorted_ary[i][j]);
            System.out.println();
        }
	}

}

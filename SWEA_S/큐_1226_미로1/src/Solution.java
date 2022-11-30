import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			System.out.print("#" + t + " ");

			int[][] G = new int[16][16];

			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					G[i][j] = s.charAt(j) - '0';
				}
			}

			int[][] q = new int[2][400];
			int front = -1;
			int rear = -1;

			q[0][++rear % 400] = 1; // y
			q[1][rear % 400] = 1; // x

			G[1][1] = 1; // 방문한것으로 표시

			boolean flag = false;

			while (front != rear) {
				int y = q[0][++front % 400];
				int x = q[1][front % 400];
				if (x == 13 && y == 13) {
					flag = true;
				}
				if (G[y - 1][x] != 1) { // 위
					q[0][++rear % 400] = y - 1;
					q[1][rear % 400] = x;
					G[y - 1][x] = 1;
				}
				if (G[y + 1][x] != 1) { // 아래
					q[0][++rear % 400] = y + 1;
					q[1][rear % 400] = x;
					G[y + 1][x] = 1;
				}
				if (G[y][x - 1] != 1) { // 좌
					q[0][++rear % 400] = y;
					q[1][rear % 400] = x - 1;
					G[y][x - 1] = 1;
				}
				if (G[y][x + 1] != 1) { // 우
					q[0][++rear % 400] = y;
					q[1][rear % 400] = x + 1;
					G[y][x + 1] = 1;
				}
			}

			if (flag) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
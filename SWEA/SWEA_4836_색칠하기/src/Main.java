import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성하세요.
			int[][] arr = new int[10][10]; // 행렬 10x10

			int N = Integer.parseInt(in.readLine()); // 칠할 영역의 개수

			int count = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int c1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());

				int color = Integer.parseInt(st.nextToken());

				for (int k = r1; k < r2 + 1; k++) {
					for (int k2 = c1; k2 < c2 + 1; k2++) {
						if (arr[k][k2] == 0) { // 빈 공간이라면 채움
							arr[k][k2] = color;
						} else if ((arr[k][k2] == 1) && (color == 2)) { // 다른 색이 있다면 -1로 변경
							arr[k][k2] = -1;
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}

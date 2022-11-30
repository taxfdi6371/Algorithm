import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution {
	public static int[][] tree;
	public static StringBuilder sb;

	public static void inorder(int v) {
		if (v != 0) {
			inorder(tree[v][1]);
			sb.append((char)tree[v][0]);
			inorder(tree[v][2]);
		}
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = Integer.parseInt(sc.nextLine());

			tree = new int[n + 1][3];
			sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				int v = Integer.parseInt(st.nextToken());
				int idx = 0;
				tree[v][idx++] = st.nextToken().charAt(0);
				while (st.hasMoreTokens()) {
					tree[v][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			inorder(1);
			System.out.println(sb);
		}
	}

}
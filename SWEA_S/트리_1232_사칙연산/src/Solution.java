import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution {
	public static int[][] tree;
	public static String[] data;

	public static double postorder(int v) {
		double op1;
		double op2;

		if (tree[v][0] == 0 && tree[v][1] == 0) { // 단말 노드라면(피연산자라면)
			return Double.parseDouble(data[v]);
		}

		op1 = postorder(tree[v][0]);
		op2 = postorder(tree[v][1]);

		switch (data[v].charAt(0)) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;

		}
		
		return 0;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = Integer.parseInt(sc.nextLine());

			tree = new int[n + 1][3];
			data = new String[n + 1];

			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				int v = Integer.parseInt(st.nextToken());

				data[v] = st.nextToken();

				int idx = 0;
				while (st.hasMoreTokens()) {
					tree[v][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println((int)postorder(1));
		}
	}

}
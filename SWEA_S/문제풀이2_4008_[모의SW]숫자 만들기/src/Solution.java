import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] num;
	public static int[] op;
	public static int N;

	public static int max;
	public static int min;

	public static void dfs(int r, int k) {
		// 연산자를 모두 사용하면
		if (k == N) {
			max = Math.max(max, r);
			min = Math.min(min, r);
		} else {
			for (int i = 0; i < 4; i++) {
				if (op[i] > 0) {
					op[i]--;
					dfs(calc(r, num[k], i), k + 1);
					op[i]++;
				}
			}
		}
	}

	public static int calc(int n1, int n2, int opIdx) {
		switch (opIdx) {
		case 0:
			n1 += n2;
			break;
		case 1:
			n1 -= n2;
			break;
		case 2:
			n1 *= n2;
			break;
		case 3:
			n1 /= n2;
			break;
		}

		return n1;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			num = new int[N];
			op = new int[4];

			for (int i = 0; i < 4; i++) {
				op[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			dfs(num[0], 1);

			System.out.println("#" + test_case + " " + (max - min));
		}
	}

}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static String[] str = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
	public static int[] count;

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.next();
			int n = sc.nextInt();
			count = new int[10];

			for (int i = 0; i < n; i++) {
				String s = sc.next();
				switch (s) {
				case "ZRO":
					count[0]++;
					break;
				case "ONE":
					count[1]++;
					break;
				case "TWO":
					count[2]++;
					break;
				case "THR":
					count[3]++;
					break;
				case "FOR":
					count[4]++;
					break;
				case "FIV":
					count[5]++;
					break;
				case "SIX":
					count[6]++;
					break;
				case "SVN":
					count[7]++;
					break;
				case "EGT":
					count[8]++;
					break;
				case "NIN":
					count[9]++;
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if (count[idx] == 0) {
					idx++;
				}
				sb.append(str[idx]).append(" ");
				count[idx]--;
			}

			System.out.println("#" + test_case + " " + sb);
		}
	}

}
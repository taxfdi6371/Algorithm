import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int k = sc.nextInt();
			String str = sc.next();
			String[] sa = new String[str.length()];
			int[] lcp = new int[str.length()];

			// sa 배열 생성
			for (int i = 0; i < sa.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = i; j < sa.length; j++) {
					sb.append(str.charAt(j));
				}
				sa[i] = sb.toString();
				
			}

			Arrays.sort(sa); // 오름차순 정렬

			// lcp 배열 생성
			for (int i = 1; i < sa.length; i++) {
				int min = Math.min(sa[i - 1].length(), sa[i].length());
				int count = 0;
				for (int j = 0; j < min; j++) {
					if (sa[i - 1].charAt(j) == sa[i].charAt(j)) {
						count++;
					} else {
						break;
					}
				}
				lcp[i] = count;
			}

			String result = "";
			int check = 0;
			for (int i = 0; i < sa.length; i++) {
				check += (sa[i].length() - lcp[i]);
				if (check >= k) {
					result = sa[i].substring(0, sa[i].length() - (check - k));
					break;
				}
			}
			if(check < k) {
				result = "none";
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

	public static int[] init(String s, int sLength) {
		int[] skip = new int[26];
		for (int i = 0; i < 26; i++) { // skip배열 초기화
			skip[i] = sLength;
		}
		for (int i = 0; i < sLength; i++) { // skip 위치
			skip[s.charAt(i) - 'a'] = sLength - 1 - i;
		}
		return skip;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int t = sc.nextInt();
			System.out.print("#" + t + " ");

			String s = sc.next(); String str = sc.next() + " ";

			String[] result = str.split(s);

			if (result.length != 0) {
				System.out.println(result.length - 1);
			} else {
				System.out.println(0);
			}

		}
	}
}
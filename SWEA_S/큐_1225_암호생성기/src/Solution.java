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
			int[] arr = new int[8];

			int idx = -1;
			int x = 1;

			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
			}
			do {
				arr[++idx % 8] -= x++;
				if (x > 5) {
					x = 1;
				}
			} while (arr[idx % 8] > 0);

			for (int i = 0; i < 8; i++) {
				idx++;
				if (arr[idx % 8] > 0) {
					System.out.print(arr[idx % 8] + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

}
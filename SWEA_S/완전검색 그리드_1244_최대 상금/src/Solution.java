import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] arr;
	public static int size = 0;
	public static int max = 0;
	public static boolean[] visited;

	public static void func(int n, int idx) {
		if (n == 0) { // 모든 교환이 끝나면
			StringBuilder sb = new StringBuilder();
			int num = 0;
			for (int i = 0; i < size; i++) {
				sb.append(arr[i]);
			}
			num = Integer.parseInt(sb.toString());
			if (num > max) {
				max = num;
			}
			return;
		}
		for (int i = idx; i < size; i++) {
			visited[i] = true;
			for (int j = i + 1; j < size; j++) {
				if (arr[i] <= arr[j]) {
					swap(i, j);
					func(n - 1, i);
					swap(i, j);
				}
			}
		}
		// 현재 숫자가 가장 크지만, 교환횟수가 남은 경우
		if (n % 2 == 1) {
			swap(size - 2, size - 1);
		}
		func(0, idx);
		swap(size - 2, size - 1);
	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int test_case = 1; test_case <= t; test_case++) {

			String s = sc.next(); // 숫자판
			int n = sc.nextInt(); // 교환 횟수

			size = s.length();
			arr = new int[size];
			max = 0;
			visited = new boolean[size];

			for (int i = 0; i < size; i++) { // 배열 초기화
				arr[i] = s.charAt(i) - '0';
			}

			func(n, 0);

			System.out.println("#" + test_case + " " + max);
		}
	}

}
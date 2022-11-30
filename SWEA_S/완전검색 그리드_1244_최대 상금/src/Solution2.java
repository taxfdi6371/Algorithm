import java.util.Scanner;
import java.io.FileInputStream;

class Solution2 {
	public static int[] arr;
	public static int size = 0;
	public static int num = 0;
	public static boolean sFlag = false;

	public static void func(int n, int idx) {
		if (n == 0) { // 모든 교환이 끝나면
			int p = 1;
			for (int i = size - 1; i > -1; i--) {
				num += arr[i] * p;
				p *= 10;
			}
			return;
		} else if (n > 0 && idx == size - 2) { // 교환이 끝나지 않았고, 인덱스가 마지막 -1까지 왔다면
			if (sFlag) { // 
				func(0, 0);
			} else {
				swap(idx, idx + 1);
				func(n - 1, idx);
			}
		} else {
			int max = arr[idx];
			int maxIdx = size - 1;
			boolean flag = false;

			for (int i = size - 1; i > idx; i--) {
				// 끝에서부터 현재 위치 숫자 보다 큰 숫자를 찾는다.
				if (max < arr[i]) {
					max = arr[i];
					maxIdx = i;
					flag = true;
				}
			}
			if (flag) {
				swap(idx, maxIdx);
				func(n - 1, idx + 1);
			} else { // 찾지 못했다면, 교환을 진행하지 않고 다음 교환할 자리수를 찾는다.
				func(n, idx + 1);
			}
		}
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
			System.out.print("#" + test_case + " ");

			String s = sc.next(); // 숫자판
			size = s.length();
			arr = new int[size];

			int n = sc.nextInt(); // 교환 횟수

			num = 0;

			for (int i = 0; i < size; i++) { // 배열 초기화
				arr[i] = s.charAt(i) - '0';
			}
			sFlag = false;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i != j && arr[i] == arr[j]) {
						sFlag = true;
					}
				}
			}

			func(n, 0);
			System.out.println(num);
		}
	}

}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] plan;
	public static int[] fee;
	public static int remain;

	public static int min;

	public static void func(int sum, int cnt, int idx) {
		if (cnt >= remain) {
			min = Math.min(sum, min);
		} else if (sum > min) {
			return;
		} else {
			for (int i = idx; i < 12; i++) {
				if (plan[i] > 0) {
					func(sum + plan[i] * fee[0], cnt + 1, i + 1); // 하루 이용권
					func(sum + fee[1], cnt + 1, i + 1); // 한달 이용권
					func(sum + fee[2], cnt + available(i), i + 3); // 세달 이용권
					break;
				}
			}
		}
	}

	public static int available(int idx) {
		int a = 0;
		for (int i = idx; i < idx + 3; i++) {
			if (i < 12 && plan[i] > 0) {
				a++;
			}
		}
		return a;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			plan = new int[12];
			fee = new int[4];

			for (int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}

			// 1년 이용권을 최소값으로 두고 계산한다.
			min = fee[3];

			boolean flag = true;
			int idx = -1;
			remain = 0;
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
				if (plan[i] > 0) {
					remain++;
					if (flag) {
						idx = i; // 첫번째로 이용할 계획이 나온 달
						flag = false;
					}
				}
			}

			func(0, 0, idx);

			System.out.println("#" + test_case + " " + min);
		}
	}

}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	
	public static int func(int num, int pow) {
		if (pow == 1) {
			return num;
		} else {
			return num * func(num, pow - 1);
		}
	}
	
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			System.out.print("#" + t + " ");

			int num = sc.nextInt();
			int pow = sc.nextInt();

			int result = func(num, pow);
			
			System.out.println(result);
		}
	}
}
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			System.out.print("#" + t + " ");

			int[] road1 = new int[100];
			int[] road2 = new int[100];

			Stack<Integer> stack = new Stack<Integer>();

			int size = sc.nextInt();

			for (int i = 0; i < size; i++) {
				int departure = sc.nextInt(); // 출발 지점
				int arrival = sc.nextInt(); // 도착 지점

				if (road1[departure] == 0) {
					road1[departure] = arrival;
				} else {
					road2[departure] = arrival;
				}
			}

			int success = 0;
			int point = 0;
			stack.push(point);
			while (success == 0) {
				if (stack.peek() != point) {
					stack.push(point); // 지나간 경로를 스택에 담음
				}
				if (road1[point] != 0) { // 다음 경로로 가는 간선이 있으면 진행
					point = road1[point];
				} else if (road2[point] != 0) {
					point = road2[point];
				} else { // 다음 경로로 가는 간선이 없으면
					int check = point;
					stack.pop();
					if(stack.isEmpty()) { // 0에서도 더이상 갈 곳이 없으면
						break; // 종료
					}
					point = stack.peek(); // 이전 지점으로 이동
					if (road1[point] == check) { // 간선 제거
						road1[point] = 0;
					} else if (road2[point] == check) {
						road2[point] = 0;
					}
				}
				if (point == 99) {
					success = 1;
				}
			}

			System.out.println(success);
		}
	}

}
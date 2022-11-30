import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

	public static void main(String args[]) throws Exception {
		// 파일 입출력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = sc.nextInt();

			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int deadlock = 0;
			
			for (int i = 0; i < n; i++) {
				boolean redFlag = false;
				
				for (int j = 0; j < n; j++) {
					// 붉은 자성체를 만났을 때
					if(arr[j][i] == 1) { 
						redFlag = true;
					// 붉은 자성체가 쌓여있는데 푸른 자성체를 만나면 교착상태에 추가
					} else if(redFlag && arr[j][i] == 2) { 
						redFlag = false;
						deadlock++;
					}
				}
			}
			System.out.println(deadlock);
		}
	}
}
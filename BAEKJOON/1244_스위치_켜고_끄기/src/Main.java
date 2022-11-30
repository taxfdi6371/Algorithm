import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int n = Integer.parseInt(br.readLine()) + 1;

		int[] arr = new int[n]; // n칸 배열 생성

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++) { // 스위치 초기화
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int students = Integer.parseInt(br.readLine()); // 학생 수

		for (int i = 0; i < students; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken()); // 성별
			int num = Integer.parseInt(st2.nextToken()); // 번호

			if (gender == 1) { // 남학생
				int multiple = num;
				while (multiple < n) {
					arr[multiple]++;
					multiple += num; // 배수
				}
			} else { // 여학생
				if (num < n) {
					arr[num]++; // 받은 숫자 상태 변경
					int left = num - 1;
					int right = num + 1;
					while (left > 0 && right < n) {
						if (arr[left] % 2 == arr[right] % 2) {
							arr[left--]++;
							arr[right++]++;
						} else {
							break;
						}
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < n; i++) {
			sb.append(arr[i] % 2).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb);

		br.close();
	}

}

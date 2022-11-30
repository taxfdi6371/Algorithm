import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성하세요.
			StringTokenizer st = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(st.nextToken().toString()); // 이동 가능 정류장 수
			int N = Integer.parseInt(st.nextToken().toString()); // 종점 정류장
			int M = Integer.parseInt(st.nextToken().toString()); // 충전기 설치된 정류장 수

			StringTokenizer st2 = new StringTokenizer(in.readLine());
			int[] station = new int[N + 1];
			for (int i = 0; i < M; i++) {
				int index = Integer.parseInt(st2.nextToken().toString());
				station[index] = 1;
			}

			int count = 0; // 충전 횟수
			int point = 0; // 현재 위치
			for (int i = 0; i < N + 1; i++) {
				int now = point; // 현재 위치를 now에 저장
				point += K; // 이동할 수 있는 만큼 이동
				if(point >= N) { // 종점을 지나면 종료
					break;
				}
				while(station[point] == 0) { // 현재 위치에 충전소가 없으면
					point--; // 한칸씩 뒤로 이동
				}
				if(now == point) { // 뒤로간 거리가 이동하기 전과 같으면 종료
					count = 0;
					break;
				}
				count++;
				
			}
			System.out.println(count);
		}
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[2][7];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			room[gender][grade]++;
			
			if(room[gender][grade] == 1) { // 처음 들어왔을때
				cnt++;
			} else if(room[gender][grade] > K) { // 최대인원보다 많아지면
				cnt++;
				room[gender][grade] = 1;
			} 
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}

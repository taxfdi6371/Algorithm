import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] cost;
	static ArrayList<Sale>[] saleData;
	static int[] perm;

	static int result;

	static class Sale {
		int n;
		int dc;

		public Sale(int n, int dc) {
			this.n = n;
			this.dc = dc;
		}
	}

	static void setPermutation(int d) {
		if (d == N + 1) {
			getResult();
		} else {
			for (int i = 1; i <= N; i++) {
				if (perm[i] == 0) { // 아직 순서가 정해지지 않았을 때
					perm[i] = d;

					setPermutation(d + 1);

					perm[i] = 0;
				}
			}
		}
	}

	static void getResult() {
		int sum = 0; // 물약을 모두 구매한 후 결과 값
		int[] tCost = cost.clone();

		for (int i = 1; i <= N; i++) {
			int num = perm[i];
			sum += tCost[num]; // 전체 가격에 추가

			// num 번 구매시 함께 할인 되는 정보를 모두 찾아 반영
			for (int j = 0; j < saleData[num].size(); j++) {
				Sale sale = saleData[num].get(j);
				int n = sale.n;
				int dc = sale.dc;
				
				// 할인 후 가격이 0보다 작아지면 가격을 1로 지정
				if (tCost[n] - dc > 0) {
					tCost[n] -= dc;
				} else {
					tCost[n] = 1;
				}
			}
		}

		result = Math.min(result, sum);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine()); // 물약의 개수
		cost = new int[N + 1]; // 1 ~ N까지 물약별 가격 정보
		saleData = new ArrayList[N + 1]; // 1 ~ N 까지 구매 시 같이 할인되는 정보

		// 물약별 가격 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			saleData[i] = new ArrayList<>(); // 할인 정보 리스트 초기화
		}

		// 할인 정보
		for (int i = 1; i <= N; i++) {
			int pi = Integer.parseInt(br.readLine());

			for (int j = 0; j < pi; j++) {
				st = new StringTokenizer(br.readLine());
				int aj = Integer.parseInt(st.nextToken()); // 할인 할 번호
				int dj = Integer.parseInt(st.nextToken()); // 내릴 가격

				// 할인 정보를 객체로 만들어 리스트에 추가한다.
				saleData[i].add(new Sale(aj, dj));
			}
		}

		result = Integer.MAX_VALUE; // 가장 싸게 샀을 때 결과 값
		perm = new int[N + 1]; // 순열

		setPermutation(1);

		System.out.println(result);

		br.close();
	}

}

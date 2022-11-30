public class SubsetSum {
	public static void main(String[] args) {

		int[] arr = { 3, -2, -8, 5, 6, -4, 1, 2, -7, 9 };

		int n = arr.length;
		int count = 0;

		for (int i = 1; i < (1 << n); i++) { // 모든 부분집합 경우의 수 00 0000 0001 ~ 10 0000 0000
			int sum = 0;
			int[] arrIdx = new int[n];
			int idx = 0;
			for (int j = 0; j < n; j++) { // 부분집합의 원소의 개수(1개 ~ n개)
				if ((i & (1 << j)) > 0) {  // 비트 마스크
					sum += arr[j];
					arrIdx[idx++] = j;
				}
			}
			if (sum == 0) {
				count++;
				System.out.printf("[%2d]{",count);
				for (int j = 0; j < idx; j++) {
					System.out.printf("%3d",arr[arrIdx[j]]);
				}
				System.out.println(" }");
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
	static String S;
	static String T;
	static int result;

	static void dfs(StringBuilder t) {
		if (check(t))
			return;

		StringBuilder t1 = new StringBuilder(t);
		if (t1.charAt(t1.length() - 1) == 'A') {
			t1.deleteCharAt(t1.length() - 1);
			dfs(t1);
		}

		StringBuilder t2 = new StringBuilder(t);
		if (t2.charAt(0) == 'B') {
			t2.deleteCharAt(0);
			t2.reverse();
			dfs(t2);
		}
	}

	static boolean check(StringBuilder t) {
		if (S.equals(t.toString())) {
			result = 1;
			return true;
		}

		if (S.length() == t.length() && !S.equals(t.toString())) {
			if (result != 1)
				result = 0;
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		S = br.readLine();
		T = br.readLine();

		result = 0;

		StringBuilder t = new StringBuilder(T);

		dfs(t);
		
		System.out.println(result);

		br.close();
	}

}

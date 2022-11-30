import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String str;
	
	public static boolean isPalindrome(int start) {
		
		int end = str.length() - 1;
		
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end))
				return false;

			start++;
			end--;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		str = br.readLine();

		for (int i = 0; i < str.length() ; i++) {
			if(isPalindrome(i)) {
				System.out.print(str.length() + i);
				break;
			}
		}
		
		br.close();
	}
}

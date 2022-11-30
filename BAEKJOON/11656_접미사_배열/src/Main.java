import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		String s = br.readLine();
		
		ArrayList<String> al = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				sb.append(c);
			}
			al.add(sb.toString());
		}
		
		Collections.sort(al);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		br.close();
	}

}

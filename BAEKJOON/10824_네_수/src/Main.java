import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		StringBuilder ab = new StringBuilder();
		StringBuilder cd = new StringBuilder();
		
		ab.append(a).append(b);
		cd.append(c).append(d);
		
		long rab = Long.parseLong(ab.toString());
		long rcd = Long.parseLong(cd.toString());
		
		System.out.print(rab + rcd);
		
		br.close();
	}

}

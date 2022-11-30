import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int H = Integer.parseInt(st.nextToken());
	        int W = Integer.parseInt(st.nextToken());

	        int[] block = new int[W];

	        st = new StringTokenizer(br.readLine());
	        for(int i = 0; i < W; i++){
	            block[i] = Integer.parseInt(st.nextToken());
	        }

	        int total = 0;

	        for(int i = 1; i <= H; i++){
	            int start = -1;
	            boolean isOneBlock = false;
	            for(int j = 0; j < W; j++){
	                if(block[j] >= i){
	                    if(start != -1){
	                        total += (j - start - 1);
	                        start = j;
	                        isOneBlock = false;
	                    }else{
	                        start = j;
	                        isOneBlock = true;
	                    }
	                }
	            }
	            
	            // 시작 지점을 못찾거나 벽이 하나만 존재하는 경우
	            if(start == -1 || isOneBlock) {
	            	break;
	            }
	        }

	        System.out.print(total);
	        br.close();
	}

}

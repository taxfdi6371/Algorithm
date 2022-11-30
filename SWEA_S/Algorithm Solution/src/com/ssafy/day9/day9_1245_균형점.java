package com.ssafy.day9;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class day9_1245_������ {
//
//	static int [] pos = new int [10];
//	static int [] w = new int [10];
//	static double [] ans = new double [10];
//	static int cnt;
//
//	
//
//	static double force(int s, int e, double m)
//	{
//		double f = 0, d;
//	
//		for (int i = s; i <= e; i++)
//		{
//			d = pos[i] - m;
//			f += w[i] / (d * d);
//		}
//	
//		return f;
//	}
//	
//	
//	static void solve()
//	{
//		double L, R, mid, fL, fR;
//	
//		for (int k = 0; k < cnt - 1; k++)
//		{
//			L = pos[k];
//			R = pos[k + 1];
//	
//			while (true)
//			{
//				mid = (L + R) / 2.0;
//	
//				fL = force(0, k, mid);
//				fR = force(k + 1, cnt - 1, mid);
//	
//				if (fL > fR) 	L = mid;
//				else 			R = mid;
//	
//				if (R - L < 1e-12) break;   /////////////////////////
//			}
//	
//			ans[k] = mid;
//		}
//	}
//	
////	static void solve()
////	{
////		double L, R, mid = 0.0, fL, fR;
////
////		for (int k = 0; k < cnt - 1; k++)
////		{
////			L = pos[k];
////			R = pos[k + 1];
////			for (int i = 0; i < 100; i++)   /////////////////////////
////			{
////				mid = (L + R) / 2.0;
////
////				fL = force(0, k, mid);
////				fR = force(k + 1, cnt - 1, mid);
////
////				if (fL > fR) 	L = mid;
////				else 			R = mid;
////			}
////			ans[k] = mid;
////		}
////	}
//	
//
//	
//	public static void main(String[] args) throws FileNotFoundException{
//		
//		System.setIn(new FileInputStream("day9_1245_input.txt"));
//        Scanner sc = new Scanner(System.in);
//
//    	sc.nextInt();
//    	
//        for(int tc = 1; tc <= 10; tc++) {
//    		
//        	cnt = sc.nextInt();
//    		
//    		for (int i = 0; i < cnt; i++) pos[i] = sc.nextInt();;
//    		for (int i = 0; i < cnt; i++) w[i] = sc.nextInt();
//
//    		solve();
//
//    		System.out.printf("#%d ", tc);
//    		for (int i = 0; i < cnt - 1; i++)
//    			System.out.printf(" %.10f", ans[i]);
//    		System.out.println();
//    	}
//        sc.close();
//    }
//}
//
//



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class day9_1245_균형점 {
    static int N;
    static int[] pos;
    static int[] weight;
     
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("day9_1245_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            pos = new int[N];
            weight = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pos[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
             
            System.out.print("#" + testcase);
            for (int i = 0; i < N-1; i++) {
                System.out.printf(" %.10f", solve(i, (double)(pos[i]+pos[i+1])/2.0, pos[i], pos[i+1]));
            } // i
            System.out.println();
        } // tc
    }
     
    private static double solve(int p, double point, double left, double right) {
        if(right - left < 1e-12) {
            return point;
        }
         
        double leftW = 0, rightW = 0, ANSWER;
        for (int i = 0; i <= p; i++) {
            leftW += weight[i] / ((point-pos[i])*(point-pos[i]));
        }
        for (int i = p+1; i < N; i++) {
            rightW += weight[i] / ((point-pos[i])*(point-pos[i]));
        }
         
        if(leftW == rightW) {
            ANSWER = point;
        } else if(leftW < rightW){
            ANSWER = solve(p, (double)(left+point)/2.0, left, point);
        } else {
            ANSWER = solve(p, (double)(right+point)/2.0, point, right);
        }
         
        return ANSWER;
    }
     
}





package com.ssafy.day1;
//ver.1
import java.util.Scanner;

public class day1_1208_Flatten {

	public static int data[] = new int[100];
	public static int dumpCount;

	
	public static int solve()
	{
		int maxIndex, minIndex;

		while (dumpCount != 0)
		{
			maxIndex = minIndex = 0;

			for (int i = 1; i < 100; i++)
			{
				if (data[maxIndex] < data[i]) maxIndex = i;
				if (data[minIndex] > data[i]) minIndex = i;
			}

			data[maxIndex]--;
			data[minIndex]++;

			dumpCount--;
		}

		maxIndex = minIndex = 0;

		for (int i = 1; i < 100; i++)
		{
			if (data[maxIndex] < data[i]) maxIndex = i;
			if (data[minIndex] > data[i]) minIndex = i;
		}

		return data[maxIndex] - data[minIndex];
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc = 1; tc <= 10; tc++) {
            
            dumpCount = sc.nextInt();
            
    		for (int i = 0; i < 100; i++)
    			data[i] = sc.nextInt();

            System.out.println("#" + tc + " " + solve());

        }
    }
}






//ver.2
//import java.util.Scanner;
//
//public class day1_1208_Flatten {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        int dumpCount, diff = 0, idx;
//    	int maxIdx, minIdx;
//    	
//    	for(int tc = 1; tc <= 10; tc++) {
//    		
//	    	int boxHeight[] = new int[101];
//	    	
//			dumpCount = sc.nextInt();
//			
//			for (int i = 1; i <= 100; i++)
//			{
//				idx = sc.nextInt();
//				boxHeight[idx]++;
//			}   
//			
//			for (maxIdx = 100; boxHeight[maxIdx] == 0; maxIdx--)
//				;
//			for (minIdx = 1; boxHeight[minIdx] == 0; minIdx++)
//				;
//		
//			for (int i = 0; i <= dumpCount; i++)
//			{
//				diff = maxIdx - minIdx;
//				if (diff == 1 || diff == 0) break;
//
//				boxHeight[maxIdx] --; boxHeight[maxIdx - 1] ++;
//				boxHeight[minIdx] --; boxHeight[minIdx + 1] ++;
//
//				if (boxHeight[maxIdx] == 0) maxIdx--;
//				if (boxHeight[minIdx] == 0) minIdx++;
//			}
//    	
//            System.out.println("#" + tc + " " + diff );
//
//        }
//    }
//}







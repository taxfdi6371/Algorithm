package com.ssafy.day19;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

//public class Solution {
public class 줄기세포배양5653 {
    //-2 초기 상태, -1 죽은 상태, 0 활성 상태, 그 이상 비활성 상태
	static final int INITSTATUS = -2;
	static final int DEAD = -1;
	static final int ACTIVE = 0;
	static final int INACTIVE = 1;
	
	static final int EMPTY = 0;
	
    static int N, M, K;    
    static int map[][];
    static int tempMap[][];
    static int status[][];
    static int activeHours[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    
	public static void oneHour(){       

        for(int i = 0; i < N + 2*K; i++){      
            for(int j = 0; j < M + 2*K; j++){
            	
                //세포가 아직 살아있고 활성상태일때
                if(status[i][j] == ACTIVE){   
                	activeHours[i][j]++;
                    
                    if(map[i][j] == activeHours[i][j])
                    	status[i][j] = DEAD;
                    
                    if(activeHours[i][j] == 1) {
                    
	                    for(int k = 0; k < 4; k++){                        
	                        int newx = i + dx[k];
	                        int newy = j + dy[k];
	
	                        if(map[newx][newy] == EMPTY){
	                            //생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지하게 된다.
	                            if(tempMap[newx][newy] < map[i][j]){  
	                            	tempMap[newx][newy] = map[i][j];
	                                status[newx][newy] = map[i][j];                              
	                            }
	                        }                        
	                    }
                    }
                }
                //세포가 아직 비활성 상태 일때 대기시간 1 줄인다
                else if(map[i][j] >= INACTIVE){
                	status[i][j]--;
                }
            }
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		long start = System.currentTimeMillis();
//		
//		System.setIn(new FileInputStream("줄기세포배양5653.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();      
            map = new int[N + 2*K][M + 2*K];
            tempMap = new int[N + 2*K][M + 2*K];
            status = new int[N + 2*K][M + 2*K];
            activeHours = new int[N + 2*K][M + 2*K];
             
            for(int i = 0; i < N + 2*K; i++){                
                Arrays.fill(status[i], INITSTATUS);
            }
             
            for(int i = 0; i < N; i++){                
                for(int j = 0; j < M; j++){
                    int stemCellInfo = sc.nextInt();                         
                    map[K + i][K + j] = stemCellInfo;
                    tempMap[K + i][K + j] = stemCellInfo;
                    
                    if(stemCellInfo == EMPTY)	continue;
                         
                    status[K + i][K + j] = stemCellInfo;
                }                
            }
            
            for(int i = 0; i < K; i++){
            	
                oneHour();
                
                for(int j = 0; j < N + 2*K; j++){                    
                    System.arraycopy(tempMap[j], 0, map[j], 0, tempMap[i].length);
                }
            }
             
            int ans = 0;
            for(int i = 0; i < N + 2*K; i++){
                for(int j = 0; j < M + 2*K; j++){                    
                    if(status[i][j] == ACTIVE || status[i][j] >= INACTIVE )  
                    	ans++;                 
                }    
            }

    		System.out.println("#" + tc + " " + ans);
	    }
//        System.out.println(( System.currentTimeMillis() - start )/1000.0 ); 
        sc.close();
	}
}

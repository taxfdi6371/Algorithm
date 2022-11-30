

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ4485 {
   static class Pos implements Comparable<Pos>{
      int y;
      int x;
      int v;
      
      public Pos(int y, int x, int v) {
         super();
         this.y = y;
         this.x = x;
         this.v = v;
      }

      @Override
      public int compareTo(Pos p) {
         int res = this.v - p.v;
         return res;
      }
   }
   
   static int N;
   static int[][] map;
   static int[][] distance;
   static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
   
   private static int dijkstra(){
      distance[0][0] = map[0][0];
      
      PriorityQueue<Pos> pq = new PriorityQueue<>();
      pq.add(new Pos(0, 0, map[0][0]));
      
      while(!pq.isEmpty()) {
         Pos p = pq.poll();
         for(int i=0; i<4; i++) {
            int dy = p.y + dir[i][0];
            int dx = p.x + dir[i][1];
            
            if(dy<0 || dx<0 || dy>N-1 || dx>N-1) continue;
            if(map[p.y][p.x] + map[dy][dx] < distance[dy][dx]) {
               distance[dy][dx] = distance[p.y][p.x] + map[dy][dx];
               pq.add(new Pos(dy, dx, distance[dy][dx]));
            }
         }
      }
      return distance[N-1][N-1];
   }   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int tc = 1;
      while(true) {
         N = Integer.parseInt(br.readLine());
         if(N == 0) break;
         
         map = new int[N][N];
         distance = new int[N][N];
         
         for(int i=0; i<N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
         }
         
         for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
               map[i][j] = Integer.parseInt(s[i]);
            }
         }
         
         sb.append("Problem "+ tc + ": "+ dijkstra());
         sb.append("\n");
         tc++;
      }
      System.out.println(sb.toString());
      br.close();
   }
   

}

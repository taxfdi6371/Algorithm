import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static char[][] map;
    public static final char LIM = 'Y';
    public static final char LEE = 'S';
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean[] visited;
    public static int total;
    public static int[] result;
    public static Queue<Integer> queue;

    public static void recur(int cur, int lim, int index) {
        if (lim > 3) {
            return;
        }

        if (cur == 7) {
            bfs();
            return;
        }
        for (int i = index; i < 25; i++) {
            if (visited[i]) continue;

            result[cur] = i;
            visited[i] = true;

            if (isLim(i)) {
                recur(cur + 1, lim + 1, i + 1);
            } else {
                recur(cur + 1, lim, i + 1);
            }

            visited[i] = false;
        }

    }

    public static boolean isLim(int num) {
        int x = num / 5;
        int y = num % 5;

        if (map[x][y] == LIM) {
            return true;
        }

        return false;
    }


    public static void bfs() {
        queue.clear();
        queue.add(result[0]);

        boolean[] visited2 = new boolean[7];
        visited2[0] = true;

        while (!queue.isEmpty()) {

            int num = queue.poll();

            int x = num / 5;
            int y = num % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;

                int result_num = 5 * nx + ny;

                for (int j = 0; j < 7; j++) {
                    if (visited2[j]) continue;

                    if (result_num == result[j]) {
                        queue.add(result[j]);
                        visited2[j] = true;
                        break;
                    }
                }

            }

        }

        for (int i = 0; i < 7; i++) {
            if (!visited2[i]) return;
        }

        total++;
    }

    public static void main(String[] args) throws Exception {
    	// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            map[i][0] = str.charAt(0);
            map[i][1] = str.charAt(1);
            map[i][2] = str.charAt(2);
            map[i][3] = str.charAt(3);
            map[i][4] = str.charAt(4);
        }

        total = 0;
        visited = new boolean[25];
        result = new int[7];
        queue = new LinkedList<>();
        
        recur(0, 0, 0);

        System.out.println(total);
        br.close();
    }
}
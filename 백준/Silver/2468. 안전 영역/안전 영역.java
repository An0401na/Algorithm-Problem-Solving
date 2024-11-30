import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int board[][];
    static int max = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;
    static int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static Queue<int[]> q;
    static  boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        for (int i = 0; i < max; i++) {
            result = Math.max(result,  countSafeZone(i));
        }

        System.out.println(result);
    }

    public static int countSafeZone(int h){
        q = new LinkedList<>();

        visited = new boolean[N][N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] - h > 0 && !visited[i][j]){
                    count++;
                    bfs(i, j, h);
                }
            }
        }
        return count;
    }

    public static void bfs(int i, int j, int h){
        q.add(new int[] {i,j});
        visited[i][j] = true;


        while (!q.isEmpty()){
            int p[] = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p[0] + dir[d][0];
                int nc = p[1] + dir[d][1];
                if(!isInRange(nr, nc) || visited[nr][nc]) continue;
                if(board[nr][nc] - h <=  0) continue;
                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    public static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N ;
    }
}
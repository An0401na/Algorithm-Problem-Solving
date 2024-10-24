import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int dir [][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static char board[][];
    static boolean visited[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited = new boolean['Z'-'A'+1];
        visited[board[0][0]-'A'] = true;
        dfs(0,0,1);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int cnt){
        max = Math.max(max, cnt);
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(isInRange(nr, nc) && !visited[board[nr][nc] - 'A']){
                visited[board[nr][nc] - 'A'] = true;
                dfs(nr, nc, cnt+1);
                visited[board[nr][nc] - 'A'] = false;
            }
        }
    }

    private static boolean isInRange(int r, int c){
        return 0 <= r && 0 <= c && r < R && c < C ;
    }
}
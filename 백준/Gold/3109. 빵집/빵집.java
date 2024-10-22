import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int dir[][] = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean[][] visited;
    static boolean isConnected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            isConnected = false;
            dfs(i, 0);
            if(isConnected) cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(int r, int c) {
        if(isConnected) return;
        if(c == C-1){
            isConnected = true;
            return;
        }

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(isInRange(nr, nc) && !isConnected){
                if(map[nr][nc]=='.' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    map[nr][nc] ='o';
                    dfs(nr, nc);
                    if(isConnected) continue;
                    map[nr][nc] ='.';
                }
            }
        }

    }
    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void showMap(boolean[][] map){
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
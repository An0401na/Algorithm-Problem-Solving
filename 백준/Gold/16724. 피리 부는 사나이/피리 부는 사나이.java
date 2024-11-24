import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char map[][];
    static int dir[][] = {{-1, 0}, {1,0}, {0, -1}, {0, 1}}; // U, D, L , R
    static int visited[][];
    static int idx = 1;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] != 0) continue;
                dfs(i, j);
            }
        }

        System.out.println(cnt);
    }
    public static void dfs(int r, int c){
        int d = -1;
        switch(map[r][c]){
            case 'U':
                d = 0;
                break;
            case 'D':
                d = 1;
                break;
            case 'L':
                d = 2;
                break;
            case 'R':
                d = 3;
                break;
        }
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];

        if(visited[nr][nc] == 0){
            visited[r][c] = idx;
            dfs(nr, nc);
        }else {
            if(visited[nr][nc] == idx){
                cnt ++;
            }
            idx++;
        }


    }
}
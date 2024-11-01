import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int map[][];
    static class Point {

        int isBroken;
        int r;
        int c;
        int len;

        public Point( int isBroken, int r, int c, int len){
            this.isBroken = isBroken;
            this.r = r;
            this.c = c;
            this.len = len;
        }

    }
    static int dir[][] = {{0,1}, {0, -1},{1, 0},{-1, 0}};
    static int result = -1;
    static final int NOTBROKEN = 0;
    static final int BROKEN = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i+1][j+1] = str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(result);
    }
    public static void bfs(){

        boolean visited[][][] = new boolean[2][N+1][M+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(NOTBROKEN, 1, 1, 1));
        visited[0][1][1] = true;

        while (!q.isEmpty()){
            Point now = q.poll();
            if(now.r == N && now.c == M){
                result = now.len;
                return;
            }
//            if(visited[now.isBroken][now.r][now.c]) continue;
//            visited[now.isBroken][now.r][now.c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dir[d][0];
                int nc = now.c + dir[d][1];
                if(!isInRange(nr, nc)) continue;

                if(map[nr][nc] == 1){ // 벽을 만났을때
                    if(now.isBroken == NOTBROKEN){
                        visited[BROKEN][nr][nc] = true;
                        q.add(new Point(BROKEN, nr, nc, now.len+1));
                    }
                    continue;
                }
                if(visited[now.isBroken][nr][nc])continue;
                visited[now.isBroken][nr][nc] = true;
                q.add(new Point(now.isBroken, nr, nc, now.len+1));
            }
        }
    }

    public static boolean isInRange(int r, int c){
        return 1 <= r && 1 <= c && r <= N && c <= M;
    }
}
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
    static int dir[][] = {{1, 0}, {-1, 0}, {0, 1},{0,-1}};
    static class Point implements Comparable<Point>{
        int r;
        int c;
        int dist;
        public Point(int r, int c, int dist){
            this.r = r ;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
    static final int WATER = -1;
    static final int LAND = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W'){
                    map[i][j] = WATER;
                }
            }
        }


        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == LAND){
                    max = Math.max(max, bfs(i,j));
                }
            }
        }


//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        System.out.println(max);
    }
    public static int bfs(int r, int c){

        boolean visited[][] = new boolean[N][M];
        int dist[][] = new int[N][M];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 0));
        visited[r][c] = true;
        Point now = null;
        while (!q.isEmpty()){
            now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dir[d][0];
                int nc = now.c + dir[d][1];
                if(!isInRange(nr, nc) || map[nr][nc] == WATER) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dist[nr][nc] = dist[now.r][now.c] + 1;
                q.add(new Point(nr, nc, 0));
            }
        }
        return dist[now.r][now.c];
    }

    public static boolean isInRange(int r, int c){
        return 0 <= r && 0 <= c && r < N && c < M;
    }

}
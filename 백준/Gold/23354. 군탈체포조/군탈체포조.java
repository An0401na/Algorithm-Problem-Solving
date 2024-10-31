import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    static class Point implements Comparable<Point>{
        int r;
        int c;
        int cost;
        int[][] dist;

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cost=" + cost +
                    ", dist=" + Arrays.toString(dist) +
                    '}';
        }

        public Point(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }

        public void setDist(int[][] dist) {
            this.dist = dist;
        }
    }
    static ArrayList<Point> talyoung;
    static int dir[][] = {{-1,0}, {0,1},{1,0},{0,-1}};
    static Point home;

    static boolean selected[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        talyoung = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    home = new Point(i,j,0);
                }
                if(map[i][j] == 0){
                    talyoung.add(new Point(i, j, 0));
                }
            }
        }
        if(talyoung.size() == 0){
            System.out.println(0);
            return;
        }

        for (Point p : talyoung){
            p.setDist(dijkstra(p));
            home.setDist(dijkstra(home));
        }

        selected = new boolean[N];
        dfs(0,0, home);

        System.out.println(min);
    }
    private static void dfs(int depth, int sum,  Point before){
        if(depth == talyoung.size()){
            min = Math.min(min, sum + before.dist[home.r][home.c]);
            return;
        }


        for (int i = 0; i < talyoung.size(); i++) {
            if(selected[i]) continue;
            selected[i] = true;
            Point p = talyoung.get(i);
            dfs(depth + 1, sum + before.dist[p.r][p.c], p);
            selected[i] = false;
        }
    }

    private static int[][] dijkstra(Point start) {
        boolean visited[][] = new boolean[N][N];
        int dist[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
        }
        dist[start.r][start.c] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(start);
        while (!pq.isEmpty()){
            Point now = pq.poll();
            if(visited[now.r][now.c]) continue;
            visited[now.r][now.c] = true;
//            if(dist[now.r][now.c] != now.cost) continue;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dir[d][0];
                int nc = now.c + dir[d][1];
                if(!isInRange(nr, nc)) continue;
                Point next = new Point(nr, nc, map[nr][nc] == -1 ? 0 : map[nr][nc]);
                if(dist[next.r][next.c] > dist[now.r][now.c] + next.cost) {
                    dist[next.r][next.c] = dist[now.r][now.c] + next.cost;
                    pq.add(new Point(next.r, next.c, dist[next.r][next.c]));
                }
            }
        }

        return dist;
    }

    public static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
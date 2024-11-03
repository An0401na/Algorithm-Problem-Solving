import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int T;
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;
        boolean visited;

        public Point(int x, int y, int cnt, boolean visited) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.visited = visited;
        }

        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", visited=" + visited +
                    '}';
        }
    }

    static ArrayList<Point>[] graph ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new ArrayList[T+1];

        for (int i = 0; i < T+1; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[y].add(new Point(x, y, Integer.MAX_VALUE, false));
        }


        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0, true));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            for (int y = now.y-2; y <= now.y+2; y++) {
                if ( y < 0 || y > T ) continue;

//            System.out.println("now : " +now.toString());
//            for (int y = 0; y < T+1; y++) {
                for (int i = 0; i < graph[y].size(); i++) {
                    Point next = graph[y].get(i);
                    if(!isInRang(now, next)) continue;
                    if(next.cnt > now.cnt+1) {
                        next.cnt = now.cnt + 1;
                        pq.add(next);
//                        System.out.println("   next : " + next.toString());
                    }
                }
            }
        }
//
//        for (int y = 0; y < T+1; y++) {
//            for (int i = 0; i < graph[y].size(); i++) {
//                Point next = graph[y].get(i);
//                System.out.println(next.toString());
//            }
//        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph[T].size(); i++) {
            min = Math.min(min, graph[T].get(i).cnt);
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);


    }

    private static boolean isInRang(Point now, Point next) {
        return Math.abs(next.x - now.x) <= 2 &&  Math.abs(next.y - now.y) <= 2;
    }

}
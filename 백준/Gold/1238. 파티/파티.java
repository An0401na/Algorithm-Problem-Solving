import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static class Point implements Comparable<Point>{
        int v;
        int cost;

        public Point(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Point o){
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Point{" +
                    " v=" + v +
                    ", cost=" + cost +
                    '}';
        }
    }

    static ArrayList<Point>[] graph;
    static ArrayList<Point>[] reverseGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v  = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Point(w, cost));
            reverseGraph[w].add(new Point(v, cost));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        PriorityQueue<Point> reversePq = new PriorityQueue<>();
        pq.add(new Point(X, 0));
        reversePq.add(new Point(X, 0));


        int dist[] = new int [N+1];
        int reverseDist[] = new int [N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverseDist, Integer.MAX_VALUE);

        dist[X] = 0;
        reverseDist[X] = 0;
        while (!pq.isEmpty() || !reversePq.isEmpty()){
            if(!pq.isEmpty()){
                Point now = pq.poll();
                for (int i = 0; i < graph[now.v].size(); i++) {
                    Point next = graph[now.v].get(i);
                    if(dist[next.v] > dist[now.v] + next.cost){
                        dist[next.v] = dist[now.v] + next.cost;
                        pq.add(new Point(next.v, dist[next.v]));
                    }
                }
            }

            if(!reversePq.isEmpty()){
                Point now = reversePq.poll();
                for (int i = 0; i < reverseGraph[now.v].size(); i++) {
                    Point next = reverseGraph[now.v].get(i);
                    if(reverseDist[next.v] > reverseDist[now.v] + next.cost){
                        reverseDist[next.v] = reverseDist[now.v] + next.cost;
                        reversePq.add(new Point(next.v, dist[next.v]));
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
//        System.out.println(Arrays.toString(reverseDist));

        int sum[] = new int[N+1];
        int max = 0;
        for (int i = 0; i < N+1; i++) {
            sum[i] = dist[i] + reverseDist[i];
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;

    static class Node implements Comparable<Node>{
        int v;
        int len;
        public Node(int v, int len){
            this.v = v;
            this.len =len;
        }

        public int compareTo(Node o){
            return this.len - o.len;
        }
    }

    static ArrayList<Node>[] graph;
    static int v1;
    static int v2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, len));
            graph[w].add(new Node(v, len));
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());



        int min = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        min = Math.min(min, dijkstra(1, v2)+ dijkstra(v2, v1)+ dijkstra(v1, N));

        System.out.println(min);

    }

    private static int dijkstra(int start, int end) {
        boolean visited[] = new boolean[N+1];
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;
            if(dist[now.v] != now.len) continue;
            for (Node next : graph[now.v]){
                if(dist[next.v] > dist[now.v] + next.len){
                    dist[next.v] = dist[now.v] + next.len;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        if(dist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        }
        return dist[end];
    }
}
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
    static int[] distV1;
    static int[] distV2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
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

        if (E == 0) {
            System.out.println(-1);
            return;
        }

        distV1 = dijkstra(v1);
        distV2 = dijkstra(v2);

        if (distV1[1] == Integer.MAX_VALUE || distV1[v2] == Integer.MAX_VALUE || distV2[N] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        int min = distV1[1] + distV1[v2] + distV2[N];
        min = Math.min(min,distV2[1] + distV2[v1] + distV1[N]);
        

        System.out.println(min);

    }

    private static int[] dijkstra(int start) {
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.v] != now.len) continue;
            for (Node next : graph[now.v]){
                if(dist[next.v] > dist[now.v] + next.len){
                    dist[next.v] = dist[now.v] + next.len;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        
        return dist;
    }
}
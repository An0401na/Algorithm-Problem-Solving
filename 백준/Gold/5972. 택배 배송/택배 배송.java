import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(w, cost));
            graph[w].add(new Node(v, cost));
        }

        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq= new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            
            for (Node next : graph[now.v]){
                if(dist[next.v] > dist[now.v] + next.cost){
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(dist[N]);



    }
}
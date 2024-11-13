import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Edge>[] graph;
    static class Edge implements Comparable<Edge> {
        int v;
        int w;
        int weight;

        public Edge(int v, int w,  int weight){
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return o.weight - this.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", w=" + w +
                    ", weight=" + weight +
                    '}';
        }
    }
    static int v1;
    static int v2;
    static int parent[];
    static int rank[];
    static boolean visited[];
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, c));
        }


        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        rank = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.v) == find(edge.w)) continue;
            union(edge.v, edge.w);
            // 맥스
            graph[edge.v].add(new Edge(edge.v, edge.w, edge.weight));
            graph[edge.w].add(new Edge(edge.w, edge.v, edge.weight));
        }


        dfs(v1, 0, Integer.MAX_VALUE);
        System.out.println(result);

    }
    public static void dfs(int cur, int prev, int min){
        if(cur == v2){
            result = min;
            return;
        }

        for (Edge edge : graph[cur]){
            if(edge.w == prev) continue;
            dfs(edge.w, cur, Math.min(edge.weight, min));
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);


        if(rank[a] < rank[b]){
            parent[a] = b;
        }else if(rank[a] < rank[b]){
            parent[b] = a;
        }else{
            parent[b] = a;
            rank[a] += 1;
        }
    }
}
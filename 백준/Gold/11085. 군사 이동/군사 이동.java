import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int p; // 지점
    static int w; // 길
    static int c; // 백준 수도
    static int v; // 큐브 수도
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int width;
        public Edge(int a, int b, int width){
            this.a = a;
            this.b = b;
            this.width = width;
        }

        public int compareTo(Edge o){
            return o.width-this.width ;
        }

    }
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        parent = new int[p];
        for (int i = 0; i < p; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, width));
        }

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if (find(edge.a) == find(edge.b)) continue;
            union(edge.a, edge.b);
            if(find(c) == find(v)){
                System.out.println(edge.width);
                return;
            }
        }

    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        parent[a] = b;
    }
}
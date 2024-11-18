import com.sun.javafx.geom.Edge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int []parent;
    static int rank[];
    static ArrayList<Edge> graph = new ArrayList<>();
    static class Edge{
        int a;
        int b;
        public Edge(int a, int b){
            this.a = a;
            this.b = b;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        rank = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b));
        }

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int cnt = 1;
        for (Edge edge : graph){
            if(find(edge.a) == find(edge.b)){
                System.out.println(cnt);
                System.exit(0);
            }
            union(edge.a, edge.b);
            cnt++;
        }

        System.out.println(0);
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(rank[a] < rank[b]){
            parent[a] = b;
        }else if(rank[a] > rank[b]){
            parent[b] = a;
        }else{
            parent[b] = a;
            rank[a] += 1;
        }
    }

}
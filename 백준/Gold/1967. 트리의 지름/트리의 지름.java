import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class Edge{
        int child;
        int cost;
        public Edge(int child, int cost){
            this.child = child;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "child=" + child +
                    ", cost=" + cost +
                    '}';
        }
    }
    static ArrayList<Edge>[] tree;
    static  Edge farLeaf = new Edge(0, 0);
    static int maxCost = 0;
    static boolean visitd[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[parent].add(new Edge(child, cost));
            tree[child].add(new Edge(parent, cost));
        }

        visitd = new boolean[N+1];
        visitd[1] = true;
        dfs(1, 0);
//        System.out.println(farLeaf.toString());

        int start = farLeaf.child;
        visitd = new boolean[N+1];
        visitd[start] = true;
        farLeaf = new Edge(start, 0);
        dfs(start, 0);

        System.out.println(farLeaf.cost);

//        dfs(1, 0, 0);
//        visitd = new boolean[N+1];
//        visitd[farLeaf.child] = true;
//         getMaxCost(farLeaf.child, 0);

//        System.out.println(farLeaf.toString());
//        System.out.println(maxCost);

    }

    public static void dfs(int cur, int cost){
        if(farLeaf.cost < cost){
            farLeaf = new Edge(cur, cost);
        }
        if(cur > N) return;

        for (Edge n : tree[cur]){
            if(visitd[n.child]) continue;
            visitd[n.child] = true;
            dfs(n.child, cost + n.cost);
        }
    }

//    public static void dfs(int cur, int prev, int cost){
//        if(farLeaf.cost < cost){
//            farLeaf = new Edge(cur, cost);
//        }
//        if(cur > N) return;
//
//        for (Edge n : tree[cur]){
//            if(n.child == prev) continue;
//            dfs(n.child, cur, cost + n.cost);
//        }
//    }

//    public static void getMaxCost(int cur, int cost){
//        maxCost = Math.max(maxCost, cost);
//
//        for (Edge n : tree[cur]){
//            if(visitd[n.child]) continue;
//            visitd[n.child] = true;
//            getMaxCost(n.child, cost+n.cost);
//        }
//    }

}
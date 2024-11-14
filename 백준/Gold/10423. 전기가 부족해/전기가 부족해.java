import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static class Edge implements Comparable<Edge>{
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost){
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return this.cost - o.cost;
        }

        public String toString(){
            return "v : " + v +", w : "+ w +", cost : " + cost;
        }

    }
    static int parents[];
    static int rank[];
    static boolean isSuppied[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int min = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        parents = new int[N+1];
        rank = new int[N+1];
        isSuppied = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            parents[i] = i;
        }

        String str[] = br.readLine().split(" ");
        for (String s : str){
            isSuppied[Integer.parseInt(s)] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(v, w, cost));
        }

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.v) == find(edge.w)) continue;
            union(edge);
        }

//        System.out.println(Arrays.toString(isSuppied));
        System.out.println(min);

    }
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(Edge edge){

        int a = find(edge.v);
        int b = find(edge.w);

//        System.out.println((char)('A'+edge.v-1) +"("+(char)('A'+a-1)+")"+"발전소에 연결되어 있는가? "+isSuppied[a]);
//        System.out.println((char)('A'+edge.w-1) +"("+(char)('A'+b-1)+")"+"발전소에 연결되어 있는가? "+isSuppied[b]);
        if(isSuppied[a] && isSuppied[b]) return;


        if(isSuppied[b]){
            parents[a] = b;
        }else if(isSuppied[a]){
            parents[b] = a;
        }else{
            parents[a] = b;
        }

        min += edge.cost;
//        System.out.println(edge.toString());
//        System.out.println((char)('A'+a-1)+"의 부모 : " +(char)('A'+parents[a]-1) + ", "+(char)('A'+b-1)+"의 부모 : " +(char)('A'+parents[b]-1));
//        System.out.println(min);

    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int Q;
    private static class Log implements Comparable<Log>{
        int n;
        int x1;
        int x2;
        int y;

        public Log(int n, int x1, int x2, int y){
            this.n = n;
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        public int compareTo(Log o){
            if(this.x2 == o.x2) return o.x1 - this.x1;
            return o.x2 - this.x2;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "n=" + n +
                    ", x1=" + x1 +
                    ", x2=" + x2 +
                    ", y=" + y +
                    '}';
        }
    }
    static PriorityQueue<Log> pq = new PriorityQueue<>();
    static int parents[];
    static int rank[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            parents[i] = i;
            pq.add(new Log(i, a, b, c));
        }

        Log prev = pq.poll();
        Log cur = null;
        while (!pq.isEmpty()){
            cur = pq.poll();
            if(find(prev.n) == find(cur.n)) continue;
            union(prev, cur);
            prev = cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(parents[s] == parents[e]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());

    }
    private static void union(Log prev, Log cur){
//        System.out.println("prev : " + prev);
//        System.out.println("cur : " + cur);
        if(cur.x2 < prev.x1)  return;



        int a = find(prev.n);
        int b = find(cur.n);

        if(rank[a] < rank[b]){
            parents[a] = b;
        }else if(rank[a] > rank[b]){
            parents[b] = a;
        }else{
            parents[a] = b;
            rank[b] += 1;
        }

//        System.out.println("prev.n 부모 : "+ parents[prev.n]);
//        System.out.println("cur.n 부모 : "+ parents[cur.n]);
    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
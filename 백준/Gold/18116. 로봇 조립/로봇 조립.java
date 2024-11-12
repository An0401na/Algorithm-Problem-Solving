import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int parent[];
    static int rank[];
    static int size[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[1_000_001];
        rank = new int[1_000_001];
        size = new int[1_000_001];

        for (int i = 0; i < 1_000_001; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();
            if (instruction.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            if (instruction.equals("Q")){
                int c = Integer.parseInt(st.nextToken());
                sb.append(size[find(c)]).append('\n');
            }

        }
        System.out.println(sb.toString());


    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;

        if(rank[a] > rank[b]){
            parent[b] = a;
            size[a] += size[b];
        }else if(rank[a] < rank[b]){
            parent[a] = b;
            size[b] += size[a];
        }else{
            parent[b] = a;
            rank[a]+=1;
            size[a] += size[b];
        }
    }
}
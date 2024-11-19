import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int []parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N-2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = i+1; j < N+1; j++) {
                if(find(i) == find(j)) continue;
                System.out.println(i+" "+j);
                System.exit(0);
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
        parent[b] = a;

    }

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        parents = new int[n+1]; // i번의 직속상사는 parent[i] 번
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }


        value = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            value[c] += v;
        }


        tree = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }


        int root = -1;
        for (int i = 1; i < n+1; i++) {
            if(parents[i] == -1){
                root = i;
                continue;
            }
            tree[parents[i]].add(i);
        }

        dfs(root);

        for (int i = 1; i < n+1; i++) {
            System.out.print(value[i] +" ");
        }
    }
    public static void dfs(int cur){
//        if(cur > n) return;

        for (int next : tree[cur]){
            value[next] += value[cur];
            dfs(next);
        }
    }

}
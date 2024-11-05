import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v].add(w);
            graph[w].add(v);
        }

        parents = new int[N+1];

        dfs(1, 0);



        for (int i = 2; i < N+1; i++) {
            System.out.println(parents[i]);
        }
    }

    static public void dfs(int cur, int prev){
        if(cur > N) return;

        for (int v : graph[cur]){
            if(v == prev) continue;
            parents[v] = cur;
            dfs(v, cur);
        }
    }
}
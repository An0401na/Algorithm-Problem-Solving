import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 친구수
    static int M; // 친구 관계 수
    static int k; // 가지고 있는 돈
    static int cost[];
    static ArrayList<Integer>[] friend ;
    static int min;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friend = new ArrayList[N];
        cost = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            friend [i] = new ArrayList();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken())-1;
            friend[v].add(w);
            friend[w].add(v);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            min = Integer.MAX_VALUE;
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
            sum += min;
            if(sum > k) {
                System.out.println("Oh no");
                System.exit(0);
            }
        }

        System.out.println(sum);
    }

    private static void dfs(int node){
        min = Math.min(min, cost[node]);

        for (int i = 0; i < friend[node].size(); i++) {
            int next = friend[node].get(i);
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next);
//            visited[next] = false;
        }

    }
}
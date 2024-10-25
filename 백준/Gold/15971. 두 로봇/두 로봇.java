import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int robot1;
    static int robot2;
    static ArrayList<Node>[] graph ;
    static int result;
    static class Node{
        int v;
        int len;
        public  Node(int v, int len){
            this.v = v;
            this.len = len;
        }

    }
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        robot1 = Integer.parseInt(st.nextToken());
        robot2 = Integer.parseInt(st.nextToken());

        if(N <= 2 || robot1 == robot2) {
            System.out.println(0);
            return;
        }


        graph = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, length));
            graph[n2].add(new Node(n1, length));

        }


        visited = new boolean[N+1];
        visited[robot1] = true;
        dfs(robot1, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int r, int sum, int maxLen){
        if(r == robot2){
            result = sum - maxLen;
            return;
        }

        for (Node n : graph[r]){
            if(visited[n.v]) continue;
            visited[n.v] = true;
            dfs(n.v, sum+ n.len, Math.max(maxLen, n.len));
        }
    }
}
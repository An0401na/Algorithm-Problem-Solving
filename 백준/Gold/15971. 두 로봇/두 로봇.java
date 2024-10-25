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
    static int min = Integer.MAX_VALUE;
    static boolean visited1[];
    static boolean visited2[];
    static  int sum = 0;
    static class Node{
        int v;
        int len;
        public  Node(int v, int len){
            this.v = v;
            this.len = len;
        }

    }
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


        visited2 = new boolean[N+1];
        visited2[robot2] = true;

        visited1 = new boolean[N+1];
        visited1[robot1] = true;
        dfs2(robot1, robot2);
        dfs1(robot1);

        System.out.println(min);
    }

    private static void dfs1(int r1){
        if(sum>= min) return;
        for (Node node  : graph[r1]){
            int n = node.v;
            if(visited1[n]) continue;
//            if(n == robot2) continue;
            visited1[n] = true;
            sum += node.len;
            dfs2(n, robot2);
            dfs1(n);
            sum -= node.len;
            visited1[n] = false;
        }
    }


    private static void dfs2(int r1, int r2){
        if(sum >= min) return;
        for(Node node : graph[r1]){
            int n = node.v;
            if(n == r2){
                min = Math.min(min, sum);
                return;
            }
        }

        for (Node node : graph[r2]){
            int n = node.v;
            if(visited2[n]) continue;
//            if(n == r1) continue;
            visited2[n] = true;
            sum += node.len;
            dfs2(r1, n);
            sum -= node.len;
            visited2[n] = false;
        }
    }
}
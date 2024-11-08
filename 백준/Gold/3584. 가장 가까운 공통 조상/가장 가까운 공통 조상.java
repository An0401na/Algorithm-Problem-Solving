import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static ArrayList<Integer> []tree;
    static Stack<Integer>[] parents;

    static int commonParent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            tree = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < N-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child].add(parent);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            parents = new Stack[2];
            for (int i = 0; i < 2; i++) {
                parents[i] = new Stack<>();
                int nodeNum = Integer.parseInt(st.nextToken());
                parents[i].push(nodeNum);
                dfs(i, nodeNum);
            }


            int commonParent = 0;
            while (!parents[0].isEmpty() && !parents[1].isEmpty()){
                int n1 = parents[0].pop();
                int n2 = parents[1].pop();
                if(n1 != n2) break;
                commonParent = n1;
            }

            System.out.println(commonParent);
        }
    }

    private static void dfs(int i, int cur) {
        for (int next : tree[cur]){
            parents[i].add(next);
            dfs(i, next);
        }
    }

}
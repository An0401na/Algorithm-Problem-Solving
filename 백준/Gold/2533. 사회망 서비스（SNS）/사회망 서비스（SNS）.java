import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean isEarlyAdopter[];
    static boolean visited[];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[v].add(w);
            tree[w].add(v);
        }

        isEarlyAdopter = new boolean[N+1];
        visited = new boolean[N+1];


        dfs(1, 0);

//        System.out.println(Arrays.toString(isEarlyAdopter));
        System.out.println(min);

    }

    public static void dfs(int cur, int prev){
//        System.out.println("cur : " + cur );
        if(isEarlyAdopter[cur]) return;
        if(tree[cur].size() == 0) return; // 단말노드인 경우 리턴


        for (int next : tree[cur]){
            if(next == prev) continue;
            dfs(next, cur);
            if(isEarlyAdopter[next]) continue;
            if(!isEarlyAdopter[cur]){
                isEarlyAdopter[cur] = true;
                min++;
//                System.out.println("cur : " + cur +": next : " + next +", min : " + min);
            }
        }
//        isEarlyAdopter[cur]=true;
    }

}
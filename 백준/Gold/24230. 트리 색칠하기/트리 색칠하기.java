import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int colors[];
    static ArrayList<Integer> tree[];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        colors = new int[N+1];
        tree = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<>();
            colors[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[v].add(w);
            tree[w].add(v);
        }

        if(colors[1] != 0) cnt++;
        dfs(1, 0, colors[1]);
        System.out.println(cnt);

    }
    public static void dfs(int cur, int prev, int color){
//        System.out.println("지금 보고 있는 색 : " +cur+ "번 -> "+ color);
        for (Integer next : tree[cur]){
            if(next == prev) continue;
            if(colors[next] != color){
//                System.out.println(" 다음 노드는 색 다름 : "+ next +"번 ->  "+ colors[next]);
                cnt ++;
                dfs(next, cur, colors[next]);
                continue;
            }
            dfs(next, cur, color);
        }
    }

}
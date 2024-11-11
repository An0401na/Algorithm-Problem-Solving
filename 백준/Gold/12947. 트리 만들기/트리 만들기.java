import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, answer;
    static List<int[]> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] cntValues = br.readLine().split(" ");

        int depth = 0;
        for (int i = 0; i < N; ++i) {
            int cnt = Integer.parseInt(cntValues[i]);

            if (cnt == 1) {
                if (depth > 0) {
                    tree.add(new int[]{depth, depth});
                    depth = 0;
                }
                tree.add(new int[]{1});
            } else {
                ++depth;

                if (i == N - 1) {
                    tree.add(new int[]{depth, depth});
                }
            }
        }
        
        solve();
        System.out.println(answer);
    }

    public static void solve() {
        for (int[] node : tree) {
            answer = Math.max(answer, N + (node.length == 1 ? 0 : node[0]));
            N -= node[0];
        }
    }

}
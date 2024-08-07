import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static int n, m;

    static int[] moveCnt, visit;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visit = new int[n + 1];
        moveCnt = new int[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        ArrayDeque<int[]> que = new ArrayDeque<>();;

        boolean flag = true;
        int[] cnt = new int[3];

        visit[1] = 1;
        cnt[2]++;
        que.add(new int[] {1, 1});

        while(!que.isEmpty()) {

            int[] cur = que.pollFirst();
            int loc = cur[0];
            int color = cur[1];

            for (int next : graph[loc]) {
                if (visit[next] == 0) {
                    visit[next] = -color;
                    cnt[visit[next] + 1]++;
                    que.add(new int[] {next, -color});
                } else if (visit[next] == color) {
                    flag = false;
                    break;
                }
            }

            if (!flag) break;
        }

        int result = 0;
        if (flag) result = 2 * cnt[0] * cnt[2];
        System.out.println(result);

    }
}
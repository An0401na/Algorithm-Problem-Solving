import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int E;
    static ArrayList<Integer> graph[];
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> result;
    static int num[];
    static boolean finished[];
    static int id = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        result = new ArrayList<>();
        graph = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        num = new int[V+1];
        finished = new boolean[V+1];
        for (int i = 1; i < V+1; i++) {
            if(num[i] == 0 ) dfs(i);
        }

        for (ArrayList list : result){
            Collections.sort(list);
        }

        Collections.sort(result, (o1, o2) -> o1.get(0) - o2.get(0));
        System.out.println(result.size());
        for (ArrayList list : result){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) +" ");
            }
            System.out.print("-1");
            System.out.println();
        }
    }

    static public int dfs(int cur){
        num[cur] = ++id;
        stack.push(cur);

        int parent = num[cur];
        for (int next : graph[cur]){
            if(num[next] == 0) parent = Math.min(parent, dfs(next)); //한번도 방문하지 않은 노드
            else if(!finished[next]) parent = Math.min(parent, num[next]); // 방문은 했는데 스택에서 나오지 못한 노드, 즉 scc를 아직 이루지 못한 노드
        }

        if(parent == num[cur]){ // parent가 num[cur]과 동일한 경우는 이동할 노드가 없거나 혹은 dfs를 통해 노드들이 사이클을 돌아서 자신의 노드로 돌아온 경우
            ArrayList<Integer> scc = new ArrayList<>();

            while (true){
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                if(top == cur) break;
            }
            result.add(scc);
        }
        return parent;
    }
}
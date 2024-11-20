import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static int parent[];
    static boolean isDefended[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        isDefended = new boolean[N+1];

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }
        
        for (int a = 1; a <= N; a++) {
            int idx = 0;
            while (idx < graph[a].size()){
                int b = graph[a].get(idx);
                if(graph[b].contains(a)) {
                    idx++;
                    continue; //a -> b , b -> a 인 경우
                }
                isDefended[b] = true; // a -> b 이므로 b는 변호 받음 표시
                graph[a].remove(Integer.valueOf(b)); // 변호 받은 신뢰 관계는 더이상 확인할 필요가 없음으로 제거
            }
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }


        // 이제 양방향 신뢰 밖에 안남음 
        for (int a = 1; a <= N; a++) {
            int idx = 0;
            while (idx < graph[a].size()){// a -> b 가 있으면 b -> a 도 존재
                int b = graph[a].get(idx++);
                graph[b].remove(Integer.valueOf(a)); // b -> a 제거

                if(find(a) == find(b)){ //사이클
                    isDefended[find(a)] = true;
                }else{
                    if(isDefended[find(b)]) union(b, a); // b가 이미 변호를 받았다면 b -> a
                    else union(a, b);
                }

            }
        }


        for (int i = 1; i <= N; i++) {
//            if(isDefended[i]) continue;
//            if(isDefended[find(i)])continue;
//            System.out.println("NO");
//            return;
            if(!isDefended[find(i)]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        parent[b] = a; // b의 부모를 a로 연결 : a가 b를 변호
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean isKnowTruth[];
    static int parent[];
    static int party[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        isKnowTruth = new boolean[N+1];
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            isKnowTruth[idx] = true;
        }

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        party = new int[M][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int joinPartyCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < joinPartyCnt; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            if(joinPartyCnt == 1) continue;
            int first = party[i][0];
            for (int j = 1; j < joinPartyCnt; j++) {
                if(find(first) == find(party[i][j])) continue;
                union(first, party[i][j]);
//                if(isKnowTruth[party[i][j]]){
//                    isKnowTruth[find(party[i][j])] = true;
//                }
            }
        }
//        System.out.println(Arrays.toString(parent));
//        System.out.println(Arrays.toString(isKnowTruth));

        // 거짓말 할 수 있는 파티 골라내기
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int j = 0; j < N+1; j++) {
                if(party[i][j] == 0) continue;
                if(isKnowTruth[find(party[i][j])]){
                    canLie = false;
                    break;
                }
            }
            if(canLie) cnt++;
        }

        System.out.println(cnt);
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(isKnowTruth[a]){
            parent[b] = a;
            isKnowTruth[b] = true;
        }else if(isKnowTruth[b]){
            parent[a] = b;
            isKnowTruth[a] = true;
        }else{
            parent[a] = b;
        }

    }
}
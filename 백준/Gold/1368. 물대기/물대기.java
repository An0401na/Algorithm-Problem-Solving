import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class Connect implements Comparable<Connect>{
        int i;
        int j;
        int cost; // 두 논을 연결하는데 드는 비용

        public Connect(int i, int j, int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Connect{" +
                    "i=" + i +
                    ", j=" + j +
                    ", cost=" + cost +
                    '}';
        }

        public int compareTo(Connect o){
            return Integer.compare(this.cost, o.cost);
        }

    }
    static ArrayList<Connect> connects = new ArrayList<>();
    static int parent[];
    static boolean isDigged[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        isDigged = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            connects.add(new Connect(0, i, Integer.parseInt(br.readLine())));
            parent[i] = i;
        }

        int connectCost[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                connectCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                connects.add(new Connect(i , j, connectCost[i][j]));
            }
        }

        Collections.sort(connects);

        int sumCost = 0;
        for (Connect c : connects){
            if(find(c.i) == find(c.j)) continue;
            union(c.i, c.j);
            sumCost += c.cost;
        }

        System.out.println(sumCost);


    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        parent[a] = b;
    }
}
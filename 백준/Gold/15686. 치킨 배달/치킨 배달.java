import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 도시의 크기
    static int M; // 남겨야할 치킨집의 개수

    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static int min = Integer.MAX_VALUE;
    static int visited[];
    static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    home.add(new Point(i,j));
                }
                if(num == 2){
                    chicken.add(new Point(i,j));
                }
            }
        }


        visited = new int[M];
        selectChicken(0,  0);
        System.out.println(min);
    }

    private static void selectChicken(int depth, int start) {
        if(depth == M){
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                Point h = home.get(i);
                int mini = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    Point c = chicken.get(visited[j]);
                    mini = Math.min(mini, Math.abs(c.r - h.r)+Math.abs(c.c - h.c));
                }
                sum += mini;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[depth] = i;
            selectChicken(depth+1, i+1);
        }
    }
}
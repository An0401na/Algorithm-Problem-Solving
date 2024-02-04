import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int queens[];
//    static ArrayList<Queen> queens;
    static int cnt;
//    static class Queen{
//        int r;
//        int c;
//
//        @Override
//        public String toString() {
//            return "Queen{" +
//                    "r=" + r +
//                    ", c=" + c +
//                    '}';
//        }
//
//        public Queen(int r, int c) {
//            this.r = r;
//            this.c = c;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        queens = new ArrayList<>();
        queens = new int[N];
        nqueen(0, 0);
        System.out.println(cnt);

    }

    private static void nqueen(int depth, int r) {
        if (depth == N){
            cnt ++;
            return;
        }
        if(r >= N) return;
        for (int i = 0; i < N; i++) {
            if(check(r, i)){
                queens[r] = i;
                nqueen(depth+1, r + 1);
            }

        }

//        for (int i = r; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if(check(i, j)) {
//                    queens.add(new Queen(i, j));
//                    nqueen(depth + 1, i+1);
//                    queens.remove(queens.size()-1);
//                }
//            }
//        }
    }

    private static boolean check(int r, int c) {
        for (int i = 0; i < r; i++) {
            if(queens[i] == c || (Math.abs(i-r) == Math.abs(queens[i]-c))){
                return false;
            }
        }
        return true;
    }

//    private static boolean check(int r, int c) {
//        for (int i = 0; i < queens.size(); i++) {
//            Queen q = queens.get(i);
//            if(q.r == r || q.c == c || (Math.abs(q.r-r) == Math.abs(q.c-c))){
//                return false;
//            }
//        }
//        return true;
//    }

}
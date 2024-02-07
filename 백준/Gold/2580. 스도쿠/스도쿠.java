import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int board[][];
    static int num[];
    static class EmptyPoint {
        int r;
        int c;

        public EmptyPoint(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "emptyPoint{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static ArrayList<EmptyPoint> emptyPoints;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        num = new int[10];
        emptyPoints = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] ==0){
                    emptyPoints.add(new EmptyPoint(i,j));
                }else{
                    num[board[i][j]] ++;
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            num[i] = 9 - num[i];
        }


        getAnswer(0);

    }

    private static void getAnswer(int depth) {
        if(depth == emptyPoints.size()){
            print();
            System.exit(0);

            return;
        }


        EmptyPoint p = emptyPoints.get(depth);
//        if(depth != 0 ){
//            for (int i = emptyPoints.get(depth-1).r; i < p.r; i++) {
//                if(!checkRow(i)) {
//                    return;
//                }
//            }
//
//            if(p.r >= 3){
//                for (int i = 0; i < p.r; i+=3) {
//                    for (int j = 0; j < 9; j+=3) {
//                        if(!check3by3(i, j)){
//                            return;
//                        }
//                    }
//                }
//            }
//        }


        for (int i = 1; i < 10; i++) {
            if(num[i] == 0) continue;
            if(check(p.r, p.c , i)){
                num[i]--;
                board[p.r][p.c] = i;
                getAnswer(depth+1);
                num[i]++;
                board[p.r][p.c] = 0;
            }
        }

    }

    private static boolean check(int r, int c, int value) {
        if (!checkRow(r, value)) return false;


        if (!checkCol(c, value)) return false;


        if (!check3by3(r, c, value)) return false;


        return true;
    }

    private static boolean check3by3(int r, int c, int value) {
        r = 3 * (r/3);
        c = 3 * (c/3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[r+i][c+j] == value) return false;
            }

        }
        return true;
    }

    private static boolean checkCol(int c, int value) {
        for (int j = 0; j < 9; j++) {
            if(board[j][c] == value) return false;
        }
        return true;
    }

    private static boolean checkRow(int r, int value) {
        for (int j = 0; j < 9; j++) {
            if(board[r][j] == value) return false;
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j] +" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
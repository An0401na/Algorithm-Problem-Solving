import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char board[][];
    static String result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }


        result = "";
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if(board[i][j] == '#'){
                    result = compareString(result, sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(board[i][j]);
            }
            result = compareString(result, sb.toString());
        }

        for (int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < R; j++) {
                if(board[j][i] == '#'){
                    result = compareString(result, sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(board[j][i]);
            }
            result = compareString(result, sb.toString());
        }


//        String a = br.readLine();
//        String b = br.readLine();
//        result = compareString(a, b);



        System.out.println(result);

    }

    public static String compareString(String a, String b){
//        System.out.println("a : "+a + ", b : "+ b);

        if(a.length() <=1 && b.length() > 1) return b;
        if(b.length() <= 1 && a.length() > 1) return a;

        int i = 0;
        while (i < a.length() && i < b.length()){
//            System.out.println("  a : "+a.charAt(i) + ", b : "+ b.charAt(i));
            if(a.charAt(i) - b.charAt(i) < 0) return a;
            if(a.charAt(i) - b.charAt(i) > 0) return b;
            i++;
        }


        if(a.length() < b.length()) return a;
        return b;
    }
}

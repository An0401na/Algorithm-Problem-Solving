import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        getNumber(0);
    }

    private static void getNumber(int depth) {
        if(depth == N){
            System.out.println(result.toString());
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            result.append(i);
            if(isBestArray()){
                getNumber(depth+1);
            }
            result.deleteCharAt(result.length()-1);
        }
    }

    private static boolean isBestArray() {
        int cnt = (int) result.length()/2;
        for (int i = 1; i <= cnt; i++) {
            int rightStart = result.length() - i;
            int leftStart = rightStart - i;
//            System.out.printf("ri :" + rightStart +" , le "+ leftStart);
            if(isSame(leftStart, rightStart)){
                return false;
            }

        }
        return true;
    }

    private static boolean isSame(int leftStart, int rightStart) {
        String leftStr = result.substring(leftStart, rightStart);
        String rightStr = result.substring(rightStart);
        if(rightStr.equals(leftStr)){
            return true;
        }
        return false;
    }
}
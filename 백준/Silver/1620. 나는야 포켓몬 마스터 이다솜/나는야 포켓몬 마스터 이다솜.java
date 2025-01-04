import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static HashMap<String, String> pocketmon;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pocketmon = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String nameStr = br.readLine();
            pocketmon.put(String.valueOf(i), nameStr);
            pocketmon.put(nameStr, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String test = br.readLine();
            System.out.println(pocketmon.get(test));
        }
    }

}

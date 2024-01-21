import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String str;
    static int alphabet[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabet = new int[26];
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        int start = 0;
        int end = 0;
        int cnt = 1;
        alphabet[str.charAt(end)-'a'] ++;
        while(end < str.length()){
            if(cnt <= N){
                max = Math.max(max, end - start+1);
            }

            if(cnt <= N){
                end ++;
                if(end < str.length()) {
                    if (alphabet[str.charAt(end) - 'a'] == 0) {
                        cnt++;
                    }
                    alphabet[str.charAt(end) - 'a']++;
                }
            }else{
                alphabet[str.charAt(start)-'a'] --;
                if(alphabet[str.charAt(start)-'a'] == 0){
                    cnt--;
                }
                start++;
            }

        }

        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int card[];
    static int M;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int [N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int [M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        Arrays.sort(card);
        for (int i = 0; i < M; i++) {
            long start = 0;
            long end = N-1;
            boolean isExist = false;
            while (start <= end){
                int mid = (int)((start+ end) / 2);

                if(card[mid] == arr[i]){
                    isExist = true;
                    break;
                }

                if(card[mid] < arr[i]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            if(isExist){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }

        }
        System.out.println(sb.toString());

    }
}
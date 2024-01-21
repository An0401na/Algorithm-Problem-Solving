import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 배열의 요소 개수
    static int S;
    static int arr[]; // 입력 정수를 저장하는 배열
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K를 입력으로 받음
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 배열 요소를 입력으로 받음
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; // 현재 부분 배열의 시작 인덱스
        int end = 0;   // 현재 부분 배열의 끝 인덱스
        int sum = arr[end];

        while (end < N) {
//            System.out.println("start : "+ start+", end : " + end+", sum : "+ sum);
            if(sum >= S){
                min = Math.min(min, end - start+1);
            }

            if(sum < S){
                end ++;
                sum += arr[end];
            }else{
                sum -= arr[start];
                start++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int arr[];
    static int tmp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergesort(0 , N-1);
        System.out.println("-1");
    }
    public static void mergesort(int left , int right){
        if(left >= right) return;

        int mid = (left + right)/2;
        mergesort(left, mid);
        mergesort( mid+1, right);
        merge(left, mid, right);

    }

    public static void merge(int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int t = 0;

        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                tmp[t++] = arr[i++];
            }else{
                tmp[t++] = arr[j++];
            }
        }


        while(i <= mid){
            tmp[t++] = arr[i++];
        }

        while (j <= right){
            tmp[t++] = arr[j++];
        }

        i = left;
        t = 0;
        while(i <= right){
            arr[i++] = tmp[t++];
            if(--K == 0){
                System.out.println(arr[i-1]);
                System.exit(0);
            }
//            System.out.println(Arrays.toString(arr));

        }

    }
}
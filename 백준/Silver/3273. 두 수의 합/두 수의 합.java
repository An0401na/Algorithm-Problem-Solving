import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
//    static int arr[];
    static int sortedArr[];
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        sortedArr = new int[n];
        mergesort(arr, 0, n-1);

        
        int start = 0;
        int end = n-1;


        int cnt = 0;
        while (start < end) {
            if(arr[start]+arr[end] == x){
                cnt++;
                start++;
                end--;
                continue;
            }

            if(arr[start] + arr[end] < x){
                start++;
            }else{
                end --;
            }
        }
        System.out.println(cnt);

    }

    private static void mergesort(int arr[], int start, int end) {
        if(start == end ) return;

        int mid = (start+end)/2;

        mergesort(arr, start, mid);
        mergesort(arr, mid+1, end);

        merge(arr, start, mid, end);



    }

    private static void merge(int arr[], int start,int mid, int end) {

        int left = start; //왼쪽 부분리스트의 시작점
        int right = mid+1; //오른쪽 부분리스트의 시작점
        int idx = left; //채워 넣을 배열의 인덱스


        while (left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                sortedArr[idx] = arr[left];
                idx ++;
                left++;
            }else{
                sortedArr[idx] = arr[right];
                idx++;
                right++;
            }
        }

        if(left <= mid){
            while (left <= mid){
                sortedArr[idx] = arr[left];
                idx++;
                left++;
            }
        }else{
            while (right <= end){
                sortedArr[idx] = arr[right];
                idx++;
                right++;
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = sortedArr[i];
        }

    }
}
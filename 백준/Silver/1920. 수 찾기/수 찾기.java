import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		int[] nums = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <  m; i++) {
			nums[i] = Integer.parseInt(st.nextToken());	
		}

		
		for (int i = 0; i < nums.length; i++) {
			BinarySearch(nums[i], A, 0, A.length-1);
		}
		System.out.print(sb);
		
	}
	static void BinarySearch(int n, int[] arr, int start, int end) {
		if(start > end) {
			sb.append('0').append('\n');
			return;
		}
		
		int mid = (start+end)/2;		
		
		if(arr[mid] == n) {
			sb.append('1').append('\n');
			return;
		}else if(n < arr[mid]) {
			BinarySearch(n, arr, start, mid-1);
		}else if(arr[mid] < n) {
			BinarySearch(n, arr, mid+1, end);
		}
		
		
	}
}
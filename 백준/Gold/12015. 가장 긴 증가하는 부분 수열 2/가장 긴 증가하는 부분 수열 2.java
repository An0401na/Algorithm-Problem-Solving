import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 최장 증가 부분 수열 - 이분탐색
	static int N;
	static int arr[];
	static int lis[];
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		lis = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		for (int i = 0; i < N; i++) {
			//Arrays.binarySearch(배열, 시작점, 끝점, 찾는 값)
			int idx = Arrays.binarySearch(lis, 0, max, arr[i]);
			if (idx < 0) {
				if (lis[Math.abs(idx) - 1] == 0) {
					max++;
				}
				lis[Math.abs(idx) - 1] = arr[i];
			} else {
				lis[idx] = arr[i];
			}
		}
		System.out.println(max);

	}

}
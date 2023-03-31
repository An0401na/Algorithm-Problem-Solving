import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//최장 증가 수열의 길이
	/*
	 * 정렬되지 않은 수열의 모든 부분집합(PowerSet)인지 판별하고 증가 수열 중 가장 길이가 긴 값을 구한다.
	 * 이때 부분 수열의 길이가 긴 것 부터 보는게 유리
	 * 
	 * 시간 복잡도 N^2
	 */
	static int N;
	static int arr[];
	static int LIS[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 arr = new int[N];
		 LIS = new int[N];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr [i] = Integer.parseInt(st.nextToken());
		}
		
		int max =0;
		init();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
			if(max < LIS[i]) {
				max = LIS[i];
			}
		}
		System.out.println(max);
	}

	static void init() {
		for (int i = 0; i < LIS.length; i++) {
			LIS[i]=1;
			
		}
		
	}

}
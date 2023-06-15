import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; //물이 새는 곳의 개수
	static int L; //테이프 한개의 길이
	static int[] point;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		point = new int[N];
		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(point);
		
		for (int i = 0; i < N; i++) {
//			System.out.println("---"+point[i]+"---");
			int end = point[i]+L-1;
//			System.out.println("end : "+ end);
			for (int j = i; j < N; j++) {
				if(point[j] > end) {
					i = j-1;
					count++;
					break;
				}
			}
//			System.out.println("count : " + count);
			
		}
		
		count++;
		
		System.out.println(count);
		
		
		
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;
public class Main {
	static int N;
	static int num[];
	static long[] result; //a용액,b 용액, c 용액, 합계
	static int low;
	static int high;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		if(N==3) {
			System.out.println(num[0]+" "+ num[1]+" "+num[2]);
			return;
		}
		
		result = new long[4];
//		System.out.println(Arrays.toString(num));
		result[3] = Long.MAX_VALUE;
//		System.out.println(Arrays.toString(result));
		for (int fix = 0; fix < N-2; fix++) {
			low = fix+1;
			high = N-1;
//			System.out.println();
//			System.out.println("=============");
//			System.out.println(fix +" >> fix : "+ num[fix]);
			while (low != high) {
				long sum = num[fix] + num[low];
				sum+= num[high];
				/*
				long sum = num[fix] + num[low]+num[high];
				이렇게 하면 오버플로우 나는데 왜 저렇게 하면 괜찮을까..?
				 */
				
//				System.out.println(num[fix] +" "+ num[low] +" "+ num[high]+" >> "+sum);
				if(sum == 0) {
//					정답
					System.out.println(num[fix] +" "+ num[low] +" "+ num[high]);
					return;
				}
				
				long absSum = Math.abs(sum);
				
				if(Math.abs(result[3]) > absSum) {
					result[0] = num[fix];
					result[1] = num[low];
					result[2] = num[high];
					result[3] = sum;
//					System.out.println("갱신 ! "+Arrays.toString(result));
				}
				if(sum < 0) {
					low++;
//					System.out.println("low 증가");
				}else if(sum > 0) {
					high--;
//					System.out.println("high 감소");
				}
				
				
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(result[i] +" ");
		}
	}
	

}
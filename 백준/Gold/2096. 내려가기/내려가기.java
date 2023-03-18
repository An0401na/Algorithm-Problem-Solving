import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [] num;
	static int minArr[];
	static int maxArr[];
	static int minScore;
	static int maxScore;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N*3];
		int j =0;
		for (int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[j++] = Integer.parseInt(st.nextToken());
			num[j++] = Integer.parseInt(st.nextToken());
			num[j++] = Integer.parseInt(st.nextToken());
		}
		
//		for (int i = 0; i < N*3; i++) {
//			System.out.print(num[i]+" ");
//		}

		minArr = Arrays.copyOf(num, num.length);
		maxArr = Arrays.copyOf(num, num.length);
		
		for (int i = 3; i < N*3; i++) {
			if(i%3 == 0) {
				minArr[i] = minArr[i-3]+num[i];
				if(minArr[i] > minArr[i-2]+num[i]) {
					minArr[i] = minArr[i-2]+num[i];
				}
				maxArr[i] = maxArr[i-3]+num[i];
				if(maxArr[i] < maxArr[i-2]+num[i]) {
					maxArr[i] = maxArr[i-2]+num[i];
				}
			}else if(i%3 == 1) {
				minArr[i] = minArr[i-4]+num[i];
				if(minArr[i] > minArr[i-3]+num[i]) {
					minArr[i] = minArr[i-3]+num[i];
				}
				if(minArr[i] > minArr[i-2]+num[i]) {
					minArr[i] = minArr[i-2]+num[i];
				}
				maxArr[i] = maxArr[i-4]+num[i];
				if(maxArr[i] < maxArr[i-3]+num[i]) {
					maxArr[i] = maxArr[i-3]+num[i];
				}
				if(maxArr[i] < maxArr[i-2]+num[i]) {
					maxArr[i] = maxArr[i-2]+num[i];
				}
			}else if(i%3 == 2) {
				minArr[i] = minArr[i-4]+num[i];
				if(minArr[i] > minArr[i-3]+num[i]) {
					minArr[i] = minArr[i-3]+num[i];
				}
				maxArr[i] = maxArr[i-4]+num[i];
				if(maxArr[i] < maxArr[i-3]+num[i]) {
					maxArr[i] = maxArr[i-3]+num[i];
				}
			}
//			System.out.println("==========="+i+" "+ i%3+"===========");
//			System.out.println(Arrays.toString(minArr));
//			System.out.println(Arrays.toString(maxArr));
		}
		minScore = 10*N;
		maxScore = -1;
		for (int i = 0; i < 3; i++) {
			minScore = Math.min(minScore, minArr[N*3-i-1]);
			maxScore = Math.max(maxScore, maxArr[N*3-i-1]);
		}

		System.out.println(maxScore+" "+ minScore);
	}
}
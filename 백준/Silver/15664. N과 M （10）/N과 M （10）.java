import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int result[];
	static int num[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> input = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
//			if(!input.contains(n)) {
				input.add(n);
//			}
		}

		num = new int[input.size()];
		
		for (int i = 0; i < input.size(); i++) {
			num[i] = input.get(i);
		}
		result = new int[M];
		
		
		Arrays.sort(num);

//		System.out.println(Arrays.toString(num));
		
		perm(0, 0);
		
		System.out.println(sb.toString());
	}
	private static void perm(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for (int i = start; i < num.length; i++) {
			if(prev != num[i]) {
				result[cnt] = num[i];
				prev = num[i];
				perm(cnt+1, i+1);				
			}
		}
		
		
	}

}
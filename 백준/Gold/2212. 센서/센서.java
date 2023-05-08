import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 센서의 수
	static int K; // 집중국의 개수
	static int sensor[]; // 센서의 좌표
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		sensor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
//		System.out.println("[Sensor]"+Arrays.toString(sensor));
		int term[] = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			term[i] = sensor[i+1]-sensor[i];
		}
//		System.out.println("[Term] : "+Arrays.toString(term)); 
	
		
		for (int i = 0; i <N-1; i++) {
			min+=term[i];
		}
		if(K >= N) {
			System.out.println(0);
			System.exit(0);
		}
//		System.out.println(min);
		boolean cut[] = new boolean[N];
		for (int i = 0; i < K-1; i++) {
			int maxTerm = 0;
			int idx = -1;
			for (int j = 0; j < N-1; j++) {
				if(maxTerm < term[j]) {
					maxTerm = term[j];
					idx = j;
				}
			}
			cut[idx] = true;

			min -= term[idx];
			term[idx] = -1;
		}
		cut[cut.length-1] = true;
//		System.out.println(Arrays.toString(cut));
		
		System.out.println(min);
	
		//전체 sum에서 큰 차이들을 한개씩 뺀다. 덩어리가 K가 될때까ㅓ지
	}

}
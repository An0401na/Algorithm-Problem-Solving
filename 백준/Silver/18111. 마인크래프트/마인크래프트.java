import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int B;
	static int map[][];
	static int min;
	static int max;
	static int time;
	static int hight;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		time = Integer.MAX_VALUE;
		for (int h = min; h <= max; h++) {
			int t = makeFlat(h);
			if(t == -1) continue; //평탄화 못할때
			if(time >= t) {
				time = t;
				hight = h;
			}
		}
		System.out.println(time+" "+ hight);
		
	}
	static int makeFlat(int h) {
		int count = B; //사용한 블럭 횟수
		int t =0;
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(map[i], M);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] > h) {
					int dis = copy[i][j]-h;
					count += dis;
					t += dis*2;
					copy[i][j] = h;
				}
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] < h) {
					int dis = h - copy[i][j];
					count -= dis;
					if(count < 0) {
						return -1;
					}
					t += dis;
					copy[i][j]=h;
				}
			}
		}
		return t;
		
	}
	static void print(int[][] copy) {
		System.out.println("-------------------------------");
		for (int i = 0; i < copy.length; i++) {
			System.out.println(Arrays.toString(copy[i]));
		}
		
	}

}
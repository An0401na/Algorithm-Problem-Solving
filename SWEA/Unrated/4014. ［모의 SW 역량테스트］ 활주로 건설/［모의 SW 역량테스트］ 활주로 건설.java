import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int X;
	static boolean pass[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			pass = new boolean[N*2];
			
			Arrays.fill(pass, true);
			int p =0;
			check(map, 0);
			int copymap[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copymap[i][j] = map[j][i];
				}
			}
			check(copymap, N);
			
			int result =0;
			for (int j = 0; j < N*2; j++) {
				if(pass[j]) {
					result ++;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
			
		}
		
		
	}
	static void check(int[][] map, int n) {
		for (int i = 0; i < N; i++) {
//			System.out.println("==========="+(i+n)+"============");
			int cnt = 1;
			for (int j = 0; j < N-1; j++) {
//				System.out.println("==="+j+"===");
//				System.out.println(map[i][j]+" - " + map[i][j+1] +" = "+(map[i][j] - map[i][j+1]));
				if(Math.abs(map[i][j] - map[i][j+1]) > 1) {
//					System.out.println("단 차이가 "+(map[i][j] - map[i][j+1]));
					pass[n+i] = false;
					break;
				}else if(map[i][j] - map[i][j+1] == -1) { // 올라가는 경우
//					System.out.println("올라가는 경우");
					if(cnt < X) {
//						System.out.println("cnt : "+ cnt+" // cnt가 L보다 작다.");
						pass[n+i] = false;
						break;
					}
					cnt = 1;
				}else if(map[i][j] -map[i][j+1] == 1){ //내려가는 경우
//					System.out.println("내려가는 경우");
					int k = j+1;
					cnt = 1;
					while (k < N-1 &&map[i][k] == map[i][k+1]) {
						cnt++;
						k++;
					}
//					System.out.println("내려가고서 같은 단이 몇개가 있는지 : " + cnt);
					if(cnt < X) {
//						System.out.println("cnt("+cnt+")가 L보다 작다.");
						pass[n+i] = false;
						break;
					}
					cnt =0;
					j = j+X-1;
				}else if(map[i][j] == map[i][j+1]) {
					cnt++;
//					System.out.println("다음거랑 같아서 cnt 증가");
				}
			}
		}
	}

}
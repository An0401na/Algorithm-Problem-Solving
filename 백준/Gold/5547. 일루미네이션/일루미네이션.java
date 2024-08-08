import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H, map[][];
	static int[] dro = {-1, -1, 0, 0, 1, 1};
	static int[] dco = {0, 1, -1, 1, 0, 1};
	static int[] dre = {-1, -1, 0, 0, 1, 1};
	static int[] dce = {-1, 0, -1, 1, -1, 0};
	
	static void dfs(int r, int c) {
		int nr, nc;
		if(r % 2 == 1) {
			for(int i=0;i<6;i++) {
				nr = r + dro[i];
				nc = c + dco[i];
				if(nr < 0 || nc < 0 || nr >= H+2 || nc >= W+2) {
					continue;
				}
				if(map[nr][nc] == 0) {
					map[nr][nc] = 2;
					dfs(nr, nc);
				}
			}
		} else {
			for(int i=0;i<6;i++) {
				nr = r + dre[i];
				nc = c + dce[i];
				if(nr < 0 || nc < 0 || nr >= H+2 || nc >= W+2) {
					continue;
				}
				if(map[nr][nc] == 0) {
					map[nr][nc] = 2;
					dfs(nr, nc);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+2][W+2];
		for(int i=1;i<=H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		int ans = 0;
		int nr, nc;
		for(int i=1;i<=H;i+=2) {
			for(int j=1;j<=W;j++) {
				if(map[i][j] == 1) {
					for(int k=0;k<6;k++) {
						nr = i + dro[k];
						nc = j + dco[k];
						if(map[nr][nc] == 2) {
							ans++;
						}
					}
				}
			}
		}
		for(int i=2;i<=H;i+=2) {
			for(int j=1;j<=W;j++) {
				if(map[i][j] == 1) {
					for(int k=0;k<6;k++) {
						nr = i + dre[k];
						nc = j + dce[k];
						if(map[nr][nc] == 2) {
							ans++;
						}
					}
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[][]map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		star(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					sb.append("*");
				}else {
					sb.append(" ");
				}	
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void star(int r, int c, int n) {
		if(n==3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1) {
						continue;
					}else {
						map[r+i][c+j]=1;
					}
				}
			}
		}else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1) {
						continue;
					}else {
						star(r+i*n/3,c+j*n/3,n/3);	// ?/3은 더 안으로 들어간다고 생각하기!
					}
				}
			}
		}
		 
	}
}

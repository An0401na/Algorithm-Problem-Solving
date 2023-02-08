import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[][]map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][2*N-1];
		star(0,N-1,N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
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
		//r, c 는 삼각형 꼭대기로 기준을 잡기
		if(n==3) {
			map[r][c]=1;  //제일 작은 삼각형에서 제일 위 별
			map[r+1][c-1]=1; //제일 작은 삼각형에서 가운데 왼쪽 별
			map[r+1][c+1]=1; //제일 작은 삼각형에서 가운데 오른쪽 별
			for (int i = -2; i < 3; i++) {
				map[r+2][c+i]=1; //제일 작은 삼각형에서 3번재 5개 연속 별
			}
		}else {
			for (int i = 0; i < 2; i++) {
				star(r,c,n/2);
				star(r+n/2,c-n/2,n/2);
				star(r+n/2,c+n/2,n/2);
			}
		}
	}
}

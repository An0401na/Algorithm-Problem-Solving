import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int r;
	static int c;
	static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r =Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		
		Z(1<<N,0,0);
	}
	private static void Z(int n, int row, int col) {
		if(n==2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if(row+i==r && col+j==c) {
						System.out.println(count);
						return ;
					}else {
					count++;
					}
					
				}
			}
		}else {
			if(r>=row && r<row+n && c>=col && c<col+n) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						Z(n/2,row+i*n/2, col+j*n/2);
					}
				}
			}else {
				count = count+(n * n);	
			}
		}
		
	}
}

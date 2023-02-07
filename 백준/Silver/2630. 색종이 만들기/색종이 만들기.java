
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] paper;
	static int count[]= new int[2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int j =0;
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				paper[i][j++]=a;
			}
		}
		
		MakePaper(N, 0,0);
		System.out.println(count[0]);
		System.out.println(count[1]);
		
		
	}

	private static void MakePaper(int n, int r, int c){
		int k=paper[r][c];
		Loop1 : for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(paper[r+i][c+j]!=k) {
					k=2;
					break Loop1;
				}
			}
		} 
		if(k==2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					MakePaper(n/2, r+i*n/2, c+j*n/2);
				}
			}
		}
		else {
			count[k]++;
		}
	}
}

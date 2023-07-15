import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int in[]; // left root right
	static int post[]; // left right root
	static int pre[]; //root left right
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		in = new int[N];
		post = new int[N];
		pre = new int[N];
		StringTokenizer stin = new StringTokenizer(br.readLine());
		StringTokenizer stpost = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(stin.nextToken());
			post[i] = Integer.parseInt(stpost.nextToken());
		}
		
		
		getPre(0, 0, N-1, N-1);
		
		for (int i = 0; i < N; i++) {
			System.out.print(pre[i]+" ");
		}
	}
	static void getPre(int preIdx, int inStart, int inEnd, int postIdx) {
		if(inStart > inEnd) {
//
//			System.out.print("[ inStart ] : " + inStart);
//			System.out.println(" ~ [ inEnd ] : " + inEnd);
//			System.out.println("리턴");
			return;
		}
		
//		System.out.println("-----------"+preIdx+"---------");
//		System.out.println("[ preIdx ] : " + preIdx);
//		System.out.print("[ inStart ] : " + inStart);
//		System.out.println(" ~ [ inEnd ] : " + inEnd);
//		System.out.println("[ postIdx ] : " + postIdx);
		
		
		pre[preIdx] = post[postIdx];
//		System.out.println(Arrays.toString(pre));
		
		for (int i = inStart; i <= inEnd; i++) {
			if(pre[preIdx] == in[i]) {
				getPre(preIdx+1, inStart, i-1, postIdx - (inEnd-i)-1); // 왼쪽
				
				getPre(preIdx+(i-inStart)+1, i+1, inEnd, postIdx-1); //오른쪽
				break;
			}
		}
		
		
		
	}

}
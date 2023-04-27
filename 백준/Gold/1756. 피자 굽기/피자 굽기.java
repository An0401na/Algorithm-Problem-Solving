import java.io.*;
import java.util.*;

public class Main {
	static int D; //오븐의 깊이
	static int N; //피자 반죽의 개수 
	static int top =0; //맨 위 피자를 넣었을 때의 깊이
	static int oven []; //최상단에서 차례대로 넣었을때 들어갈 수 있는 피자 반죽의 지름
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		oven = new int[D];
		st = new StringTokenizer(br.readLine());
		
		int ovenDia = Integer.parseInt(st.nextToken());
		Arrays.fill(oven, ovenDia);
		
		for (int i = 1; i < D; i++) {
			ovenDia = Integer.parseInt(st.nextToken());
			if(oven[i-1] < ovenDia) oven[i] =oven[i-1];
			else oven[i] = ovenDia;
//			Arrays.fill(oven, i, D, ovenDia);
		}
		
//		System.out.println();
//		System.out.println(Arrays.toString(oven));
//		for (int i = 0; i < 8; i++) {
//			System.out.println(findPizzaIdx(i));
//		}
		
		top = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		int right = D;
		for (int i = 0; i <N; i++) {
			int pizzaDia = Integer.parseInt(st.nextToken());
			int idx = findPizzaIdx(pizzaDia, right);
			if(idx<0) {
				System.out.println(0);
				return;
			}
			if(top > idx) top = idx;
			right = idx;
//			oven = Arrays.copyOf(oven, idx);
//			System.out.println("pizza dia : " + pizzaDia);
//			System.out.println("pizza idx : "+ idx);
////			System.out.println("top : "+ top);
//			for (int j = 0; j < right; j++) {
//				System.out.print(oven[j]+" ");
//			}
//			System.out.println();
//			System.out.println(Arrays.toString(oven));
		}
		
		System.out.println(top+1);
		
	}
	private static int findPizzaIdx(int key, int right) {
		int left = 0;
//		int right = oven.length;
		int mid = 0;
		while (left<right) {
			mid = (left + right) /2;
			if(key > oven[mid]) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return left-1;
	}
	
	
	
}
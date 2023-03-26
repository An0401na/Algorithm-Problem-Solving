import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//교수님 풀이
//		count = Integer.MAX_VALUE;
//		for (int i = 0; i < N/5; i++) {
//			if((N-i*5) % 3 ==0) {
//				count = Math.min(count, (i)+((N-i*5)/3));
//			}
//		}
//		System.out.println(count == Integer.MAX_VALUE?-1:count);
		//-----------------------------
		
		//19
		int n = N % 5;  //4
		int m = N / 5;   //3
		count= -1;
		
	
		while(true) {
			if(m<0) break;
			if(n%3 == 0) { //5kg으로 나눠 가져가고 3kg단위로 나눠 가져갈 수 있을 때 
				count = m +(n/3);
				break;
			}else if(n%3 != 0){ //5kg으로 나눠 가져가고 3kg단위로 못가져갈때
				// 1,2,4,8
				m--; //5kg짜리 하나 빼기
				n+=5; //6,7,9,13
			}
		}
		System.out.println(count);
		
	}
}
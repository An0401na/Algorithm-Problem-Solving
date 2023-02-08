import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N=9;
	static int M =100;
	static int p[] = new int[9];
	static boolean[] visited= new boolean[9];
	static int nums[]=new int [7];
	static int result[]= new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			p[i] = sc.nextInt();
		}
		
		combi(0, 0);
		Arrays.sort(result);
		for (int i = 0; i <7; i++) {
			System.out.println(result[i]);
		}
	}
	
	static void combi(int cnt, int total) {
		if(cnt ==7 ) {
			if(total==100) {
				System.arraycopy(nums, 0, result, 0, nums.length);
				return ;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i]=true;
			nums[cnt]=p[i];
			combi(cnt+1, total+p[i]);
			nums[cnt]=0;
			visited[i]= false;
		}
	}

}

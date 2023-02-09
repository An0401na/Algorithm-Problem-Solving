
import java.util.Scanner;

public class Main {
	static int[] num = {2,3,5,7};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < 4; i++) {
			dfs(num[i],1);
		}
	}
	

	static void dfs(int d, int count) {
		if(count==N) {
			System.out.println(d);
			return;
		}
		for (int i = d*10; i < d*10+10; i++) {
			if(isPrime(i)) {
				dfs(i,count+1);
			}
		}
		
	}


	static boolean isPrime(int n) {
		if(n<=1) return false;
		for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true; 
	}
}

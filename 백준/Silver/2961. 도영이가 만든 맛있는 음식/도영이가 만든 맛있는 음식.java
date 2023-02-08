import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int taste[][];
	static boolean [] visited;
	static int result=1000000000;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		taste = new int[n][2];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			taste[i][0]=sc.nextInt();
			taste[i][1]=sc.nextInt();
		}
		powerset(0,1,0);
		System.out.println(result);
		
	}
	static void powerset(int cnt, int s, int b) {
		if(cnt==n) {
			int count=0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) count++;
			}
			if(count>0) {
				int min = Math.abs(s-b);
				if(result>min) {
					result=min;
				}
			}
			return;
		}
		visited[cnt] = true;
		powerset(cnt+1, s*taste[cnt][0],b+taste[cnt][1]);
		

		visited[cnt] = false;
		powerset(cnt+1, s,b);
		
	}
	
	

}

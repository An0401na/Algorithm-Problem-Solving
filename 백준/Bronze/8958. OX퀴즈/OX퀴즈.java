import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int []result = new int[n];
		for (int i = 0; i < n; i++) {
			String ox=sc.next();
			
			int sum=1;
			int score=0;
			for (int j = 0; j < ox.length(); j++) {
				if(ox.charAt(j) == 'O') {
					score+=sum++;

				}else {
					sum=1;
				}
			}
			result[i]=score;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);
			
		}
		
	}
}


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		double []result = new double[c];
		for (int i = 0; i < c; i++) {
			int n = sc.nextInt();
			int sum=0;
			int [] score =new int[n];
			for (int j = 0; j < n; j++) {
				score[j]=sc.nextInt();
				sum+= score[j];
			}
			int avg =  sum/n;
			int count =0;
			for (int j = 0; j < n; j++) {
				if(avg<score[j]) {
					count++;
				}
			}
			result[i] = (double)count/n*100;
			
			
		}
		for (int i = 0; i < c; i++) {
			System.out.printf("%.3f%%\n",result[i]);
			
		}
		
	}
}

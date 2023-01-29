
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num[] = new int[n];
		int count =0;
		boolean flag;
		for (int i = 0; i < n; i++) {
			num[i]= sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if(num[i]==1) {
				flag=false;
			}else {
				flag=true;
			}
			for (int j = 2; j <num[i]; j++) {
				if(num[i]%j==0) {
					flag=false;
					break;
				}	
			}
			if(flag) {
				count++;
			}
		}
		System.out.println(count);
	}
}

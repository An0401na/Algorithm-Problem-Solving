import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] n = new int[10];
		int a;
		for (int i = 0; i < 10; i++) {
			a = sc.nextInt();
			n[i]=a%42;
		} 
		int count=10;
		for (int i = 0; i < 10; i++) {
			for (int j = i+1; j < 10; j++) {
				if(n[i]==n[j]) {
					count--;
					break;
				}
			}
		}
		System.out.print(count);

	}

}

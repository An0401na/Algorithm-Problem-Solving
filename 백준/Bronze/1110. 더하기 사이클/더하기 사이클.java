import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count =0;
		int newnum =num;
		int a;
		int b;
		while (true) {
			a = newnum/10;
			b = newnum%10;
			newnum=b*10+(a+b)%10;
			count++;
			if(newnum == num) {
				break;
			}
		}
		System.out.print(count);

	}

}

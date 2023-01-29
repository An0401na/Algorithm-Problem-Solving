
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //+ 피로
		int b = sc.nextInt(); //+ 일
		int c = sc.nextInt(); //- 피로
		int m = sc.nextInt(); //번아웃 기준
		
		int work =0;
		int fatigue=0;
		
		for (int i = 0; i < 24; i++) {
			if(fatigue+a<=m) {
				fatigue+=a;
				work+=b;
			}else {
				if(fatigue-c<0) {
					fatigue=0;
				}else {
					fatigue-=c;
				}
			}	
			
		}
		System.out.println(work);
	}
}

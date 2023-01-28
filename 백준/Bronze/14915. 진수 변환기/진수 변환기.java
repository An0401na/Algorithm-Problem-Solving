import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		String result="";
		String [] abc = {"A","B","C","D","E","F"};
		
		int i =0; //지수
		while (true) {
			if((int)(m/Math.pow(n, i))>0) {
				i++;
			}else {
				break;
			}
		}
		if(m==0) {
			result="0";
		}
		for (int j = i-1; j >=0; j--) {
			if(m>=Math.pow(n,j)) {
				if((int)(m/Math.pow(n, j))>9) {
					result = result+abc[(int)(m/Math.pow(n, j))%10];
					m=(int) (m%Math.pow(n, j));
				}else {
					result = result+Integer.toString((int) (m/Math.pow(n, j)));
					m=(int) (m%Math.pow(n, j));
				}
			}else {
				result = result+"0";
			}	
		}
		System.out.println(result);
		
		
	}
}

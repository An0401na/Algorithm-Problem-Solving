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
		
		//10진수 m이 0이라면 n진수로 변환시 모두 0
		if(m==0) {
			result="0";
		}
		
		//10진수 m을 n진수로 표현하기 위해서 몇자리수까지 필요한지 체크
		while (true) {
			if((int)(m/Math.pow(n, i))>0) {
				i++;
			}else {
				break;
			}
		}
		
		
		for (int j = i-1; j >=0; j--) {
			if(m>=Math.pow(n,j)) {
				if((int)(m/Math.pow(n, j))>9) { //n이 10이상일때부터 나누는 몫이 10이상이 나올수 있다.
					result = result+abc[(int)(m/Math.pow(n, j))%10]; //알파벳으로 표현해야하는경우
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

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int div = 0; //최대공약수
		int mul =0;  //최소공배수
		
		int num1_temp=num1, num2_temp=num2;

		int i=1,j=1;
		
		//입력받는 숫자가 같을 경우 따로 처리
		if(num1==num2) {
			div = num1;
			mul = num1;
		}
		
		//최대공약수 구하기
		while(num1_temp != num2_temp) {
			if(num1_temp > num2_temp) {
				if(num1%i==0) {
					num1_temp=num1/i;
					div=num1_temp;
				}
				i++;
			}else {
				if(num2%j==0) {
					num2_temp=num2/j;
					div=num2_temp;
				}
				j++;
			}
		}
		
		num1_temp=num1;
		num2_temp=num2;
		
		i=0;
		j=0;
		
		//최소공배수 구하기
		while(num1_temp != num2_temp) {
			if(num1_temp > num2_temp) {
				j++;
				num2_temp=num2*j;
				mul=num2_temp;
			}else {
				i++;
				num1_temp=num1*i;
				mul=num1_temp;
			}
		}

		System.out.println(div);
		System.out.println(mul);
		
		
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String cro[] = {"dz=","c=", "c-", "d-","lj","nj", "s=", "z="};
		
		String str = sc.next();
		int i =1;
		int count=0;
		boolean flag= false;
		while(i<=str.length()) {
			if(str.length()==i) {
				count++;
				break;
			}
			
			if(i<str.length()-1) {
				if(str.substring(i-1,i+2).equals(cro[0])) {
					count++;
					i+=3;
					continue;
				}
			}
			for (int j = 1; j < 8; j++) {
				if(str.substring(i-1,i+1).equals(cro[j])) {
					count++;
					i+=2;
					flag=true;
					break;
				}
			}
			if(flag) {
				flag=false;
				continue;
			}else {
				i++;
				count++;	
			}
		}
		System.out.println(count);
		
	}	
}


import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
//		System.out.println(d(2));
//		list.add(1);
		boolean flag = true;
		for (int i = 1; i < 10000; i++) {
			flag= true;
			for (Integer integer : list) {
				if(integer==i) {
					list.remove(Integer.valueOf(i));
					list.add(d(i));
					flag= false;
					break;
				}
			}
			if(flag) {
				list.add(d(i));
				System.out.println(i);
			}
		}
	}
	
	static int d(int n) {
		String a = String.valueOf(n);
		int ans=n;
		for (int i = 0; i < a.length(); i++) {
			ans += (int)a.charAt(i)-48;
		}
		return ans;
	}
}

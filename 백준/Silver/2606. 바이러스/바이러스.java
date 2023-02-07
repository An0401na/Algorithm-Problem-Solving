import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static HashSet<Integer> visited = new HashSet<>();
    static ArrayList<Integer> []connect;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int com = sc.nextInt(); //컴퓨터의 수
        int connectNum = sc.nextInt(); //연결의수

        connect = new ArrayList [com+1];
        for (int i = 0; i <=com; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectNum; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            connect[c1].add(c2);
            connect[c2].add(c1);
        }


        visited.add(1);
        search(1,0);
        System.out.println(visited.size()-1);


    }

    private static void search(int start, int pre) {
        boolean flag;
        for (int i = 0; i < connect[start].size(); i++) {
            flag=false;
            Iterator<Integer> iterSet = visited.iterator();
            while (iterSet.hasNext()){
                int n = iterSet.next();
                if(connect[start].get(i)==n){
                    flag=false;
                    break;
                }else{
                    flag=true;
                }
            }
            if(flag || visited.size()==0) {
                visited.add(connect[start].get(i));
                search(connect[start].get(i), start);
            }
        }
    }
}

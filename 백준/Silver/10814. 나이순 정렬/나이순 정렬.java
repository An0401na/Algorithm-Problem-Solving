import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class User implements Comparable<User>{
        int age;
        String name;
        public User(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int compareTo(User o){
            return this.age - o.age;
        }
    }
    static User[] users;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        users = new User[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(users);

        for (int i = 0; i < N; i++) {
            System.out.println(users[i].age+" "+users[i].name);

        }
    }
}

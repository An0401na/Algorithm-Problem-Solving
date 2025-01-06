import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> names = new HashSet<>();
        LinkedList<String> result = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(names.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Dummy[] dummies;

    static class Dummy{
        long a;
        long b;
        long c;

        @Override
        public String toString() {
            return "Dummy{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }

        public Dummy(long a,long c, long b) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static long max = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dummies = new Dummy[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dummies[i] = new Dummy(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            max = Math.max(max, dummies[i].c);
        }

        long start = 1;
        long end = max;
        long resultNum = -1;
        while (start <= end){
//            System.out.println("start : "+ start +", end : "+ end);

            long mid = (start + end)/2;
//            System.out.println("mid : " + mid);
            long numCnt = getsmallOrEqualNumCnt(mid);

            if(numCnt % 2L == 1){
//                System.out.println("1-------------------");
                end = mid - 1;
                resultNum = mid;
            }else{
//                System.out.println("0-----");
                start = mid +1;
            }
        }

        if(resultNum == -1){
            System.out.println("NOTHING");
            return;
        }
        // 가장 오른쪽거에서 - 가장 왼쪽꺼 +1
        long cnt = getsmallOrEqualNumCnt(resultNum) - getsmallOrEqualNumCnt(resultNum-1);

        System.out.println(resultNum +" "+cnt);
    }



    // 1 1 2 2 2 2 3 3 4 4 4 5 5
    // 0 0 0 0 0 0 0 0 1 1 1
    private static long getsmallOrEqualNumCnt(long target) {
        long total = 0;

        for (int i = 0; i < N; i++) {
            if(target < dummies[i].a) continue;
            if(dummies[i].c < target) {
//                System.out.println("개수 : " + getCnt(dummies[i].c, i));
                total += getCnt(dummies[i].c , i);
            }else{
//                System.out.println("개수 : " + getCnt(target, i));
                total += getCnt(target, i);
            }

//            System.out.println("target : " + target+" total : "+total);

        }

        return total;
    }

    private static long getCnt(long target, int i) {
        return ((target - dummies[i].a) / dummies[i].b) + 1;
    }

}
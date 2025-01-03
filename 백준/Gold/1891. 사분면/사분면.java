import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int d; // 조각 번호의 자리수
    static int num[];
    static long x;
    static long y;
    static int result[];
    static Point p;
    static class Point{
        long r;
        long c;
        public Point(long r, long c){
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());

        num = new int[d];
        result = new int[d];

        String str = st.nextToken();
        for (int i = 0; i < d; i++) {
            num[i] = str.charAt(i) - '0';
        }

        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        long len = (long)Math.pow(2, d);
        p = numToPoint(0, len, 0, len,0);

        p.r += y * -1;
        p.c += x;

        if(!isInRange(p.r, p.c, len)){
            System.out.println(-1);
            return;
        }

        pointToNum(0, len, 0, len, 0);

        for (int i = 0; i < d; i++) {
            System.out.print(result[i]);
        }

    }
    public static boolean isInRange(long r, long c, long len){
        if(0 <= r && r < len && 0 <= c && c < len){
            return true;
        }
        return false;
    }

    public static void pointToNum(long r1, long r2, long c1, long c2, int idx){

        if(idx == d) return;

        int n ;
        long rMid = (r1 + r2) / 2;
        long cMid = (c1 + c2) / 2;
        if(r1 <= p.r && p.r < rMid){
            r2 = rMid;
            if(cMid <= p.c && p.c < c2){
                c1 = cMid;
                n = 1;
            }else {
                c2 = cMid;
                n = 2;
            }
        }else {
            r1 = rMid;
            if(cMid <= p.c && p.c < c2){
                c1 = cMid;
                n = 4;
            }else{
                c2 = cMid;
                n = 3;
            }
        }

        result[idx] = n;
        pointToNum(r1, r2, c1, c2, idx+1);
    }
    public static Point numToPoint(long r1, long r2, long c1, long c2, int idx){
        if(idx == d) return new Point(r1, c1);

        switch (num[idx]){
            case 1:
                r2 = (r1 + r2) / 2;
                c1 = (c1 + c2) / 2;
                break;
            case 2:
                r2 = (r1 + r2) / 2;
                c2 = (c1 + c2) / 2;
                break;
            case 3:
                r1 = (r1 + r2) / 2;
                c2 = (c1 + c2) / 2;
                break;
            case 4:
                r1 = (r1 + r2) / 2;
                c1 = (c1 + c2) / 2;
                break;
        }

        return numToPoint(r1, r2, c1, c2, idx+1);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static class Point{
        long x;
        long y;

        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }



        long start = 0;
        long end = 2_000_000_000;
        long result  = 0;
        while (start <= end) {
//            System.out.println("start : " + start +" end : " + end);
            long mid = (start + end) / 2L;
//            System.out.println("mid : " + mid);

            if(ok(mid)){ // k개의 점을 포함하는 정사각형이 있다면
//                System.out.println(mid +" 길이 정사각형에 K개 존재----------------------result 갱신");
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        long len = result+2;

        System.out.println(len*len);


    }

    private static boolean ok(long len) {
        for (int i = 0; i < N; i++) {
            long leftX = points[i].x;
            long rightX = points[i].x + len;
            for (int j = 0; j < N; j++) {
                long bottomY = points[j].y;
                long topY = points[j].y + len;

                int cnt = 0;
                for (int k = 0; k < N; k++) {
                    if (isInRange(k, leftX,rightX,bottomY,topY)){
                        cnt++;
                    }
                }

                if(cnt >= K) {
                    return true;
                }
            }
            
        }
        return false;
    }

    private static boolean isInRange(int k, long left, long right, long bottom, long top) {
        return left <= points[k].x && points[k].x <= right && bottom <= points[k].y && points[k].y <= top;
    }

}
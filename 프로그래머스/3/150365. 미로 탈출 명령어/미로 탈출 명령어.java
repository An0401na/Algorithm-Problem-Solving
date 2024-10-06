class Solution {

        static int dir[][] = {{1, 0}, {0, -1}, {0, 1}, {-1,0}}; //dlru
        static String dirString[] = {"d", "l", "r", "u"};
        static int n;
        static int m;
        static int r;
        static int c;
        static int k;
        static String answer = "";
        static boolean isSuccess = false;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            this.n = n;
            this.m = m;
            this.r = r;
            this.c = c;
            this.k = k;

            if(x == r && y == c ) return "";

            if(!canArrival(x, y, k) ) return "impossible";

            findPath(x, y, 0, "");
            if(!isSuccess){
                return "impossible";
            }
            return answer;
        }

        private boolean canArrival(int x, int y, int remainder) {
            int shortestLength = getShortestLength(x, y);
            if(remainder < shortestLength){ // 남은 횟수로 절대 r,c에 도달할 수 없을 경우
                return false;
            }
            if(shortestLength % 2 != remainder % 2){
                return false;
            }
            return true;
        }

        private int getShortestLength(int x, int y) {
            return Math.abs(r - x) + Math.abs(c - y);

        }

        private void findPath(int x, int y, int cnt, String path) {
            if(isSuccess) return;
            if(cnt == k){
                if(x == r && y == c){
                    isSuccess = true;
                    answer = path;
                    return;
                }
                // k만큼 이동해서 도착한 근처에 r,c가 인접해있다면 절대 도달할 수 없는 경우
                for (int i = 0; i < 4; i++) {
                    if(x+dir[i][0]==r && y+dir[i][1] ==c){
                        isSuccess = true;
                        answer = "impossible";
                    }
                }

                return;
            }

            for (int i = 0; i < 4; i++) {
                if(isSuccess) return;
                int nx = x+dir[i][0];
                int ny = y+dir[i][1];
                if(isInRange(nx, ny) && canArrival(nx, ny, k - cnt-1)){
                    findPath(nx, ny,cnt+1, path+dirString[i]);
                }
            }
        }

        private boolean isInRange(int r, int c) {
            return 1 <= r && r <= n && 1 <= c && c <= m;
        }

}

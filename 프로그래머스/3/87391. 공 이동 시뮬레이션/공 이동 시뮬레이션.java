class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {

        long up = x, bottom = x;
        long left = y, right = y;


        for (int i = queries.length-1; i >= 0; i--) {
            int dir  = queries[i][0];
            int dx = queries[i][1];

            switch (dir){
                case 0 :  // 좌로 이동

                    // 범위는 우로 범위 이동
                    // left가 벽에 붙어 있으면 이동하지 않아도 됨
                    // left가 dx 만큼 범위를 오른쪽으로 이동했을때 격자를 넘어가면 ?
                    if(left != 0 ){
                        if(left + dx >= m) return 0;
                        left += dx;
                    }
                    right = Math.min(m-1, right + dx);
                    break;
                case 1 :  // 우로 이동
                    if(right != m-1 ){
                        if(right - dx < 0) return 0;
                        right -= dx;
                    }
                    left = Math.max(0, left -  dx);
                    break;
                case 2 :  // 위로 이동
                        if(up != 0 ){
                            if(up + dx >= n) return 0;
                            up += dx;
                        }
                        bottom = Math.min(n-1, bottom + dx);
                        break;
                case 3 :  // 아래로 이동
                    if(bottom != n-1 ){
                        if(bottom - dx < 0) return 0;
                        bottom -= dx;
                    }
                    up = Math.max(0, up -  dx);
                    break;
                }

            }

            long answer = (right - left+1) * (bottom - up+1);
            return answer;
        }
}
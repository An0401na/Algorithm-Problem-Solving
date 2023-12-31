import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Main {
    static int N;
    static Column[] columns;
    static class Column implements Comparable<Column>{
        int x;
        int h;
        public Column(int x, int h){
            this.x = x;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Column{" +
                    "x=" + x +
                    ", h=" + h +
                    '}';
        }

        @Override
        public int compareTo(Column o) {
            return this.x - o.x;
        }
    }
    static int area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        columns = new Column[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            columns[i] = new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(columns);

        int maxColumnIdx = getTallestColumn(0, columns.length-1);

        int tallestColumnIdx = maxColumnIdx;
        area = columns[tallestColumnIdx].h;




        while (true){
            int tallestLeftIdx = getTallestColumn(0,tallestColumnIdx-1);

            area += (columns[tallestColumnIdx].x - columns[tallestLeftIdx].x) * columns[tallestLeftIdx].h;


            if(tallestLeftIdx == 0){
                break;
            }else{
                tallestColumnIdx = tallestLeftIdx;
            }
        }

        tallestColumnIdx = maxColumnIdx;
        while (true){
            int tallestRightIdx = getTallestColumn(tallestColumnIdx+1,columns.length-1);

            area += (columns[tallestRightIdx].x-columns[tallestColumnIdx].x ) * columns[tallestRightIdx].h;


            if(tallestRightIdx == columns.length-1){
                break;
            }else{
                tallestColumnIdx = tallestRightIdx;
            }
        }
        System.out.println(area);
    }

    private static int getTallestColumn(int startIdx, int endIdx) {
        if(startIdx == -1 ) return 0;
        if(startIdx == columns.length) return columns.length-1;
        int tallestColumnIdx = startIdx;
        Column tallestColumn = columns[startIdx];
        for (int i = startIdx+1; i <= endIdx; i++) {
            if(tallestColumn.h < columns[i].h){
                tallestColumn = columns[i];
                tallestColumnIdx = i;
            }
        }
        return tallestColumnIdx;
    }
}
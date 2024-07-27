import java.util.*;

class Solution {
    public class Row implements Comparable<Row>{
        int key; // key 기준 내림차순
        int colValue; // col 기준 오름차순
        int []row;

        public Row(int[] row, int col){
            this.row = row;
            key = row[0];
            colValue = row[col];
        }

        @Override
        public int compareTo(Row o) {
            if(o.colValue == this.colValue){
                return o.key - this.key;
            }
            return this.colValue - o.colValue;
        }

        public int sum(int i) {
            int result = 0;
            for (int j = 0; j < row.length; j++) {
                result += row[j] % i;
            }
            return result;
        }

        @Override
        public String toString() {
            return "Row{" +
                    "key=" + key +
                    ", colValue=" + colValue +
                    ", row=" + Arrays.toString(row) +
                    '}';
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int h = data.length;

        Row rows[] = new Row[h];
        for (int i = 0; i < h; i++) {
            rows[i] = new Row(data[i], col-1);
        }

        Arrays.sort(rows);

        int answer = 0;

        System.out.println();
        for (int i = row_begin-1; i < row_end; i++) {
            answer = answer ^ rows[i].sum(i+1);
        }

        return answer;
    }
}
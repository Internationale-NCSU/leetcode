import org.junit.Test;

import java.util.PriorityQueue;

public class leetcode378 {
    class RowData {
        int[] row;
        int index;
        public RowData(int[] row) {
            this.row = row;
            this.index = 0;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int result = 0;
        PriorityQueue<RowData> pq = new PriorityQueue<>((a, b)->(a.row[a.index]-b.row[b.index]));
        for (int[] ints : matrix) {
            pq.add(new RowData(ints));
        }
        while(k>0&&!pq.isEmpty()){
            RowData row = pq.poll();
            int[] curRow = row.row;
            result = curRow[row.index];
            row.index++;
            if(row.index<matrix.length){
                pq.offer(row);
            }
            k--;
        }
        return result;
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{
                {1,2,3},
                {1,3,5},
                {2,4,6}
        };
        System.out.println(kthSmallest(matrix,3));
    }
}

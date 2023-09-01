import java.util.PriorityQueue;

public class leetcode1337_TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierCount = new int[mat.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(soldierCount[a]!=soldierCount[b]){
                return soldierCount[a]-soldierCount[b];
            }else{
                return a-b;
            }
        });
        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]==1){
                    soldierCount[i]++;
                }
            }
        }
        for(int i=0; i<mat.length;i++){
            pq.add(i);
        }
        int[] result = new int[k];
        for(int i=0; i<result.length; i++){
            result[i] = pq.poll();
        }
        return result;
    }
}

import org.junit.Test;

public class leetcode2374_NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            score[edges[i]]+=i;
        }
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if(score[i]>score[max]){
                max = i;
            }
        }
        return max;
    }
    @Test
    public void test(){
        System.out.println(edgeScore(new int[]{1,0,1,1,1,1,1}));
    }

}

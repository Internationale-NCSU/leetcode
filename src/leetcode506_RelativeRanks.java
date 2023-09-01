import org.junit.Test;

import java.util.PriorityQueue;

public class leetcode506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->{return score[b]-score[a];}
        );
        for (int i = 0; i < score.length; i++) {
            pq.offer(i);
        }
        String[] ranks = new String[score.length];
        int count = 0;
        while(!pq.isEmpty()){
            count++;
            int index = pq.poll();
            if(count==1){
                ranks[index] = "Gold Medal";
            }else if(count==2){
                ranks[index] = "Silver Medal";
            }else if(count==3){
                ranks[index] = "Bronze Medal";
            }else{
                ranks[index] = count+"";
            }
        }
        return ranks;
    }
    @Test
    public void test(){
        System.out.println(  findRelativeRanks(new int[]{5,4,3,2,1}));
    }

}

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode2542MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        int totalSum = 0, res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return a-b;});
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][1] = nums1[i];
            pairs[i][0] = nums2[i];
        }
        Arrays.sort(pairs,(a,b)->{
            return b[0] - a[0];
        });
        for (int i = 0; i < nums1.length; i++) {
            totalSum = totalSum + pairs[i][1];
            pq.add(nums1[i]);
            if(pq.size()>k){
                totalSum -= pq.poll();
            }
            if(pq.size()==k){
                res = Math.max(res, totalSum * pairs[i][0]);
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(maxScore(new int[]{1,3,3,2},new int[]{2,1,3,4},3));
    }
}

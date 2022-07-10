import org.junit.Test;

import java.util.PriorityQueue;

public class leetcode215_II {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(b,a)->(nums[a]-nums[b]));
        for (int i = 0; i < nums.length; i++) {
            pq.add(i);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }
        return nums[result];
    }
    @Test
    public void test(){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

}

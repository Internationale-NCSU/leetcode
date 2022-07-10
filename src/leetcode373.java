import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->(
                a.get(0)+a.get(1)-b.get(0)-b.get(1)
            )
        );
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(Arrays.asList(nums1[i],nums2[j]));
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while(k>0&&!pq.isEmpty()){
            k--;
            result.add(pq.poll());
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(kSmallestPairs(new int[]{1,7,11},new int[]{2},3));
    }
}

import java.util.*;

public class leetcode215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->{return a-b;});
        for (int num : nums) {
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            };
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
}

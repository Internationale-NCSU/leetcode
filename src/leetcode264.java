

import java.util.PriorityQueue;
import java.util.Set;

public class leetcode264 {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->{return a-b;});
        int sum = 1;
        int nums = 1;
        int count = 0;
        priorityQueue.offer(sum);
        while (count<n){
            nums = priorityQueue.poll();
            if(!priorityQueue.contains(nums*2)) {
                priorityQueue.offer(nums * 2);
            }
            if(!priorityQueue.contains(nums*3)) {
                priorityQueue.offer(nums * 3);
            }
            if(!priorityQueue.contains(nums*5)) {
                priorityQueue.offer(nums * 5);
            }
            count++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(12));
    }
}

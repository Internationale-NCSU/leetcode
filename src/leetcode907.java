

import java.util.*;

public class leetcode907 {
    static int sum = 0;
    public static void findSubarray(int[] arr, int index, List<Queue<Integer>> result, Queue<Integer> queue){
        if(index>=arr.length){
            return;
        }
        queue.offer(arr[index]);
        Queue<Integer> tmp = new PriorityQueue<>(queue);
        sum = sum + queue.peek();
        result.add(tmp);
        findSubarray(arr,index+1,result,queue);
    }
    public static int sumSubarrayMins(int[] arr) {
        List<Queue<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            findSubarray(arr, i, result, new PriorityQueue<>());
        }
//        for (Queue<Integer> queue : result) {
//            int min = Integer.MAX_VALUE;
//            for (Integer integer : queue) {
//                min = Math.min(integer,min);
//            }
//            sum = (sum + min)%(1000000000+7);
//        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}

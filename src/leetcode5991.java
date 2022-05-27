import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode5991 {
    public static int[] rearrangeArray(int[] nums) {
//        int front=0,rear=1;
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=0){
                positive.offer(nums[i]);
            }else {
                negative.offer(nums[i]);
            }
        }
//        while(front!=nums.length-1){
//            if(nums[front]<0){
//
//            }
//        }
        int[] result = new int[nums.length];
        boolean turn = false;
        int index = 0;
        while(!positive.isEmpty()||!negative.isEmpty()){
            if(!turn) {
                result[index] = positive.poll();
            }else {
                result[index] = negative.poll();
            }
            turn = !turn;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,-1,-2,-3,-4,-5};
        Arrays.stream(rearrangeArray(arr)).forEach(a->{
            System.out.println(a);
        });

    }
}

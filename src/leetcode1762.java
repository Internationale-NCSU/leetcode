import java.util.*;

public class leetcode1762 {
    public static int[] findBuildings(int[] heights) {
        Queue<Integer> queue = new PriorityQueue<>();
        int highest = Integer.MIN_VALUE;
        for (int i = heights.length-1; i >=0 ; i--) {
            if(heights[i]>highest){
                queue.offer(i);
            }
            highest = Math.max(highest,heights[i]);
        }
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4};
        Arrays.stream(findBuildings(nums)).forEach(
                (a)->{
                    System.out.println(a);
                }
        );
    }
}

import org.junit.Test;

import java.util.Stack;

public class leetcode456_132Pattern_Stack {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<min[i-1]){
                min[i] = nums[i];
            }else {
                min[i] = min[i-1];
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i > 0 ; i--){
            if(nums[i]>min[i]){
                while(!stack.isEmpty()&&stack.peek()<=min[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()&&stack.peek()<nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
    }
}

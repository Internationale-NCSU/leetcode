import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetcode6190 {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        int left = 0;
        int right = 0;
//        boolean isNoneIncreasingLeft = true;
//        boolean isNoneDecreasingRight = true;
//        boolean needComputed = true;
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> rightStack = new LinkedList<>();
        boolean isFull = false;
        int count = 0;
        while(right<nums.length-1){
            if(!isFull) {
                if (leftStack.size() < k) {
                    if (leftStack.isEmpty() || nums[right] <= leftStack.peek()) {
                        leftStack.push(nums[right]);
                        count++;
                    } else {
                        rightStack.clear();
                        leftStack.clear();
                        right++;
                        left = right;
                        count = 0;
                        continue;
                    }
                } else if (count == k) {
                    count++;
                    continue;
                } else if (rightStack.size() < k) {
                    if (rightStack.isEmpty() || nums[right+1] >= rightStack.peek()) {
                        rightStack.push(nums[right+1]);
                        count++;
                    } else {
                        rightStack.clear();
                        leftStack.clear();
                        right++;
                        left = right;
                        count = 0;
                        continue;
                    }
                }
                right++;
            }else {
                if(nums[(right+left)/2] <= leftStack.peek()){
                    leftStack.removeLast();
                    leftStack.add(nums[(right+left)/2]);
                }else {
                    rightStack.clear();
                    leftStack.clear();
                    left = right;
                    isFull = false;
                    count = 0;
                    continue;
                }
                if(nums[right+1] >= rightStack.peek()){
                    rightStack.removeLast();
                    rightStack.add(nums[right+1]);
                }else {
                    rightStack.clear();
                    leftStack.clear();
                    right = right+1;
                    left = right;
                    isFull = false;
                    count = 0;
                    continue;
                }
                left++;
                right++;
            }
            if(leftStack.size()==k&&rightStack.size()==k){
                list.add((left+right)/2);
                isFull = true;
            }
        }

        return list;
    }
    //            if(needComputed) {
//                for (int i = left + 1; i < k; i++) {
//                    if (nums[i] > nums[i - 1]) {
//                        isNoneIncreasingLeft = false;
//                    }
//                }
//                for (int i = k + 1; i < right - 1; i++) {
//                    if (nums[i] > nums[i + 1]) {
//                        isNoneDecreasingRight = false;
//                    }
//                }
//                if (isNoneDecreasingRight && isNoneIncreasingLeft) {
//                    list.add((left + right) / 2);
//                }
//                left++;
//                right++;
//                needComputed = false;
//
    @Test
    public void test(){
        System.out.println(goodIndices(new int[]{2,1,1,1,3,4,1},2));
    }
}

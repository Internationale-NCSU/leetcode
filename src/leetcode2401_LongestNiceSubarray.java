import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetcode2401_LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int[] bitMark = new int[33];
        int max = 1;
        int left = 0,right = 0;
        if(nums.length==1) {
            return 1;
        }
        addNum(bitMark,nums[0]);
        while(++right<nums.length){
            while(true){
                if(check(bitMark,nums[right])){
                    addNum(bitMark,nums[right]);
                    break;
                }else {
                    removeNum(bitMark, nums[left]);
                    left++;
                }
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
    boolean check(int[] bitMark,int num){
        int index = 0;
        while(num!=0){
            int result = num&1;
            num = num>>1;
            if(bitMark[index]==1&&result==1){
                return false;
            }
            index++;
        }
        return true;
    }
    void addNum(int[] bitMark,int num){
        int index = 0;
        while(num!=0){
            int result = num&1;
            num = num>>1;
            if(result==1) {
                bitMark[index] = result;
            }
            index++;
        }
    }
    void removeNum(int[] bitMark,int num){
        int index = 0;
        while(num!=0){
            int result = num&1;
            if(result==1){
                bitMark[index] = 0;
            }
            num = num>>1;
            index++;
        }
    }
    @Test
    public void test(){
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
    }
}

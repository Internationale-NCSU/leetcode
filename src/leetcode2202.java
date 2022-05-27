public class leetcode2202 {
    public static int maximumTop(int[] nums, int k) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            if(k%2==1){
                return -1;
            }else {
                return nums[0];
            }
        }
        int max = Integer.MIN_VALUE;
        if(nums.length<k){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]>max){
                    max = nums[i];
                }
            }
            return max;
        }
        for (int i = 0; i < k-1; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        max = max>nums[k]?max:nums[k];
        return max;
    }

    public static void main(String[] args) {
        maximumTop(new int[]{2,10},3);
    }
}

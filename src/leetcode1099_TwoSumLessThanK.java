public class leetcode1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        int sum = -1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]<k){
                    sum = Math.max(nums[i]+nums[j],sum);
                }
            }
        }
        return sum;
    }
}

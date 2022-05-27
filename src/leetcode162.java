public class leetcode162 {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                return i;
            }
        }
        return nums[nums.length-1];
    }
}

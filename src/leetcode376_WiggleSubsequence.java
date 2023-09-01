public class leetcode376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int sz = nums.length;
        int increasing = 1;
        int decreasing = 1;
        for(int i=1;i<sz;i++){
            if(nums[i] > nums[i-1]) increasing=decreasing+1;
            else if(nums[i] < nums[i-1]) decreasing = increasing+1;
        }
        int subsequence_size = Math.min(sz,Math.max(increasing,decreasing));
        return (subsequence_size);
    }
}

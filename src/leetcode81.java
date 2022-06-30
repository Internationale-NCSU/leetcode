import org.junit.Test;

public class leetcode81 {
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            while(left<right&&nums[left]==nums[left+1]){
                left++;
            }
            while(left<right&&nums[right]==nums[right-1]){
                right--;
            }
            int mid = (left+right)/2;
            if(target == nums[mid]){
                return true;
            }
            if(nums[mid]>=nums[left]){
                if(nums[mid]>=target&&nums[left]<=target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid]<=target&&nums[right]>=target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(search(new int[]{6,6,6,6,7,8,9,9,9,9,1,1,1,1,2,3,4,5,6,6,6},6));
    }
}

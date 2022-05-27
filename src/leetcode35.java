public class leetcode35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int index = nums.length;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid]<target) {
                left = mid+1;
            }else {
                index = mid;
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
    }
}

public class leetcode1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int first = -1,second = -1;
        for (int i = 0; i < nums.length-1; i++) {
            first = i;
            for (int j = i+1; j < nums.length; j++) {
                    if(nums[j]==target-nums[first]){
                        second = j;
                    }
            }
            if(second!=-1){
                break;
            }
        }
        int[] result = new int[2];
        result[0] = first;
        result[1] = second;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(twoSum(nums,6));
    }
}

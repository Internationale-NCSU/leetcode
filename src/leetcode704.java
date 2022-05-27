public class leetcode704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int index = nums.length;
        int flag = 0;
        int mid_index;
        int lowerBorder = 0;
        int upperBorder = nums.length - 1;
        for (int i = lowerBorder; i < upperBorder; i++) {
            mid_index = (lowerBorder + upperBorder) / 2;
            int num = nums[mid_index];
            System.out.println("i:" + i);
            System.out.println("num:" + num);
            if (num < target) {
                i = mid_index;
                lowerBorder = mid_index;
            } else if (num > target) {
                mid_index = mid_index / 2;
            }
            if (num == target) {
                index = mid_index;
                flag = 1;
                break;
            }
        }
        if (flag == 1) return index;
        else return -1;
    }
}

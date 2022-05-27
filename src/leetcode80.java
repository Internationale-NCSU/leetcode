public class leetcode80 {
    public static int removeDuplicates(int[] nums) {
        int curNum = Integer.MIN_VALUE;
        int len = 0;
        int count = 0;
        for (int head=0,rear=0; rear < nums.length; rear++) {
            if(nums[rear]!=curNum){
                curNum=nums[rear];
                nums[head] = nums[rear];
                head++;
                count = 0;
            }else if(count==0){
                count=1;
                nums[head] = nums[rear];
                head++;
            }
            len = head;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}

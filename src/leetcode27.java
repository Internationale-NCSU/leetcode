public class leetcode27 {
    public static int removeElement(int[] nums, int val) {
        int front = 0,rear = 0;
        while(rear<nums.length){
            nums[front] = nums[rear];
            if(nums[rear]!=val){
                front++;
                rear++;
            }else {
                rear++;
            }
        }
        return front;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,1,3,4},3));
    }
}

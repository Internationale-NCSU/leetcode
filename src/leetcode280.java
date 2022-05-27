import java.util.Arrays;

public class leetcode280 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        boolean isFront = true;
        int index = 0;
        int front = 0,rear = nums.length-1;
        while(index<nums.length){
            if(isFront){
                result[index] = nums[front];
                front++;
            }else {
                result[index] = nums[rear];
                rear--;
            }
            index++;
            isFront = !isFront;
        }
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = result[i];
        }
    }
    public static void main(String[] args) {

    }
}

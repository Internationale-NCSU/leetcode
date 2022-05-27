import java.util.Arrays;

public class leetcode189 {
    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        int len = nums.length;
        int[] arr = new int[len];
        int p = 0;
        for (int i = len-k; i < len; i++) {
            arr[p] = nums[i];
            p++;
        }
        int offset = p;
        while(p<arr.length){
            arr[p] = nums[p-offset];
            p++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};
        rotate(arr,4);
    }

}

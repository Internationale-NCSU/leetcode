import java.util.Arrays;

public class leetcode238 {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean containsZero = false;
        boolean containsZeroTwice = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                product *= nums[i];
            }else if(!containsZero){
                containsZero = true;
            }else {
                containsZeroTwice  = true;
            }
        }
        int[] result = new int[nums.length];
        if(containsZeroTwice){
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            if(containsZero) {
                result[i] = nums[i] == 0 ? product : 0;
            }else {
                result[i] = product/nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4};
        int[] result = productExceptSelf(nums);
        Arrays.stream(result).forEach(
                (a)->{
                    System.out.print(a+",");
                }
        );
    }
}

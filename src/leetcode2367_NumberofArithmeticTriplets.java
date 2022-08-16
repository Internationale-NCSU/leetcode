import org.junit.Test;

public class leetcode2367_NumberofArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {

        int count = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k]-nums[j]==diff&&nums[j]-nums[i]==diff){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(arithmeticTriplets(new int[]{0,1,4,6,7,10},3));
    }
}

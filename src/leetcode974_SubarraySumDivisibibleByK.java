import org.junit.Test;

public class leetcode974_SubarraySumDivisibibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < prefixSum.length-1; i++) {
            for (int j = i+1; j < prefixSum.length; j++) {
                if((prefixSum[j]-prefixSum[i])%k==0){
                    count++;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}

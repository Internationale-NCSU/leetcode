import org.junit.Test;

public class leetcode6234NumberOfSubarraysWithLCMEqualToK {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for (int start = 0;start<nums.length; start++) {
            if(k%nums[start]!=0){
                continue;
            }
            int largest = 0;

            for (int end = start; end< nums.length; end++){
                if(k%nums[end]!=0){
                    break;
                }
                largest = Math.max(largest,nums[end]);
                if(findLCM(largest,nums[end])==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int findLCM(int a,int b){
        return a*b/findLCF(a,b);
    }
    public int findLCF(int a,int b){
        if(a%b == 0){
            return b;
        }else{
            return findLCF(b,a%b);
        }

    }
    @Test
    public void  test(){
        System.out.println(subarrayLCM(new int[]{1,11,1,8},11));
    }
}

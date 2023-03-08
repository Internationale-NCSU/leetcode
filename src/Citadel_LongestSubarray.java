import org.junit.Test;

public class Citadel_LongestSubarray {
    public int maxLength(int[] arr, int k){
        int[] prefixSum = new int[arr.length+1];
        for (int i = 1; i < arr.length+1; i++) {
            prefixSum[i] = arr[i-1]+prefixSum[i-1];
        }
        int maxLen = arr.length;
        int left = 0, right = arr.length;
        while (left<=right&&left<arr.length&&right>0){
            if(prefixSum[right]-prefixSum[left]<=k){
                return maxLen;
            }else {
                maxLen--;
                if(arr[left]>arr[right-1]){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return -1;
    }
    @Test
    public void test(){
        System.out.println(maxLength(new int[]{9,9,9,9,1,1,2,2,4,5},6));
    }
}

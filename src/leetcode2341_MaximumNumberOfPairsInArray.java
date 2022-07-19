import org.junit.Test;

public class leetcode2341_MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        boolean[] marks = new boolean[101];
        int[] result = new int[2];
        result[1] = nums.length;
        for (int i = 0; i < nums.length ; i++) {
            if(!marks[nums[i]]){
                marks[nums[i]]=true;
            }else {
                marks[nums[i]]=false;
                result[0]++;
                result[1] = result[1]-2;
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(numberOfPairs(new int[]{1,3,2,1,3,2,2})[0]);
    }
}

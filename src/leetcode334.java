import org.junit.Test;

public class leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num<=min1){
                min1 = num;
            }else if(num<min2) {
                min2 = num;
            }
            if(num>min2){
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
    }

}

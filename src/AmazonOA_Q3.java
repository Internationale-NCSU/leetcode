import org.junit.Test;

public class AmazonOA_Q3 {
    long findMinHealth(int[] power, int armor){
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < power.length; i++) {
            sum = sum+power[i];
            max = Math.max(max,power[i]);
        }
        armor = max>armor?armor:max;
        return (sum-armor)+1;
    }
    @Test
    public void test(){
        System.out.println(findMinHealth(new int[]{2,5,4,3},7));
    }
}

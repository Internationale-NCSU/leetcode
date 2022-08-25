import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode991_BrokenCalculator {
    Map<Integer,Integer> memo = new HashMap<>();
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(startValue!=target){
            if(target%2==0){
                target/=2;
            }else {
                target+=1;
            }
            count++;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(brokenCalc(3,10));
    }
}

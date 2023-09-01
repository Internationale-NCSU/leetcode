import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode2834FindTheMinimumPossibleSumOfAbeautifulArray {
    public long minimumPossibleSum(int n, int target) {
        long sum = 0;
        int index = 1;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        while(count<n){
            if(!set.contains(target-index)){
                sum = sum+index;
                set.add(index);
                index++;
                count++;
            }else {
                index++;
            }
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(minimumPossibleSum(3,3));
    }
}

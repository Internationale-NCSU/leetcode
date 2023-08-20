import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode2829_DetermineTheMinimumSumOfAKAcoidingArray {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int num = 1;
        int sum = 0;
        while(count<n){
            if(!set.contains(k-num)){
                count++;
                sum = sum+num;
                set.add(num);
            }
            num++;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(minimumSum(2,6));
    }
}

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class leetcode528 {
    int[] prefix;
    int totalSum;
    private void Solution(int[] w) {
        prefix = new int[w.length];
        int weight = 0;
        for (int i = 0; i < w.length; i++) {
            weight = weight+w[i];
            prefix[i] = weight;
        }
        this.totalSum = weight;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        while(i<prefix.length){
            if(target<prefix[i]){
                return i;
            }
            i++;
        }
        return i;
    }
    @Test
    public void test(){
        Solution(new int[]{1,2,3,4});
        System.out.println(pickIndex());
    }
}

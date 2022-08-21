import org.junit.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode2168_UniqueSubstringsWithEqualDigitFrequency {
    public int equalDigitFrequency(String s) {
        Set<String> set = new HashSet<>();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[10];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j)-'0']++;
                if(checkValid(count)){
                    set.add(s.substring(i,j+1));
                }
            }
        }
        return set.size();
    }
    boolean checkValid(int[] digitsCount){
        int[] tmp = Arrays.copyOf(digitsCount,digitsCount.length);
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length-1; i++) {
            if(tmp[i]==0){
                continue;
            }else if(tmp[i]!=tmp[i+1]) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(equalDigitFrequency("12321"));
    }
}
